(ns studentmgmt.core
  (:require [studentmgmt.student.model :as students]
            [studentmgmt.student.handler :refer [handle-index-students
                                                 handle-create-student
                                                 handle-delete-student
                                                 handle-update-student]]
            [ring.adapter.jetty :as jetty]
            [ring.middleware.params :refer [wrap-params]]
            [compojure.core :refer [defroutes ANY GET POST PUT DELETE]]
            [compojure.route :refer [not-found]]
            [ring.handler.dump :refer [handle-dump]]))

(def db (or
         (System/getenv "DATABASE_URL")
         "jdbc:postgresql://localhost:5432/students?user=postgres&password=postgres"))

(defroutes routes
  (ANY "/request" [] handle-dump)
  (GET "/students" [] handle-index-students)
  (POST "/students" [] handle-create-student)
  (DELETE "/students/:id" [] handle-delete-student)
  (PUT "/students/:id" [] handle-update-student)
  (not-found "Sorry, page not found!!!"))

(defn wrap-db [hdlr]
  (fn [req]
    (hdlr (assoc req :students/db db))))

(def app
  (-> routes
      (wrap-params)
      (wrap-db)))

(defn -main [port]
  (students/create-table db)
  (jetty/run-jetty app {:port (Integer. port)}))
