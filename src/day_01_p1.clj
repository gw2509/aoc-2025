(ns day-01-p1)

(defn read-file [f]
  (-> (slurp f)
      (clojure.string/split-lines)))

(defn rotation->direction
  [r]
  (let [dir (first r)
        num (parse-long (apply str (rest r)))]
    (if (= dir \L) (- num) num)))

(defn compute-next-position
  [prev rot]
  (let [dir (rotation->direction rot)
        pos (mod (+ prev dir) 100)]
    pos))

(defn rotate
  [input]
  (->> input
       (reduce
         (fn [acc rot] (let [pos (compute-next-position (first acc) rot)]
                         (if (zero? pos)
                           [pos (inc (last acc))]
                           [pos (last acc)])))
         [50 0])))

(defn solve []
  (->> (rotate (read-file "resources/day01/input.txt"))
       last))