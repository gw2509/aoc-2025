(ns day-02-tests
  (:require [clojure.test :refer [deftest testing is]]
            [day-02-p1 :refer [invalid-id? solve]]))

;; You can find the invalid IDs by looking for any ID which is
;; made only of some sequence of digits repeated TWICE.
;; So, 55 (5 twice), 6464 (64 twice), and 123123 (123 twice)
;; would all be invalid IDs.

(deftest invalid_id_test_1
  (testing "check against example invalid input"
    (is (every? true? (map invalid-id? [11 22 99 1010 1188511885 222222 446446 38593859])))))

(deftest invalid_id_test_2
  (testing "check against example valid input and some known valid IDs"
    (is (every? false? (map invalid-id? [0101 101 1 111 999 1698522])))))

(deftest solve_test
  (testing "check against the input"
    (is (= 43952536386 (solve)))))