(ns crawler.parser.core
  (:require [net.cgrand.enlive-html :as html]
            [clojure.string :as string]))

(defn body [data]
  (-> (:body data)
      html/html-snippet))

(defn board-title [dom]
  (-> (html/select dom [:#content-body :.panel-title])
      first
      :content
      first
      string/trim))

(defn board-writer [dom]
  (-> (html/select dom [:.nickname])
      first
      :content
      first
      string/trim))

(defn board-content [dom]
  (->> (-> (html/select dom [:.content-text])
           first
           :content)
       (filter (fn [node]
                 (string? (first (:content node)))))
       (reduce (fn [acc node]
                 (str acc (first (:content node)) "\n")) "")))