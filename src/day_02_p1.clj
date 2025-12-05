(ns day-02-p1
  (:require [clojure.string :as str]))

(defn number-len
  [n]
  (int (+ 1 (Math/floor (Math/log10 n)))))

(defn invalid-id?
  [n]
  (let [len (number-len n)]
    (if (odd? len)
      false
      (condp = len
        2 (= (rem n 10) (/ (- n (rem n 10)) 10))
        4 (= (rem n 100) (/ (- n (rem n 100)) 100))
        6 (= (rem n 1000) (/ (- n (rem n 1000)) 1000))
        8 (= (rem n 10000) (/ (- n (rem n 10000)) 10000))
        10 (= (rem n 100000) (/ (- n (rem n 100000)) 100000))
        false))))

(defn solve []
  (-> (slurp "resources/day02/input.txt")
      (str/split #",")
      (->> (map #(str/split % #"-"))
           (map #(range (parse-long (first %)) (inc (parse-long (last %)))))
           (flatten)
           (map #(if (invalid-id? %) %))
           (filter identity)
           (reduce +))))