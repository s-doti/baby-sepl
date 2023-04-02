(ns baby-sepl.core)

(defn baby-sepl

  "Baby-SEPL takes:
  - Algorithm declaration, in terms of 'flows', each having a side-effect-action and a pure-action;
    Each 'flow' is a map having a side-effect-action entry, and a pure-action entry;
    The side-effect-action logic takes a state and args, to produce an outcome for the pure-action;
    The pure-action logic takes the args and outcome, and produces further steps to be executed.
  - Initial state, which can literally be anything.
  - Initial step(s), to trigger the algorithm execution, having a flow id and any args relevant to that flow.

  Baby-SEPL steps through the algorithm flows.
  The final state is returned when there are no further steps to execute.

  * State mutations are handled via 'flows' having no pure-action.
  ** Steps are executed iteratively, DFS style."

  [flows state steps]

  (loop [[{:keys [flow-id args] :as step} & rest-steps] steps
         state state]
    (if (nil? step)                                         ;stop condition
      state
      (let [{:keys [side-effect-action pure-action]} (get flows flow-id)
            outcome (cond-> state
                            (some? side-effect-action)
                            (side-effect-action args))]     ;execute side-effect action
        (if (some? pure-action)
          (let [new-steps (pure-action args outcome)]       ;execute pure action
            (recur (concat new-steps rest-steps) state))    ;add new steps to the iteration
          (recur rest-steps outcome))))))                   ;no pure action, iterate using outcome (state mutated)

(defn baby-step [flow-id args]
  {:flow-id flow-id :args args})
