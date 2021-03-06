(ns assignments.lists-test
  (:require [clojure.test :refer :all]
            [assignments.lists :refer :all]))

(deftest map-test
  (testing "identity with single coll"
    (is (= [1 2 3] (map' identity [1 2 3])))))


(deftest filter-test
  (testing "should return even number from list"
    (is (= [2 4 6] (filter' even? [1 2 3 4 5 6]))))
  (testing "should return int from numbers collection"
    (is (= [6 7] (filter' int? [6 7 8.3 9.1])))))


(deftest reduce-test
  (testing "should add all elements of array"
    (is (= 15 (reduce' + [1 2 3 4 5]))))
  (testing "should return 0 when acc is zero while multiply"
    (is (zero? (reduce' * 0 [2 3 4 5])))))


(deftest count-test
  (testing "sequence length"
    (is (= 5 (count' [1 2 3 4 5]))))
  (testing "nil"
    (is (= 0 (count' nil))))
  (testing "empty vector"
    (is (= 0 (count' []))))
  (testing "map"
    (is (= 2 (count {:one 1 :two 2}))))
  (testing "string"
    (is (= 6 (count "abcdef")))))


(deftest reverse-test
  (testing "should reverse the vector"
    (is (= [5 4 3 2 1] (reverse' [1 2 3 4 5]))))
  (testing "should reverse the list"
    (is (= '(4 3 2) (reverse' '(2 3 4)))))
  (testing "should reverse map"
    (is (= '([:b 4] [:a 3]) (reverse' {:a 3 :b 4}))))
  (testing "should return nil for a single int"
    (is (nil? (reverse' 1))))
  (testing "should reverse the string"
    (is (= '(\l \e \v \e \l) (reverse' "level")))))


(deftest every-test
  (testing "true condition"
    (is (true? (every?' even? [2 4 6 8]))))
  (testing "false condition"
    (is (false? (every?' odd? [2 4 9 6 8])))))


(deftest some-test
  (testing "true condition"
    (is (true? (some?' even? [1 5 3 4]))))
  (testing "false condition"
    (is (false? (some?' even? [1 5 7 9])))))


(deftest ascending-test
  (testing "true condition"
    (is (true? (ascending? [1 2 3 4 5 6 6]))))
  (testing "false condition"
    (is (false? (ascending? [1 2 3 2 1 0])))))


(deftest sum-of-adjacent-digits-test
  (testing "should return the adjacent sum of vector"
    (is (= [3 5] (sum-of-adjacent-digits [1 2 3]))))
  (testing "should return empty vec for vec with single element"
    (is (= [] (sum-of-adjacent-digits [1])))))


(deftest difference-test
  (testing "non-empty collection"
    (is (= [2 3] (difference [1] [1 2 3]))))
  (testing "empty collection"
    (is (= [] (difference [1 2 3] [1 2 3])))))


(deftest union-test
  (testing "non-empty collection"
    (is (= [1 2 3] (union [1 2] [2 3]))))
  (testing "empty collection"
    (is (= [2] (union [] [2])))))


(deftest cross-product-test
  (testing "non-empty collection with repeated element"
    (is (= [[1 4] [1 3] [1 5] [2 4] [2 3] [2 5] [3 4]] (cross-product [1 2 3] [4 3 5]))))
  (testing "non-empty collection with single element"
    (is (= [[1 2]] (cross-product [1] [2])))))


(deftest double-up-test
  (testing "single dimensional collection"
    (is (= [1 1 2 2 3 3] (double-up [1 2 3]))))
  (testing "two dimensional collection"
    (is (= [[1 2] [1 2] [3 4] [3 4]] (double-up [[1 2] [3 4]])))))


(deftest index-of-test
  (testing "element present in collection"
    (is (= 4 (index-of [1 2 3 4 5 6] 5))))
  (testing "element not-present in collection"
    (is (= -1 (index-of [1 2 3 4 5 6] 9))))
  (testing "element present in single element collection"
    (is (= 0 (index-of [6] 6)))))


(deftest muted-thirds-test
  (testing "should replace every third element with 0 when list items is more then 3"
    (is (= [1 2 0 4 15 0 7] (muted-thirds [1 2 8 4 15 2 7]))))
  (testing "should return the list itself when list items is less then 3"
    (is (= [1 2] (muted-thirds [1 2])))))


(deftest palindrome?-test
  (testing "true condition"
    (is (true? (palindrome? ["n" "a" "m" "a" "n"]))))
  (testing "false condition"
    (is (false? (palindrome? ["k" "a" "n" "n" "u"])))))


(deftest sqr-of-the-first-test
  (testing "non-empty collection"
    (is (= [16 16 16] (sqr-of-the-first [4 5 6])))))
