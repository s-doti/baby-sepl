(defproject com.github.s-doti/baby-sepl "1.0.1"
  :description "Baby version of the SEPL (algorithm execution) engine"
  :url "https://github.com/s-doti/baby-sepl"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [midje/midje "1.10.9"]]
  :repl-options {:init-ns baby-sepl.core})
