(ns baby-sepl.t-core
  (:require [midje.sweet :refer :all]
            [baby-sepl.core :refer :all]))

(fact
  "baby-sepl does nothing unless told otherwise"

  ;this 'test' is meant as a demonstration of the various components' apis
  (let [flows {"flow" {:side-effect-action (fn [state args])
                       :pure-action (fn [args outcome])}}
        initial-state "..state.."
        trigger-step (baby-step "flow" "..args..")]

    (baby-sepl flows initial-state [trigger-step])) => "..state..")
