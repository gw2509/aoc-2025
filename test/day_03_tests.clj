(ns day-03-tests
  (:require [clojure.test :refer [deftest testing is]]
            [day-03-p1 :refer [max-batteries]]
            [day-03-p2 :refer [max-batteries-p2]]))


(deftest max-batteries_p1_test_1
  (testing "check against example input"
    (is (= 98 (max-batteries "987654321111111")))
    (is (= 89 (max-batteries "811111111111119")))
    (is (= 78 (max-batteries "234234234234278")))
    (is (= 92 (max-batteries "818181911112111")))
    (is (= 357 (day-03-p1/solve "resources/day03/test-input.txt")))
    (is (= 17281 (day-03-p1/solve "resources/day03/input.txt")))))

(deftest max-batteries_p2_test_1
  (testing "check against example input"
    (is (= 987654321111 (max-batteries-p2 "987654321111111")))))

(deftest max-batteries_p2_test_2
  (testing "check against example input"
    (is (= 811111111119 (max-batteries-p2 "811111111111119")))))