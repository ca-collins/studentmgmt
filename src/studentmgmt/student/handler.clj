(ns studentmgmt.student.handler
  (:require [studentmgmt.student.model :refer [create-student
                                               read-students
                                               update-student
                                               delete-student]]
            [cheshire.core :as c]))

(defn handle-index-students [req]
  (let [db (:students/db req)
        students (vec (read-students db))]
    (prn "READ REQ" req)
    {:status 200
     :headers {"Content-Type"                 "text/json"
               "Access-Control-Allow-Origin"  "*"}
     :body (c/generate-string students)}))

(defn handle-create-student [req]
  (let [name (get-in req [:params "name"])
        description (get-in req [:params "description"])
        db (:students/db req)
        student-id (create-student db name description)]
    (prn "CREATE REQ" req)
    {:status 302
     :headers {"Access-Control-Allow-Origin"  "*"}
     :body ""}))

(defn handle-delete-student [req]
  (let [db (:students/db req)
        student-id (java.util.UUID/fromString (:id (:route-params req)))
        exists? (delete-student db student-id)]
    (prn "DELETE REQ" req)
    (if exists?
      {:status 302
       :headers {"Access-Control-Allow-Origin"  "*"}
       :body ""}
      {:status 404
       :body "student not found."
       :headers {"Access-Control-Allow-Origin"  "*"}})))

(defn handle-update-student [req]
  (let [db (:students/db req)
        student-id (java.util.UUID/fromString (:id (:route-params req)))
        name (get-in req [:params "name"])
        description (get-in req [:params "description"])
        exists? (update-student db student-id name description)]
    (prn "UPDATE REQ" req)
    (if exists?
      {:status 302
       :headers {"Access-Control-Allow-Origin"  "*"}
       :body ""}
      {:status 404
       :body "student not found."
       :headers {"Access-Control-Allow-Origin"  "*"}})))
;       :headers {"Location" "/students"}
