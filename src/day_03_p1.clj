(ns day-03-p1)

(defn read-file [f]
  (-> (slurp f)
      (clojure.string/split-lines)))

(defn char->int
  [c]
  (- (int c) 48))

(defn string->digits
  [s]
  (map char->int s))

(defn max-batteries
  [bank]
  (let [digits (string->digits bank)
        candidates (butlast digits)
        max-l (apply max candidates)
        remaining (rest (drop-while #(not= max-l %) digits))
        max-r (apply max remaining)
        joltage (+ (* max-l 10) max-r)]
    joltage))

(defn solve [filename]
  (->> (read-file filename)
       (map max-batteries)
       (reduce +)))