(ns hustem.compile-sbl-test
  (:require [clojure.test :refer :all]
            [hustem.compile-sbl :refer :all]))



(defn run-modified-sbl-test [word]
  ;(println " *** compile sbl files *** ")
  (make)
  ;(println (str " *** test with " word " the sbl modification *** "))
  (get-raw-stem-res word))


(deftest sbl-word-tests
  (testing "baglyokat -> bagoly"
    (is (= "bagoly" (run-modified-sbl-test "baglyokat"))))
  )

