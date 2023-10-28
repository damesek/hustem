(ns user
  (:require [clojure.string :refer [trim-newline]])
  (:use [clojure.java.shell :only [sh]]))


(def snowball-root "src/resources/snowball-master")

(defn make []
  (->> (sh "make" :dir "src/resources/snowball-master")
       :out
       println))

(defn get-raw-stem-res [word]
  (let [cmd (str "./stemwords -l hungarian <<< " word)]
    (->> (sh "bash" "-c" cmd :dir snowball-root)
         :out
         trim-newline)))

(get-raw-stem-res "baglyokat")

(defn run-modified-sbl-test [word]
  (println " *** compile sbl files *** ")
  (make)
  (println (str " *** test with " word " the sbl modification *** "))
  (get-raw-stem-res word))

(run-modified-sbl-test "baglyokat")
