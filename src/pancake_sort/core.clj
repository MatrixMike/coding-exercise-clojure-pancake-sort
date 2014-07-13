(ns pancake-sort.core)

(defn biggest [v] (apply max v))
(defn index-of-biggest [v] (.indexOf v (biggest v)))
(defn last-index-of [v] (+ 1 (count v)))

(defn pancake-sort [v]
  (if (> 2 (count v))
    v
    (let [nv (vec (reverse (into
                            (vec (reverse (subvec v 0 (inc (index-of-biggest v)))))
                            (subvec v (inc (index-of-biggest v))))))]
      (conj (pancake-sort (pop nv)) (peek nv)))))
