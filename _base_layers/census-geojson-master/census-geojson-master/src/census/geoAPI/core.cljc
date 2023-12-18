(ns census.geoAPI.core
  "wrapper over GeoJSON API - S3 bucket"
  {:clj-kondo/config {:linters {:conflicting-fn-arity {:level :info}}}}
  (:require
   #?(:cljs [cljs.core.async   :refer [chan to-chan! take! put! pipe]]
      :clj [clojure.core.async :refer [chan to-chan! take! put! pipe]])
   [cuerdas.core       :refer [join]]
   #?(:cljs [defun.core :refer-macros [defun]]
      :clj [defun.core  :refer [defun]])
   [census.utils.core  :refer [URL-GEOJSON
                               xf<< educt<< $GET$
                               map-over-keys keys->strs]]))

(defn G-err-payload
  "Payload for G-err function"
  [$g$ res vin lev]
  (let [js-name (keys->strs (name lev))
        e-gen [(str "No GeoJSON found for: '" js-name "'")
               (str "at this scope in vintage: " vin)
               (str "at resolution: " res)]]
    (when-let [vins (get-in $g$ [lev])]
      (let [e-try
            [""
             (str "For '" js-name "' try one of the following:")
             (str "=== :us = nation-level '" js-name "' geoResolutions ===")
             (str "=== :st = state-levels '" js-name "' geoResolutions ===")]

            e-scopes (->> (vec (map-over-keys #(get-in % [:scopes]) vins))
                          sort)
            e-NA ["" "=== available geoHierarchy levels ==="]
            e-avail (vec (map #(keys->strs (name (key %))) $g$))]
        {:intro e-gen
         :try-next e-try
         :scopes-available e-scopes
         :outro e-NA
         :geos-available e-avail}))))

(defn G-err
  "Tries to log a useful error given a user's invalid input. Sends empty string
  downstream."
  [$g$ res vin lev]
  (let [todo (G-err-payload $g$ res vin lev)]
    (doseq [[k v] todo] (doseq [_v v] (prn _v)))))

(defn G-pattern->url
  "Composes a URL to call raw GeoJSON files hosted on Github"
  ([res vin lev] (G-pattern->url res vin lev nil))
  ([res vin lev st]
   (if (nil? st)
     (str (join "/" [URL-GEOJSON res vin (name lev)]) ".json")
     (str (join "/" [URL-GEOJSON res vin st (name lev)]) ".json"))))

(defn scope
  "Consumes the patterner's pattern and configures GeoJSON URL to use the proper
  state scoping, if applicable."
  ([$g$ res vin lev USr]     (scope $g$ res vin lev USr nil))
  ([$g$ res vin lev USr STr] (scope $g$ res vin lev USr STr nil))
  ([$g$ res vin lev USr STr st]
   (let [STr? (not (nil? (some #(= res %) STr)))
         USr? (not (nil? (some #(= res %) USr)))
         st?  (not (nil? st))
         us?  (nil? st)]
     (cond
       (and st? STr?) (G-pattern->url res vin lev st) ;asks for state, state available
       (and us? USr?) (G-pattern->url res vin lev)    ;asks for us, us available
       (and (and st? USr?) (not STr?)) (G-pattern->url res vin lev)    ;asks for state, state unavailable, us available
       :else (G-err $g$ res vin lev)))))

(defn big-G
  "logs a warning that the request being made is large."
  ([$g$ res vin lev USr]     (big-G $g$ res vin lev USr nil))
  ([$g$ res vin lev USr STr] (big-G $g$ res vin lev USr STr nil))
  ([$g$ res vin lev USr STr st]
   (let [strs
         ["Warning, you are about to make a large GeoJSON request."
          "This may take some time -> consider local data caching."
          "The response may also cause VM heap capacity overflow."
          "On Node use `--max-old-space-size=4096`"]]
     (do (doseq [s strs] (prn s))
         (scope $g$ res vin lev USr STr st)))))

#_:clj-kondo/ignore
(defun G-patterner
  "Takes a pattern of maps and triggers the URL builder accordingly."
  ; new :xref functionality (decennial cross-referencing for redundant cartographic file locations)
  ([$g$ [res    _   sta lev-tuple {:xref XRvin}]]
   (G-patterner $g$ [res XRvin sta lev-tuple (get-in $g$ [(first lev-tuple) (keyword XRvin) :scopes])]))

  ([$g$ ["500k" vin nil [:zip-code-tabulation-area _] {:us USr :st nil}]]
   (big-G $g$ "500k" vin :zip-code-tabulation-area USr))

  ([$g$ [(res :guard #(not (= "500k" %))) vin _ [:zip-code-tabulation-area _] _]]
   (G-err $g$ res vin :zip-code-tabulation-area))

  ([$g$ [res    vin nil [:county _] {:us USr :st nil}]] (big-G $g$ res vin :county USr))
  ([$g$ [res    vin _   [lev _]     nil]]               (G-err $g$ res vin lev))
  ([$g$ [res    vin nil [lev _]     {:us nil :st _}]]   (G-err $g$ res vin lev))
  ([$g$ [res    vin "*" [lev _]     {:us nil :st _}]]   (G-err $g$ res vin lev))
  ([$g$ [res    vin nil [lev _]     {:us USr :st _}]]   (scope $g$ res vin lev USr))
  ([$g$ [res    vin "*" [lev _]     {:us USr :st _}]]   (scope $g$ res vin lev USr))
  ([$g$ [res    vin _   [lev _]     {:us USr :st nil}]] (scope $g$ res vin lev USr))
  ([$g$ [res    vin sta [lev _]     {:us USr :st STr}]] (scope $g$ res vin lev USr STr sta))
  ([$g$ & anthing-else]                                                   ""))

(defn G-pattern-cfg
  "
  Creates a configuration for GeoJSON URL construction based on user input and geoKeyMap
  configuration file (EDN).
  "
  [$g$ {:keys [vintage geoResolution] {:keys [state] :as geoHierarchy} :geoHierarchy}]
  (let [level     (last geoHierarchy)
        ; need to grab additional `:xref` data within `:scopes` to facilitate
        ; 2021+ vintage references to decennial cartographic files
        geoScopes (get-in $g$ [(key level) (keyword vintage) :scopes])
        pattern   [geoResolution vintage state level geoScopes]]
    pattern))

(defn C-G-pattern->url
  [$g$ args]
  (->> (G-pattern-cfg $g$ args)
       (G-patterner $g$)))

(def $url$ (atom ""))
(def $res$ (atom []))
(def $err$ (atom {}))

; uses :raw format to prevent unnecessary translation because this is just a passthrough = no merging
(def $GET$-C-GeoJSON ($GET$ :raw "Census GeoJSON" $url$ $res$ $err$ :cors))

(defn IOE-C-GeoJSON
  "Internal function for calling cartography 'API' for GeoJSON"
  [$g$]
  (fn [=I= =O= =E=]
    (take! =I=
           (fn [args]
             (let [url (C-G-pattern->url $g$ args)
                   =str= (chan 1)] ;(map js/console.log ))] ;(map js/JSON.parse))]
               (if (= "" url)
                 (put! =E= "Invalid GeoJSON request. Please check arguments against requirements.")
                 (do ($GET$-C-GeoJSON (to-chan! [url]) =str= =E=)
                     (pipe =str= =O=))))))))


;;    88~\                                                            /
;;  _888__  e88~-_  888-~\       888-~88e-~88e  e88~~8e  888-~\ e88~88e  e88~~8e
;;   888   d888   i 888          888  888  888 d888  88b 888    888 888 d888  88b
;;   888   8888   | 888          888  888  888 8888__888 888    "88_88" 8888__888
;;   888   Y888   ' 888          888  888  888 Y888    , 888     /      Y888    ,
;;   888    "88_-~  888          888  888  888  "88___/  888    Cb       "88___/
;;                                                               Y8""8D


(defn GEOIDS<-$g$+args
  "
  Takes the request argument and pulls out a vector of the component identifiers
  from the geoKeyMap, which is used to construct the UID for the GeoJSON. Used
  in deep-merging with statistics.

  Returns a list of keys to lookup (:id<-json) within the returned GeoJSON to
  concatenate into the GEOID
  "
  [$g$ {:keys [geoHierarchy vintage]}]
  (let [[& GEOIDS] (get-in $g$ [(key (last geoHierarchy)) (keyword vintage) :id<-json])]
    GEOIDS)) ;; <- Note: These args are returned as a '() list...

(defn xf-mergeable-features
  "
  Takes the component GEOIDS from with a GeoJSON feature ('properties' key)
  to generate the GEOID string for the GeoJSON feature.
  "
  [$g$ args]
  (let [GEOIDS (GEOIDS<-$g$+args $g$ args)]
    (xf<< (fn [rf acc this]
            (rf acc {(apply str (map (:properties this) GEOIDS))
                     this})))))

(defn xf-mergeable<-GeoCLJS
  "
  Transducer, which reshapes a GeoJSON 'FeatureCollection' into a shape that's
  mergable with other data. Shape = [{'GEOID' {:properties & kvs {& kvs }}}}]
  "
  [$g$ args]
  (comp
   (map #(get % :features)) ; turns a single map into a collection
   (educt<< (xf-mergeable-features $g$ args))))

(def $url-3$ (atom ""))
(def $res-3$ (atom []))
(def $err-3$ (atom {}))

(def $GET$-C-GeoCLJ ($GET$ :json "Census GeoJSON (for merge)" $url-3$ $res-3$ $err-3$ :cors))


(defn =cfg=C-GeoCLJ
  "
  Internal function for calling Github cartography 'API' for GeoJSON
  "
  [$g$]
  (fn [=args= =cfg=]
    (take! =args=
           (fn [args]
             (let [url   (C-G-pattern->url        $g$ args)
                   xform (xf-mergeable<-GeoCLJS   $g$ args)
                   g-key (first (GEOIDS<-$g$+args $g$ args))]
               (if (= "" url)
                 (put! =cfg= "Invalid GeoJSON request. Please check arguments against requirements.")
                 (put! =cfg= {:url       url
                              :xform     xform
                              :getter    $GET$-C-GeoCLJ
                              :filter-id g-key})))))))

(def cfg>cfg=C-GeoCLJ [=cfg=C-GeoCLJ true])
