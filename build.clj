(ns build
  (:require [clojure.tools.build.api :as b]))

;; clj -T:build clean
;; clj -T:build compile-java

(def class-dir "target/classes")
(def basis (b/create-basis {:project "deps.edn"}))

(defn compile-java
  [_]
  (b/javac {:src-dirs ["src/java"]
            :class-dir class-dir
            :basis basis
            :javac-opts ["--release" "8"
                         "-Xlint:deprecation"]}))

(defn clean [_]
  (b/delete {:path "target/classes"}))

(comment
  ; add to main deps to use this part

  (clean {:class-dir (str "/target/classes")})

  (compile-java {:class-dir     (str "/target/classes")
                 :java-src-dirs [(str "src/java")]
                 :deps-file     (str "/deps.edn")})

  )

