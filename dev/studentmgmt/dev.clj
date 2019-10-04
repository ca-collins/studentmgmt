(ns studentmgmt.dev
  (:require [studentmgmt.student.model :as students])
  (:require [ring.adapter.jetty :as jetty]
            [ring.middleware.reload :refer [wrap-reload]]
            [studentmgmt.core :as core]))

(defn -main []
  (students/create-table core/db)
  (jetty/run-jetty (wrap-reload #'core/app) {:port 8000}))
