(ns baby-sepl.t-fibonacci
  (:require [midje.sweet :refer :all]
            [baby-sepl.core :refer :all]))

(fact
  "baby-sepl calculates the fibonacci sequence up to position N"

  ;state is the unfolding fibonacci sequence (imagine this is stored in 'the cloud')
  ;the side-effect-action of 'calc-next' is retrieving the last two elements of the sequence
  ;the pure-action of 'calc-next' is summing them up
  ;the 'set-next' flow is mutating the sequence

  (let [flows {"calc-next" {:side-effect-action (fn get-last-two [state args]
                                                  (take-last 2 state))
                            :pure-action        (fn calc-next [args outcome]
                                                  (when (pos? args)
                                                    [(baby-step "set-next" (apply + outcome))
                                                     (baby-step "calc-next" (dec args))]))}
               "set-next"  {:side-effect-action (fn mutate-state [state args]
                                                  (conj state args))}}
        initial-state [0 1]
        trigger-step (baby-step "calc-next" 5)]

    (baby-sepl flows initial-state [trigger-step])) => [0 1 1 2 3 5 8])
