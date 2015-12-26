(ns advent-of-code.day-2)

(defn surface-area
  [l w h]
  (+ (* 2 l w) (* 2 w h) (* 2 h l)))

(defn extra-paper-area
  [l w h]
  (let [sides-sorted (sort [l w h])
        smallest-side (first sides-sorted)
        middle-side (first (rest sides-sorted))]
    (* smallest-side middle-side)))

(defn read-and-parse-from
  [collection index]
  (read-string (nth collection index)))

(defn total-paper-for-present
  [dimension-str]
  (let [dims (clojure.string/split dimension-str #"x")
        l (read-and-parse-from dims 0)
        w (read-and-parse-from dims 1)
        h (read-and-parse-from dims 2)]
    (+ (surface-area l w h)
       (extra-paper-area l w h))))

(defn total-paper-for-all-presents
  [elves-list]
  (loop [elves-list (clojure.string/split-lines elves-list)
         total-paper 0]
    (if (> (count elves-list) 0 )
      (recur (rest elves-list)
             (+ (total-paper-for-present (first elves-list))
                total-paper))
      total-paper)))

(defn calculate-with-file
  [path]
  (total-paper-for-all-presents (slurp path)))
