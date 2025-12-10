(ns day-03-tests
  (:require [clojure.test :refer [deftest testing is]]
            [day-03-p1 :refer [max-batteries solve]]))

(deftest max-batteries_test_1
  (testing "check against example input"
    (is (= 98 (max-batteries "987654321111111")))
    (is (= 89 (max-batteries "811111111111119")))
    (is (= 78 (max-batteries "234234234234278")))
    (is (= 92 (max-batteries "818181911112111")))
    (is (= 357 (solve "resources/day03/test-input.txt")))
    (is (= 17281 (solve "resources/day03/input.txt")))))
