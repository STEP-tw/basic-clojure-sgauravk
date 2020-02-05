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