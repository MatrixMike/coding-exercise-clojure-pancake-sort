(ns pancake-sort.core)

(defn biggest [coll] (apply max coll))
(defn index-of-biggest [coll] (.indexOf coll (biggest coll)))

(defn pancake-sort [coll]
  (if (> 2 (count coll))
    coll
    (let [spatula       (inc (index-of-biggest coll))
          above-spatula (take spatula coll)
          under-spatula (drop spatula coll)
          biggest-under (reverse (concat (reverse above-spatula) under-spatula))]

      (conj (vec (pancake-sort (butlast biggest-under)))
            (last biggest-under)))))
