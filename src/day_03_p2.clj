(ns day-03-p2)

(defn read-file [f]
  (-> (slurp f)
      (clojure.string/split-lines)))

(defn char->int
  [c]
  (- (int c) 48))

(defn string->digits
  [s]
  (map char->int s))

(defn max-batteries-p2
  [bank]
  (let [digits (string->digits bank)
        n (count digits)
        k 12
        to-drop (- n k)]
    (if (neg? to-drop)
      (parse-long bank)
      (loop [remaining digits
             stack []
             drops-left to-drop]
        (prn stack)
        (if (empty? remaining)
          (parse-long (apply str (take k stack)))
          (let [digit (first remaining)]
            (if (and (pos? drops-left)
                     (seq stack)
                     (> digit (peek stack)))
              (recur remaining (pop stack) (dec drops-left))
              (recur (rest remaining) (conj stack digit) drops-left))))))))

(defn solve [filename]
  (->> (read-file filename)
       (map max-batteries-p2)
       (reduce +)))