(ns rna-transcription
  (:require [clojure.set :as s]))

(defn to-rna [dna]
  (assert (s/subset? (distinct dna) #{\A \C \G \T \U}))
  (let [rna-map{\C \G, \G \C, \A \U, \T \A}]
    (apply str (map #(rna-map %) (vec dna)))))
