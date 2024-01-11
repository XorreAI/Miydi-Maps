(ns test.utils.tests
  (:require
   [cljs.core.async     :refer [chan >! <! close! timeout]
    :refer-macros [go]]
   [cljs.test           :refer-macros [are deftest is are run-tests]]
   [test.fixtures.core  :refer [test-async]]
   [census.utils.core   :refer [map-rename-keys
                                map-over-keys
                                keys->strs
                                strs->keys
                                ->args
                                args->
                                isServer
                                cors-proxy
                                xf<<
                                xf!<<
                                educt<<
                                map-target
                                map-idcs-range
                                $GET$
                                =O?>-cb
                                filter-nil-tails]]))

;(deftest MAP-NODES-test
;  (is (= (MAP-NODES {:i 7 :c {:e {:h 6 :g 5 :f 4} :d 3} :a {:b 2}})
;         {:a {:b 2} :c {:d 3 :e {:f 4 :g 5 :h 6}} :i 7})))

; Rationalle: Inside a go-block, it seems that any map literals are immediately
; changed into `hash-map`, so the only way to preserve an `array-map` is to
; `let` bind the args into a variable before invoking the go-block

;(deftest deep-linked-map-test
;  (is (= (read-string
;           (pr-str
;             (deep-linked-map {:i 7 :c {:e {:h 6 :g 5 :f 4} :d 3} :a {:b 2}})))
;         (read-string
;           "#linked/map[[:i 7]
;                        [:c #linked/map[[:e #linked/map[[:h 6] [:g 5] [:f 4]]] [:d 3]]]
;                        [:a #linked/map[[:b 2]]]]"))))

(deftest is-server-url
  (is (= isServer true)))

(deftest map-rename-keys-test
  (is (= (map-rename-keys name {:a "b" :c "d"})
         {"a" "b", "c" "d"})))


(deftest map-over-keys-test
  (is (= (map-over-keys inc {:a 1 :b 2})
         {:a 2 :b 3}))
  (is (= (map-over-keys #(get-in % [:scopes]) {:k1 {:scopes [1 2]
                                                    :butt {:k "v"}}
                                               :k2 {:scopes [3 4]
                                                    :bottom {:k "s"}}})
         {:k1 [1 2], :k2 [3 4]}))) ; {:k1 [1 2], :k2 [3 4]}

(deftest keys->strs-test
  (is (= (keys->strs (name :american-indian-area!alaska-native-area-_reservation-or-statistical-entity-only_-_or-part_))
         "american indian area/alaska native area (reservation or statistical entity only) (or part)")))

(deftest strs->keys-test
  (is (= (keyword
          (strs->keys "american indian area/alaska native area (reservation or statistical entity only) (or part)"))
         :american-indian-area!alaska-native-area-_reservation-or-statistical-entity-only_-_or-part_))
  (is (= (mapv strs->keys ["B01001_001E"
                           "NAME"
                           "B00001_001E"
                           "state"
                           "state legislative district (upper chamber)"])
         ["B01001_001E"
          "NAME"
          "B00001_001E"
          "state"
          "state-legislative-district-_upper-chamber_"])))

(deftest $GET$-json-test
  (let [=url= (chan 1)
        =res= (chan 1)
        =err= (chan 1)
        url (atom "")
        res (atom [])
        err (atom {})]
    (test-async
     (go (>! =url= "https://api.census.gov/data/2016/acs/acs5/variables/B00001_001E.json")
         (($GET$ :json "JSON DATA" url res err) =url= =res= =err=)
         (close! =url=)
         (is (= (<! =res=)
                {:name "B00001_001E",
                 :label "Estimate!!Total",
                 :concept "UNWEIGHTED SAMPLE COUNT OF THE POPULATION",
                 :predicateType "int",
                 :group "B00001",
                 :limit 0,
                 :attributes "B00001_001EA"}))
         (close! =err=)
         (close! =res=)))))

(deftest $GET$-json-WMS-test
  (let [=url= (chan 1)
        =res= (chan 1)
        =err= (chan 1)
        url (atom "")
        res (atom [])
        err (atom {})]
    (test-async
     (go (>! =url= "https://tigerweb.geo.census.gov/arcgis/rest/services/TIGERweb/tigerWMS_ACS2016/MapServer/82/query?geometry=-80.7214,28.2639&geometryType=esriGeometryPoint&inSR=4269&spatialRel=esriSpatialRelIntersects&returnGeometry=false&f=json&outFields=STATE")
         (($GET$ :json "JSON DATA" url res err) =url= =res= =err=)
         (close! =url=)
         (is (= (<! =res=)
                {:displayFieldName "BASENAME",
                 :fieldAliases {:STATE "STATE"},
                 :fields [{:name "STATE",
                           :type "esriFieldTypeString",
                           :alias "STATE",
                           :length 2}],
                 :features [{:attributes {:STATE "12"}}]}))
         (close! =err=)
         (close! =res=)))))


(deftest $GET$-edn-test
  (let [=url= (chan 1)
        =res= (chan 1)
        =err= (chan 1)
        url (atom "")
        res (atom [])
        err (atom {})]
    (test-async
     (go (>! =url= "https://raw.githubusercontent.com/uscensusbureau/citysdk/master/v2/src/configs/geojson/index.edn")
         (($GET$ :edn "EDN DATA" url res err) =url= =res= =err=)
         (close! =url=)
         (is (= (-> (<! =res=)
                    :alaska-native-regional-corporation
                    :2010
                    :id<-json)
                [:STATE :ANRC]))
         (close! =err=)
         (close! =res=)))))

(deftest $GET$-raw-test
  (let [=url= (chan 1)
        =res= (chan 1)
        =err= (chan 1)
        url (atom "")
        res (atom [])
        err (atom {})]
    (test-async
     (go (>! =url= "https://raw.githubusercontent.com/uscensusbureau/citysdk/master/v2/GeoJSON/500k/2021/04/school-district-_secondary_.json")
         (($GET$ :raw "RAW DATA" url res err) =url= =res= =err=)
         (close! =url=)
         (is (= (:type (js->clj (js/JSON.parse (<! =res=)) :keywordize-keys true))
                "FeatureCollection"))
         (close! =err=)
         (close! =res=)))))

(deftest =O?>-cb-test
  (let [=I= (chan 1)
        =O= (chan 1)
        =E= (chan 1)
        $r$ (atom "") ; needed for test result evaluation
        tfn (fn [=I= =O= =E=] (go (>! =O= (<! =I=))))
        Efn (fn [=I= =O= =E=] (go (>! =E= (<! =I=))))
        tcb (fn [E O] (if-let [err E]
                        (reset! $r$ err)
                        (reset! $r$ O)))]
    (test-async
     (go (>! =I= "went through internal =O=")
         (=O?>-cb tfn tcb =I= =O= =E=)
         (<! (timeout 500))
         (is (= @$r$
                "went through internal =O="))
         (>! =I= "error! from =E=")
         (=O?>-cb Efn tcb =I= =O= =E=)
         (<! (timeout 500))
         (is (= @$r$
                "error! from =E="))
         (close! =I=)
         (close! =O=)
         (close! =E=)))))

(deftest ->args-test
  (is (= (->args #js{"vintage" 2010,
                     "values" #js["H001001" "NAME"],
                     "sourcePath" #js["dec" "cd113"],
                     "geoHierarchy" #js{"american indian area/alaska native area (reservation or statistical entity only) (or part)" "R",
                                        "state" "01",
                                        "county subdivision" "93",
                                        "congressional district" "01",
                                        "american indian area/alaska native area/hawaiian home land (or part)" "2865"}})
         {:vintage "2010",
          :values ["H001001" "NAME"],
          :sourcePath ["dec" "cd113"],
          :geoHierarchy {:american-indian-area!alaska-native-area-_reservation-or-statistical-entity-only_-_or-part_ "R",
                         :state "01",
                         :county-subdivision "93",
                         :congressional-district "01",
                         :american-indian-area!alaska-native-area!hawaiian-home-land-_or-part_ "2865"}}))
  (is (= (->args #js{"vintage" 2015
                     "geoHierarchy" #js{"lat" 23.33
                                        "lng" -90.02}})
         {:vintage "2015", :geoHierarchy {:lat 23.33, :lng -90.02}}))
  (is (= (->args {:vintage 2010,
                  :values ["H001001" "NAME"],
                  :sourcePath ["dec" "cd113"],
                  :geoHierarchy {:county-subdivision "93",
                                 :congressional-district "01"}})
         {:vintage "2010"
          :values ["H001001" "NAME"]
          :sourcePath ["dec" "cd113"]
          :geoHierarchy {:county-subdivision "93"
                         :congressional-district "01"}})))

