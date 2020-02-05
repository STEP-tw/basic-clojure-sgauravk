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