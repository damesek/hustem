(ns hustem.data-preparation
  "We prepare here the data for future works."
  (:require [clojure.edn :as edn]
            [clojure.string :refer [join replace escape
                                    lower-case split
                                    split-lines]]))



(def escape-char-map
  (zipmap (mapv char "[!”#$%&’()*+,-./:;<=>?@[]^_`{|}~(]") (repeat "")))

(defn escape-strings [sentence]
  (escape sentence escape-char-map))




(def tanakh-hu-verses
  "Import bilingual Tanakh"
  (->> (slurp "src/resources/data/en-hu.edn")
       edn/read-string
       (mapv second)))


(defn tanakh-words
  "Create a large set from Tanakh's words.
   We will test our Snowball's stemmer these words."
  [verses-vector]
  (let [merged (join " " verses-vector)]
    (-> merged
        escape-strings
        (lower-case)
        (split #"\s+")
        set)))

(def all-hungarian-words
  "161k hungarian words, help to identify valid words.
   We will try to find the stem results in this dict."
  (->> (slurp "src/resources/magyar-szavak.txt")
       (split-lines)))








