(ns hustem.core-test
  (:require [clojure.test :refer :all]
            [hustem.core :refer :all]))

(deftest hungarianStemmer-word-tests
  (testing "Javac compiled test: baglyokat -> bagoly"
    (is (= "bagoly" (stem "baglyokat"))))
  )



