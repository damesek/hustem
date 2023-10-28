(ns hustem.error-rate
  "Get the stemming error rate at Hungarian case"
  (:require [hustem.data-preparation :refer [tanakh-words all-hungarian-words
                                             tanakh-hu-verses]]
            [hustem.core :refer :all]))


(def tanakh-words-test
  (->> (into [] (tanakh-words tanakh-hu-verses))
       (take 20)
       vec))

(defn get-bad-values [words]
  (->>
    (for [w words
          :let [s (stem w)]]
      (when-not (.spell hunspell-dic s)
        (conj [w s])))
    (remove nil?)
    vec))

(def bad-stem-res
  (->> (tanakh-words tanakh-hu-verses)
       vec
       get-bad-values))

(defn get-bad-values-hunspell [words]
  (->>
    (for [w words
          :let [s (.stem hunspell-dic w)]]
      (when (empty? s)
        (conj [w "" (stem w)])))
    (remove nil?)
    vec))


(def bad-stem-res-hunspell
  (->> (tanakh-words tanakh-hu-verses)
       vec
       get-bad-values-hunspell))

(defn get-bad-values-hunspell-mdb [words]
  (->>
    (for [w words
          :let [s (.stem hunspell-mdb w)]]
      (when (empty? s)
        (conj [w "" (stem w)])))
    (remove nil?)
    vec))


(def bad-stem-res-hunspell-mdb
  (->> (tanakh-words tanakh-hu-verses)
       vec
       get-bad-values-hunspell))

(def error-rate
  (let [all (float (count (tanakh-words tanakh-hu-verses)))
        hunsp (count bad-stem-res-hunspell)
        hunsp-mdb (count bad-stem-res-hunspell-mdb)
        snowb (count bad-stem-res)
        percentage (partial format "%.2f%%")]
    {:hunspell (percentage (* (/ hunsp all) 100))
     :snowball (percentage (* (/ snowb all) 100))
     :hunspell-mdb (percentage (* (/ hunsp-mdb all) 100))}))


(println error-rate)