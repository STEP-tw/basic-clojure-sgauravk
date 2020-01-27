(ns assignments.conditions-test
  (:require [clojure.test :refer :all]
            [assignments.conditions :refer :all]))

(deftest safe-division
  (testing "non zero denominator"
    (is (= 2 (safe-divide 4 2))))
  (testing "zero denominator"
    (is (nil? (safe-divide 3 0)))))


(deftest informative-division
  (testing "non zero denominator"
    (is (= 6 (informative-divide 6 1))))
  (testing "zero denominator"
    (is (= :Infinite (informative-divide 3 0)))))


(deftest harishchandra-function
  (testing "true value"
    (is (= 2 (harishchandra 2))))
  (testing "false value"
    (is (= nil (harishchandra (zero? 1))))))


(deftest yudishtira-function
  (testing "true value"
    (is (= 2 (yudishtira 2))))
  (testing "false value"
    (is (= :Ashwathama (yudishtira false)))))


(deftest duplicate-first-func
  (testing "when collection is empty"
    (is (= nil (duplicate-first []))))
  (testing "when collection is not empty"
    (is (= [1 1 2 3] (duplicate-first [1 2 3])))))
