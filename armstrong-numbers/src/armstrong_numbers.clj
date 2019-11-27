(ns armstrong-numbers)

(defn char->int [char]
  (Character/getNumericValue char))

(defn pow-exp [exp]
  (fn [base]
    (nth (iterate #(* base %) base) (dec exp)))) 

(defn digits [num]
  (->>
   num
   str
   (into [])
   (map char->int)))

(defn armstrong? [num] ;; <- arglist goes here
  (let [all-digits (digits num)
        length (count all-digits)]
    (= num (reduce + (map (pow-exp length) all-digits)))))
