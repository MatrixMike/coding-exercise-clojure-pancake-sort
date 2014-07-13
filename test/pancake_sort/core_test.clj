(ns pancake-sort.core-test
  (:require  [pancake-sort.core :refer :all])
  (:use midje.sweet))


(defn ps [list] list)

(fact "about a pancake sorter"

       (ps [3 2]) => [2 3]


       )



(pancake-sort [2 3 1])


(defn flip? [v]
  (< (peek v) (apply max (pop v))))

(fact "flip?"
      (flip? [1 2]) => false
      (flip? [1 2 3]) => false

      (flip? [2 1]) => true
      (flip? [3 2 1]) => true
      )

(defn pancake-sort [v]
  (if (> 2 (count v))
    v
    (if (flip? v)
      (conj (pancake-sort (pop (reverse v))) (peek (reverse v)))
      (conj (pancake-sort (pop v)) (peek v))
      )
    )
  )

(pancake-sort [])
(pancake-sort [1])

(pancake-sort [1 2])
(pancake-sort [2 1])

(pancake-sort [1 2 3])
(pancake-sort [3 1 2])
(pancake-sort [2 3 1])
(pancake-sort [2 1 3])

; 3 1|2
; 1 3 2|
; 2 3|1
; 3 2 1|
; 1 2 3

; 3 1 2|
; 2 1|3
; 1 2 3

; 2 3|1
; 3 2 1
; 1 2 3

; 3 1 2|
; 2 1 3
; 1 2 3


(defn biggest [v] (apply max v))
(defn index-of-biggest [v] (.indexOf v (biggest v)))
(defn last-index-of [v] (+ 1 (count v)))

(defn ps2 [v]
  (cond

   (empty? v) v

   (= 1 (count v)) v

   ; top of the stack
   (= 0
      (index-of-biggest v))
   (ps2 (vec (reverse v)))

   ; bottom of the stack
   (= (last-index-of v)
      (index-of-biggest v))
   (into (ps2 (pop v)) (peek v))

    ; middle of the stack
    :else
   (let [nv (vec (reverse (into
                       (vec (reverse (subvec v 0 (inc (index-of-biggest v)))))
                       (subvec v (inc (index-of-biggest v))))))]

     (into (ps2 (pop nv)) (peek nv))

     )

    )
  )

(index-of-biggest [2 1 3])
(def v [2 3 0])

(reverse (take (inc (index-of-biggest v)) v))

(into
 (vec (reverse (subvec v 0 (inc (index-of-biggest v)))))
 (subvec v (inc (index-of-biggest v))))


(ps2 [])
(ps2 [1])
(ps2 [2 1])
(ps2 [2 1 3])

;(ps2 [3 2 1])

#_(facts "about pancake-sort"

       (pancake-sort [1 2 3]) => [1 2 3]
       (pancake-sort [3 2 1]) => [1 2 3]

       )


(facts "about sequences"
  (peek '(1 2 3)) => 1
  (pop  '(1 2 3)) => '(2 3)
       )

(facts "about vectors"
  (peek [1 2 3]) => 3
  (pop  [1 2]) => [1]
  (pop  [1 2 3]) => [1 2]

  (apply max  [1 2 3 0]) => 3
  (count [4 5 6]) => 3

  (empty []) => []
  (empty [1]) => []
  (empty nil) => nil

  (empty? nil) => truthy
  (empty? []) => truthy
  (empty? [1]) => falsey

  (conj [1] 2) => [1 2]

       )

(facts "about truthy"

       nil => falsey
       false => falsey

       true => truthy

       0 => truthy
       -1 => truthy
       1 => truthy

       "" => truthy
       "false" => truthy

       '() => truthy

       [] => truthy
       [1] => truthy
       [nil] => truthy

       )

