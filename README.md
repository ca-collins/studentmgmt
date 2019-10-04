# Installation

1. Requires [Leiningen](https://leiningen.org/), JavaSDK, and PostgreSQL

2. Create new PostgreSQL database called *students*: `CREATE DATABASE students`

3. Clone the project by running the following in your terminal: `git clone https://github.com/ca-collins/studentmgmt.git`

4. Navigate to the project folder and run the following command in the terminal to start the server: `lein run`
  - You may have to adjust the `DATABASE_URL` in `src\studentmgmt\core.clj` to match your Postgres config (or vice versa)


5. Endpoint is hardcoded to <http://localhost:8000/students>
  - You can adjust the port in the `-main` function in `src\studentmgmt\core` (If you do, you will have to make an equivalent change on the frontend. See [Profezzerk](https://github.com/ca-collins/profezzerk) README for more.)


6. Install and run the frontend application: [Profezzerk](https://github.com/ca-collins/profezzerk)

--------------------------------------------------------------------------------

# Technologies Used

- Clojure
- Ring
- Compojure
- PostgreSQL
- Java JDBC
- Cheshire

--------------------------------------------------------------------------------

# Requirements

## General

- [x] When first launched, the application should display a list of all students in the database (no paging is necessary).

- [x] A student on the list can be deleted by the end user. When the student is being deleted, the user should be presented with an "are you sure" dialog box.

- [x] A student on the list can be updated.

- [x] A new student can be added to the list.

## Architecture

- [x] This student management application should consist of three parts: a frontend, a backend, and a database.

- [x] The frontend should be written using a modern frontend library like React, Vue, etc.

- [x] The backend should expose a REST API that the frontend will call

- [x] This should be the only way that the frontend and backend communicate.

--------------------------------------------------------------------------------

# License

Copyright © 2019 FIXME

This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0 which is available at <http://www.eclipse.org/legal/epl-2.0>.

This Source Code may also be made available under the following Secondary Licenses when the conditions for such availability set forth in the Eclipse Public License, v. 2.0 are satisfied: GNU General Public License as published by the Free Software Foundation, either version 2 of the License, or (at your option) any later version, with the GNU Classpath Exception which is available at <https://www.gnu.org/software/classpath/license.html>.
