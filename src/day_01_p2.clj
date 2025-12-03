(ns day-01-p2)

(defn read-file [f]
  (-> (slurp f)
      (clojure.string/split-lines)))

(defn rotation->direction
  [r]
  (let [dir (first r)
        num (parse-long (apply str (rest r)))]
    (if (= dir \L) (- num) num)))

(defn rotate
  [input]
  (->> input
       (reduce
         (fn [acc rot] (let [[cur-pos n-visits] acc
                             dir (rotation->direction rot)
                             pos (+ cur-pos dir)
                             new-pos (mod pos 100)]
                         [new-pos (+ n-visits (cond
                                                (zero? pos) 1
                                                (neg? pos) (if (> cur-pos 0)
                                                             (inc (abs (quot pos 100)))
                                                             (abs (quot pos 100)))
                                                :default (abs (quot pos 100))))]))

         [50 0])))

(defn solve []
  (->> (rotate (read-file "resources/input.txt"))
       last))


;; 3130 x
;; 2702 x
;; 6554 pass
