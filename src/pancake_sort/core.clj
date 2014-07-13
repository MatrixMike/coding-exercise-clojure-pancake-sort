(ns pancake-sort.core)

(defn biggest [v] (apply max v))
(defn index-of-biggest [v] (.indexOf v (biggest v)))

(defn pancake-sort [v]
  (if (> 2 (count v))
    v
    (let [spatula       (inc (index-of-biggest v))
          on-spatula    (subvec v 0 spatula)
          under-spatula (subvec v spatula)
          nv            (vec (reverse (into (vec (reverse on-spatula))
                                            under-spatula)))]
      (conj (pancake-sort (pop nv))
            (peek nv)))))



(concat [1 2] [3])
(reverse [1 2])
