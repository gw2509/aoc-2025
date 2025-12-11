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
  "Greedy stack-based method"
  [bank]
  (let [digits (string->digits bank)
        n (count digits)
        len 12
        n-excess (- n len)]
    (loop [remaining digits
           kept-digits-stack []
           drops-left n-excess]
      (if (empty? remaining)
        (let [joltage (parse-long (apply str (take len kept-digits-stack)))]
          joltage)
        (let [digit (first remaining)]                      ; otherwise consider remaining digits
          (prn kept-digits-stack digit drops-left)
          (if (and (pos? drops-left)
                   (seq kept-digits-stack)
                   (> digit (peek kept-digits-stack)))
            (recur remaining                                ; don't keep digit
                   (pop kept-digits-stack)
                   (dec drops-left))
            (recur (rest remaining)                         ; keep digit
                   (conj kept-digits-stack digit)
                   drops-left)))))))

(defn solve [filename]
  (->> (read-file filename)
       (map max-batteries-p2)
       (reduce +)))