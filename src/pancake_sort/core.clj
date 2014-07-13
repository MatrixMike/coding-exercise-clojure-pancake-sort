(ns pancake-sort.core)

(defn biggest [v] (apply max v))
(defn index-of-biggest [v] (.indexOf v (biggest v)))
(defn last-index-of [v] (+ 1 (count v)))

(defn pancake-sort [v]
  (cond

   (empty? v) v

   (= 1 (count v)) v

   ; top of the stack
   (= 0
      (index-of-biggest v))
   (pancake-sort (vec (reverse v)))

   ; bottom of the stack
   (= (last-index-of v)
      (index-of-biggest v))
   (into (pancake-sort (pop v)) (peek v))

    ; middle of the stack
    :else
   (let [nv (vec (reverse (into
                       (vec (reverse (subvec v 0 (inc (index-of-biggest v)))))
                       (subvec v (inc (index-of-biggest v))))))]

     (conj (pancake-sort (pop nv)) (peek nv))

     )

    )
  )
