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


(deftest five-point-someone-func
  (testing "when y is 5"
    (is (= :chetan-bhagat (five-point-someone 3 5))))
  (testing "when x is 5"
    (is (= :satan-bhagat (five-point-someone 5 3))))
  (testing "when x is greater than y"
    (is (= :greece (five-point-someone 7 6))))
  (testing "when any of conditions does not match"
    (is (= :universe (five-point-someone 10 10)))))


(deftest zero-aliases-func
  (testing "when param is 0"
    (is (= :zero (zero-aliases 0))))
  (testing "when param is empty vec"
    (is (= :empty (zero-aliases []))))
  (testing "when param is empty list"
    (is (= :empty (zero-aliases `()))))
  (testing "when param is empty string"
    (is (= :empty-string (zero-aliases ""))))
  (testing "when param is empty set"
    (is (= :empty-set (zero-aliases #{}))))
  (testing "when param is empty map"
    (is (= :empty-map (zero-aliases {}))))
  (testing "when param is non empty value"
    (is (= :not-zero (zero-aliases 6))))
  )


(deftest zero-separated-palindrome-func
  (testing "when collection is empty"
    (is (= `(0) (zero-separated-palindrome []))))
  (testing "when collection is not empty"
    (is (= `(4 3 2 0 2 3 4) (zero-separated-palindrome [1 2 3])))))