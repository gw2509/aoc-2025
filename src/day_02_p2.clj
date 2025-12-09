(ns day-02-p2
  (:require [clojure.string :as str]))

(defn invalid-id? [i]
  (let [number-str (str i)]
    (some? (re-seq #"\b(\d+)\1+\b" number-str))))

(defn solve []
  (-> (slurp "resources/day02/input.txt")
      (str/split #",")
      (->> (map #(str/split % #"-"))
           (mapcat #(range (parse-long (first %)) (inc (parse-long (last %)))))
           (map #(if (invalid-id? %) %))
           (filter identity)
           (reduce +))))
