(ns crawler.core
  (:require [crawler.service.core :refer [get-okky]]))

(defn -main []
  (println (get-okky "392686")))