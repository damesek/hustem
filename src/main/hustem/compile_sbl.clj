(ns hustem.compile-sbl
  (:require [clojure.string :refer [trim-newline]])
  (:use [clojure.java.shell :only [sh]]))


(def snowball-root "src/resources/snowball-master")
(def bash-cli (partial sh "bash" "-c"))

(defn make []
  (->> (bash-cli "make" :dir snowball-root)
       :out
       println))

(defn get-raw-stem-res [word]
  (let [cmd (str "./stemwords -l hungarian <<< " word)]
    (->> (bash-cli cmd :dir snowball-root)
         :out
         trim-newline)))

(defn compile-and-update-java-libs []
  (let [res (bash-cli "make" :dir "src/resources/snowball-master")]
    (if (empty? (:err res))
      (println "ok")
      (println " **** Error **** " (:err res)))
  ))

; (compile-and-update-java-libs)

(comment

  ; compile and update java folder

  (bash-cli "cp -r src/resources/snowball-master/java src/")

  (bash-cli "./snowball algorithms/hungarian.sbl -o ext-updated/hungarianStemmer -java"
      :dir snowball-root)

  (bash-cli "cp src/resources/snowball-master/ext-updated/hungarianStemmer.java src/java/org/tartarus/snowball/ext"
      :dir "./")

  )


