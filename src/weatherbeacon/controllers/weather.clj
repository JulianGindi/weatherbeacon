(ns weatherbeacon.controllers.weather
  (:use [compojure.core :only (defroutes GET POST)])
  (:require [clojure.string :as str]
            [ring.util.response :as ring]
            [weatherbeacon.views.main :as views]
            [weatherbeacon.helpers.geocode :as geocoder]
            [weatherbeacon.helpers.forcast :as forcast]
            [weatherbeacon.helpers.naturallanguage :as nl]))

(defn index []
  (views/index-view))

(defn get-weather [location]
  (let [coordinates (geocoder/return-coordinates location)
        weather-data (forcast/get-weather-for-location coordinates)]
    (views/location-data-view (str weather-data))))

(defn weather-query [query-string]
  (let [weather-input (nl/classify-query (str "Will it rain Monday?"))]
    (views/query-view (str weather-input))))


(defroutes routes
  (GET "/" [] (index))
  (GET "/weather/:location" [location] (get-weather location))
  (GET "/query/:query" [query] (weather-query query)))
