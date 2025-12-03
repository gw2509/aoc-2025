(ns day-01-p1)

(defn read-file [f]
  (-> (slurp f)
      (clojure.string/split-lines)))

(defn rotation->direction
  [r]
  (let [dir (first r)
        num (parse-long (clojure.string/trim (apply str (rest r))))]
    (if (= dir \L) (- num) num)))

(defn compute-next-position
  [prev rot]
  (let [dir (rotation->direction rot)
        pos (mod (+ prev dir) 100)]
    (prn prev rot dir pos)
    pos))

(defn rotate
  [input]
  (->> input
       (reduce
         (fn [acc rot] (conj acc (compute-next-position (last acc) rot)))
         [50])))

(defn solve []
  (->> (rotate (read-file "resources/test-input.txt"))
       (filter zero?)
       count))