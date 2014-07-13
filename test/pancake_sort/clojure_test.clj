(ns pancake-sort.core-test
  (:use midje.sweet))


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

