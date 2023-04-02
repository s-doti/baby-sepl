# baby-sepl

A baby version of the SEPL (algorithm execution) engine. 

This baby is designed with the sole purpose of delivering a gist. 
It weighs less than 20 lines of code, and still supports the basic concepts:
- Declarative
- Separation of execution context and logic
- Agnostic to state, data-model, storage

See examples under /test:
- Fibonacci calculator
- Towers of Hanoi solver

I hope it is possible to see from here, albeit requires some imagination, 
how the more mature version of this baby supports advanced control features, such as:
- Write once, execute in any style - blocking/async, distributed, etc.
- Pause/resume
- DR
- Flow debugger

## Usage

```clojure 

(let [flows {"flow" {:side-effect-action (fn [state args])
                     :pure-action (fn [args outcome])}}
      initial-state "..state.."
      trigger-step (baby-step "flow" "..args..")]
  
  (baby-sepl flows initial-state [trigger-step]))
```

## License

Copyright © 2023 FIXME

This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0 which
is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary Licenses when the conditions for such
availability set forth in the Eclipse Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your option) any later version, with the GNU
Classpath Exception which is available at https://www.gnu.org/software/classpath/license.html.
