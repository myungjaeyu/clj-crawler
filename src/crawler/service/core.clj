(ns crawler.service.core
  (:require [clj-http.client :as client]
            [crawler.parser.core :as parser]))

(defn get-okky [no]
  (let [dom (parser/body 
             (client/get (str "https://okky.kr/article/" no)))]
    {:no no
     :title (parser/board-title dom)
     :writer (parser/board-writer dom)
     :content (parser/board-content dom)}))