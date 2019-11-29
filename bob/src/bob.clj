(ns bob
  (:require [clojure.string :as str]))

(defn has-letters? [s]
  (not (empty? (filter (fn [x] (Character/isLetter x)) s))))

(defn upper? [s]
  (= s (str/upper-case s)))

(defn question? [s]
  (= \? (last s)))

(defn yell? [s]
  (= \! (last s)))

(defn response-for [s]
  (cond
    (str/blank? s) "Fine. Be that way!"
    (and (has-letters? s) (upper? s) (question? s)) "Calm down, I know what I'm doing!"
    (and (has-letters? s) (upper? s)) "Whoa, chill out!"
    (question? s) "Sure."
    :else "Whatever."))
    
