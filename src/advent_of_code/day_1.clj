(ns advent-of-code.day-1)

(defn consume-next-char
  [current-floor next-char]
  (case next-char
    \( (inc current-floor)
    \) (dec current-floor)
    current-floor))

(defn find-floor
  [instructions]
  (loop [instructions instructions
         current-floor 0]
    (if (> (count instructions) 0)
      (let [next-floor (consume-next-char current-floor (first instructions))]
        (recur (rest instructions) next-floor))
      current-floor)))
