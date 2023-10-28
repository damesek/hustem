(ns hustem.core
  "Wrapper around the Snowball stemmer algorithm.
   See: http://snowball.tartarus.org
   stemmer fn from https://github.com/weavejester/snowball-stemmer")

(defn stemmer [lang]
  (let [stemmer-name  (str "org.tartarus.snowball.ext." (name lang) "Stemmer")
        stemmer-class (Class/forName stemmer-name)]
    (fn [word]
      (let [instance (.newInstance stemmer-class)]
        (.setCurrent instance word)
        (.stem instance)
        (.getCurrent instance)))))

(def stem (stemmer :hungarian))

(comment
  (stem "baglyokat")
  )