(deftest args->test
  (is (= (js->clj (args-> {:vintage "2010",
                           :values ["H001001" "NAME"],
                           :sourcePath ["dec" "cd113"],
                           :geoHierarchy {:american-indian-area!alaska-native-area-_reservation-or-statistical-entity-only_-_or-part_ "R",
                                          :state "01",
                                          :county-subdivision "93",
                                          :congressional-district "01",
                                          :american-indian-area!alaska-native-area!hawaiian-home-land-_or-part_ "2865"}}))
         (js->clj #js {"vintage" "2010"
                       "values" #js ["H001001" "NAME"]
                       "sourcePath" #js ["dec" "cd113"]
                       "geoHierarchy" #js {"american indian area/alaska native area (reservation or statistical entity only) (or part)" "R"
                                           "state" "01"
                                           "county subdivision" "93"
                                           "congressional district" "01"
                                           "american indian area/alaska native area/hawaiian home land (or part)" "2865"}}))))

(deftest map-target-test
  (is (= (map-target inc 0 [1 2 3])
         [2 2 3]))
  (is (= (map-target inc 1 [1 2 3])
         [1 3 3]))
  (is (= (map-target inc 2 [1 2 3])
         [1 2 4])))

(deftest map-idcs-range-test
  (is (= (map-idcs-range keyword [2 4] ["a" "b" "c" "d" "e" "f"])
         ["a" "b" :c :d "e" "f"])))

(deftest filter-nil-tails-test
  (are [in out] (= (filter-nil-tails in) out)
    {:state "01" :county nil :tract "*"} '([:state "01"] [:tract "*"])
    {:state nil :county "*"} '([:county "*"])))

;;(first {:state "01" :county nil :tract "*"})
(run-tests)





















