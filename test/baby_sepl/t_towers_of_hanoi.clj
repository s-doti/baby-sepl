(ns baby-sepl.t-towers-of-hanoi
  (:require [midje.sweet :refer :all]
            [baby-sepl.core :refer :all]))

(fact
  "baby-sepl solves the towers of hanoi for N disks"

  (let [flows {"solve"     {:side-effect-action (fn get-aux [state [from to]]
                                                  (first (keys (dissoc state from to))))
                            :pure-action        (fn solve [[from to num-disks] aux]
                                                  (if (= 1 num-disks)
                                                    [(baby-step "move-disk" [from to])]
                                                    [(baby-step "solve" [from aux (- num-disks 1)])
                                                     (baby-step "move-disk" [from to])
                                                     (baby-step "solve" [aux to (- num-disks 1)])]))}
               "move-disk" {:side-effect-action (fn move-disk [state [from to]]
                                                  (-> state
                                                      (update from pop)
                                                      (update to conj (peek (get state from)))))}}
        initial-state {"peg-A" [5 4 3 2 1]
                       "peg-B" []
                       "peg-C" []}
        trigger-step [(baby-step "solve" ["peg-A" "peg-B" (count (get initial-state "peg-A"))])]]

    (baby-sepl flows
               initial-state
               trigger-step)) => {"peg-A" []
                                  "peg-B" [5 4 3 2 1]
                                  "peg-C" []})
