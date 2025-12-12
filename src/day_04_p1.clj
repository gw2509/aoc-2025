(ns day-04-p1)

(defn read-file [f]
  (-> (slurp f)
      (clojure.string/split-lines)))

(def grid (mapv vec (read-file "resources/day04/input.txt")))

(defn get-neighbors
  [coords]
  (let [[x y] coords]
    (if (= \@ (get-in grid [x y]))
      (map (fn [[dx dy]]
             (if (= \@ (get-in grid [(+ x dx) (+ y dy)]))
               1
               0))
           (for [x (range -1 2) y (range -1 2)] [x y]))
      '())))

(defn solve []
  (let [grid-w (count (grid 1))
        grid-h (count grid)]
    (->>
      (map get-neighbors (for [x (range grid-w) y (range grid-h)] [x y]))
      (map #(dec (apply + %)))
      (filter (some-fn zero? pos?))
      (filter #(< % 4))
      count)))
