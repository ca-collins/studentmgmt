(defproject studentmgmt "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [ring "1.7.1"]
                 [ring-cors "0.1.13"]
                 [compojure "1.5.1"]
                 [org.clojure/java.jdbc "0.6.1"]
                 [org.postgresql/postgresql "9.4.1208.jre7"]
                 [cheshire "5.9.0"]]

 :min-lein-version "2.0.0"

 :uberjar-name "studentmgmt.jar"

 :main studentmgmt.core

 :profiles {:dev
            {:source-paths ["src" "dev"]
             :main studentmgmt.dev}})
