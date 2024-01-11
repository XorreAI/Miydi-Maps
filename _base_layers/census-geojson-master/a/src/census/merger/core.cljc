(ns census.merger.core
  (:require
   #?(:cljs [cljs.core.async
             :refer [>! <! chan promise-chan close! to-chan!]
             :refer-macros [go alt!]]
      :clj [clojure.core.async
            :refer [>! <! chan promise-chan close! to-chan! go alt!]])
   [net.cgrand.xforms :as x]
   [census.utils.core :refer [amap-type]]))


(defn deep-merge-a-coll
  "Takes a collection of maps and applies a deep 'merge-with' on any nested maps."
  [maps]
  (apply merge-with
         (fn [& args]
           (if (every? map? args)
             (deep-merge-a-coll args)
             (last args)))
         maps))


(defn remove-unmerged
  "
  Transducer, which takes 2->3 keys that serve to filter a merged list of two
  maps to return a function, which returns a list of only those maps which have
  a key from both maps - with the key that was used to merge them omitted. 
  The presence of both keys within the map signifies that
  the maps have merged. This ensures the returned list contains only the overlap
  between the two, i.e., excluding non-merged maps.
  "
  [IDS]
  (fn [m]
    (let [[[_ v]] (x/into [] m)]
      (when (not-any? nil? (map (get v :properties) IDS)) v))))


;;FIXME: Make X Platform (.cljc) compatible
(defn xf<-Grands->JS
  "Named after @cgrand (author of the xforms library), this is a composed
  transducer, which fits into a higher-order transducer. This lower-order
  transducer is applied to a vector of maps, which are grouped into that vector
  by the xforms library `by-key` function. This transducer merges together and
  filters the grouped maps to preserve only maps, which were merged."
  [IDS]
  (comp (x/into [])
        (map deep-merge-a-coll)
        (map (remove-unmerged IDS))
        (map clj->js)))


(defn xf-Grands-M->JSON
  "
  Implementation of `group-by` (produces a map) via @cgrand's `xforms`, which
  takes a collection of unique IDs and returns a transducer, which can be applied
  to a concatenated vector of maps to merge them and filter out those items that
  were not merged.
  "
  [IDS]
  (comp (x/by-key keys (xf<-Grands->JS IDS))
        (remove   (fn [[_ v]] (nil? v)))
        (map      #(get % 1))))

;;FIXME: Make X Platform (.cljc) compatible
(defn I=OE-M-spooler
  "The heart of the merge functionality. This function has three steps:
  1) Configuration and arguments are input, which returns a function
  2) That function takes and output and error channel and sets up a loop
  3) The loop's base case is when there's non more `cfgs` to do, but any error
  in pulling in the data results in a short circuit of the loop. If everything
  goes smoothly, will return a GeoJSON FeatureCollection with data from multiple
  sources being merged into the 'properties'."
  [$g$ =arg= cfgs]
  (fn [=O= =E=]
    (let [=args= (promise-chan)]
      (go (>! =args= (<! =arg=))
          (let [=cfg= (chan 1)
                $ids$ (atom [])]
            (loop [todo cfgs
                   [cfg ?=$g$] (first cfgs)
                   acc (transient [])]
              (if (nil? (first todo))
                (do (prn "Merging GeoJSON with Statistics...")
                    (>! =O= (->> (persistent! acc)
                                 (reduce concat)
                                 (eduction (xf-Grands-M->JSON @$ids$))
                                 into-array
                                 (js-obj "type" "FeatureCollection" "features")))
                    (close! =cfg=)
                    (close! =args=))
                (do (if ?=$g$
                      ((cfg $g$) =args= =cfg=)
                      (cfg =args= =cfg=))
                    (let [{:keys [getter url xform filter-id] :as cfg} (<! =cfg=)]
                      (if (= (type cfg) amap-type)
                        (let [=xform= (chan 1 xform)
                              =err=   (chan 1)]
                          (swap! $ids$ conj filter-id)
                          (getter (to-chan! [url]) =xform= =err=)
                          (alt! =xform= ([data] (do
                                                  (close! =xform=)
                                                  (close! =err=)
                                                  (recur (rest todo)
                                                         (second todo)
                                                         (conj! acc data))))
                                =err= ([err] (do (>! =E= err)
                                                 (close! =cfg=)
                                                 (close! =O=)
                                                 (close! =args=)
                                                 (close! =xform=)
                                                 (close! =err=))))))
                      (do (>! =E= cfg)
                          (close! =cfg=)
                          (close! =O=)
                          (close! =args=) ; Close up shop...
                          (close! =E=)))))))))))



