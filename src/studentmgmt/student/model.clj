(ns studentmgmt.student.model
  (:require [clojure.java.jdbc :as db]))

(defn create-table [db]
  (db/execute!
   db
   ["CREATE EXTENSION IF NOT EXISTS \"uuid-ossp\""])
  (db/execute!
   db
   ["CREATE TABLE IF NOT EXISTS students
       (id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
        name TEXT NOT NULL,
        description TEXT NOT NULL,
        checked BOOLEAN NOT NULL DEFAULT FALSE,
        date_created TIMESTAMPTZ NOT NULL DEFAULT now())"]))

(defn create-student
  "Create a new student and return its id (UUID)."
  [db name description]
  (:id (first (db/query
               db
               ["INSERT INTO students (name, description)
                 VALUES (?, ?)
                 RETURNING id"
                name
                description]))))

(defn update-student
  "Updates the name and description of an existing student. Returns true for success and
  false for failure."
  [db id name description]
  (= [1] (db/execute!
          db
          ["UPDATE students
            SET name = ?, description = ?
            WHERE id = ?"
           name
           description
           id])))

(defn delete-student
  "Delete an existing student."
  [db id]
  (= [1] (db/execute!
          db
          ["DELETE FROM students
            WHERE id = ?"
           id])))

(defn read-students
  "Read in all students in the database."
  [db]
  (db/query
   db
   ["SELECT id, name, description, checked, date_created
     FROM students
     ORDER BY date_created"]))
