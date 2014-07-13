(ns pancake-sort.core)

(defn biggest [v] (apply max v))
(defn index-of-biggest [v] (.indexOf v (biggest v)))

(defn pancake-sort [v]
  (if (> 2 (count v))
    v
    (let [spatula       (inc (index-of-biggest v))
          on-spatula    (take spatula v)
          under-spatula (drop spatula v)
          nv            (vec (reverse (concat (reverse on-spatula)
                                              under-spatula)))]
      (conj (pancake-sort (pop nv))
            (peek nv)))))



