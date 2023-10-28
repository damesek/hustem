(ns hustem.core
  "Wrapper around the Snowball stemmer algorithm.
   See: http://snowball.tartarus.org
   stemmer fn from https://github.com/weavejester/snowball-stemmer"
  (:import com.atlascopco.hunspell.Hunspell))

(defn stemmer [lang]
  (let [stemmer-name (str "org.tartarus.snowball.ext." (name lang) "Stemmer")
        stemmer-class (Class/forName stemmer-name)]
    (fn [word]
      (let [instance (.newInstance stemmer-class)]
        (.setCurrent instance word)
        (.stem instance)
        (.getCurrent instance)))))

(def stem (stemmer :hungarian))

(def hunspell-dic (Hunspell. "src/resources/stemmerold/hu_HU.dic"
                             "src/resources/stemmerold/hu_HU.aff"))

(def hunspell-mdb (Hunspell. "src/resources/morphdb.hu/morphdb_hu.dic"
                             "src/resources/morphdb.hu/morphdb_hu.aff"))




(comment

  (.stem hunspell-dic "baglyokat")
  (.stem hunspell-mdb "vala")
  (.spell hunspell-dic "val")

  )

