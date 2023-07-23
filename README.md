# baby-sepl

[![Clojars Project](https://img.shields.io/clojars/v/com.github.s-doti/baby-sepl.svg)](https://clojars.org/com.github.s-doti/baby-sepl)

A baby version of the [SePL](https://github.com/s-doti/sepl) (algorithm execution) engine. 

This baby is designed with the sole purpose of delivering a gist. 
It is meant to be self-explored directly through code.
Its [core](src/baby_sepl/core.clj) weighs less than 20 lines of code, and still supports the basic concepts:
- Declarative
- Separation of execution context and logic
- Agnostic to state, data-model, storage

See examples under [test/baby_sepl](test/baby_sepl):
- [Fibonacci calculator](test/baby_sepl/t_fibonacci.clj)
- [Towers of Hanoi solver](test/baby_sepl/t_towers_of_hanoi.clj)

Also, see the [baby-ginfer](https://github.com/s-doti/baby-ginfer) (graph inference) library which is built on this baby as well.

See the more [mature](https://github.com/s-doti/sepl) version of this library for a more in-depth review of the concept, 
as well as additional features such as:
- Write once, execute in any style - blocking/async, distributed, etc.
- Pause/resume
- DR
- Flow debugger
- And more...

## Usage

```clojure 

(let [flows {"flow" {:side-effect-action (fn [state args])
                     :pure-action (fn [args outcome])}}
      initial-state "..state.."
      trigger-step (baby-step "flow" "..args..")]
  
  (baby-sepl flows initial-state [trigger-step]))
```

## License

Copyright © 2023 [@s-doti](https://github.com/s-doti)

This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0 which
is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary Licenses when the conditions for such
availability set forth in the Eclipse Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your option) any later version, with the GNU
Classpath Exception which is available at https://www.gnu.org/software/classpath/license.html.
