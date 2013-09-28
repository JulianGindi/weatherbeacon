(defproject weatherbeacon "0.1.0-SNAPSHOT"
  :description "Easy-to-use, natural languag weather api"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [compojure "1.1.5"]]
  :plugins [[lein-ring "0.8.5"]]
  :ring {:handler weatherbeacon.handler/app}
  :profiles
  {:dev {:dependencies [[ring-mock "0.1.5"]]}})
