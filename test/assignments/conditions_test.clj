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
    (is (= :not-zero (zero-aliases 6)))))


(deftest zero-separated-palindrome-func
  (testing "when collection is empty"
    (is (= `(0) (zero-separated-palindrome []))))
  (testing "when collection is not empty"
    (is (= `(4 3 2 0 2 3 4) (zero-separated-palindrome [1 2 3]))))
  (testing "when collection is not empty and not number"
    (is (= `(:a) (zero-separated-palindrome [:a])))))


(deftest order-in-words-func
  (testing "when x is y and y is greater than z"
    (is (= [:x-greater-than-y :y-greater-than-z] (order-in-words 4 3 2))))
  (testing "when x is y and z is greater than x"
    (is (= [:x-greater-than-y :z-greater-than-x] (order-in-words 4 3 5))))
  (testing "when z is greater than x"
    (is (= [:y-greater-than-z] (order-in-words 3 4 2))))
  (testing "when z is greater than x"
    (is (= [:z-greater-than-x] (order-in-words 2 3 4)))))


(deftest repeat-and-truncate-func
  (testing "should return list of 2 elements without repeating"
    (is (= '(1 2) (repeat-and-truncate [1 2 3] false false 2))))
  (testing "should return list of single element after truncating"
    (is (= '(1) (repeat-and-truncate [1 2 3] false true 2))))
  (testing "should return list of 5 repeated elements"
    (is (= '(1 2 3 1 2) (repeat-and-truncate [1 2 3] true false 5))))
  (testing "should return list of 5 elements after repeating and truncating"
    (is (= '(1 2 3 1 2) (repeat-and-truncate [1 2 3] true true 5)))))


(deftest conditions-apply-func
  (testing "should return wonder-woman when sequence contains 1 and 3"
    (is (= :wonder-woman (conditions-apply [0 1 0 3]))))
  (testing "should return durga when sequence contains :a :b and :c"
    (is (= :durga (conditions-apply [:a :b :e :c]))))
  (testing "should return cleopatra when sequence contains [2 3] and [4 5]"
    (is (= :cleopatra (conditions-apply [[0 0] [2 3] [1 1] [4 5] [5 6]]))))
  (testing "should return tuntun when no other sequences matches"
    (is (= :tuntun (conditions-apply [7 8 9])))))
