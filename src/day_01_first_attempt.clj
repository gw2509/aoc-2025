(ns day-01-first-attempt)

(def test-input ["L68"
                 "L30"
                 "R48"
                 "L5"
                 "R60"
                 "L55"
                 "L1"
                 "L99"
                 "R14"
                 "L82"])

(defn read-file [f]
  (-> (slurp f)
      (clojure.string/split-lines)))

(defn rotation->direction
  [r]
  (let [dir (first r)
        num (parse-long (clojure.string/trim (apply str (rest r))))]
    (if (= dir \L)
      (unchecked-negate num)
      num)))

(defn compute-passes
  [prev pos dir]
  (if (and (neg? dir) (neg? pos))
    (let [passes (abs (quot pos 100))]
      (if (or (zero? prev) (zero? (mod pos 100)))
        passes
        (inc passes)))
    (if (and (pos? dir) (> pos 100))
      (let [passes (quot pos 100)]
        (if (zero? prev)
          passes
          passes)))))

(defn compute-next-position
  [prev rot]
  (let [dir (rotation->direction rot)
        pos (+ prev dir)
        pas (or (compute-passes prev pos dir) 0)]
    (prn prev rot dir pos pas)
    [pos pas]))

(defn rotate
  [input]
  (->> input
       (reduce
         (fn [acc rot] (let [[pos passes] (compute-next-position (last acc) rot)]
                         (-> acc
                             (into (repeat passes 0))
                             (conj (mod pos 100)))))
         [50])))

(defn solve []
  (->> (rotate (read-file "resources/day01/test-input.txt"))
       (filter zero?)
       count))






