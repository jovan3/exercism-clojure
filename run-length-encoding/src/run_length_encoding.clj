(ns run-length-encoding)

(defn char-count [s]
  (if (= 1 (count s)) "" (count s)))

(defn str->symlist [string]
  "processes a string into a list of integers and chars"
  (let [partitions (partition-by #(Character/isDigit %) string)]
    (letfn [(split-letter-seg [e]
              (let [[first-char & _] e]
                (if (Character/isDigit first-char) (Integer/parseInt (apply str e)) e)))]
      (flatten (map split-letter-seg partitions)))))

(defn run-length-encode
  "encodes a string with run-length-encoding"
  [plain-text]
  (apply str (map #(str (char-count %) (first %)) (partition-by identity plain-text))))

(defn run-length-decode
  "decodes a run-length-encoded string"
  [cipher-text]
  (loop [[current & rest] (str->symlist cipher-text)
         decoded []
         prev nil]
    (if (nil? current)
      (apply str (flatten decoded))
      (let [next-decoded (cond
                           (number? current) decoded
                           (not (number? prev)) (conj decoded current)
                           :else (conj decoded (repeat prev current)))]
        (recur rest next-decoded current)))))
