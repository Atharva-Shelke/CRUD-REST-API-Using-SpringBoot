# 📘 Employee Management App (Spring Boot + JDBC + PostgreSQL)

A RESTful web service built using Spring Boot that demonstrates CRUD operations using **pure JDBC (JdbcTemplate)** with a **PostgreSQL** database.

---

## 📌 Features

* Create, Read, Update, Delete (CRUD) operations
* Uses Spring JDBC (JdbcTemplate) — no ORM (no JPA/Hibernate)
* Manual SQL queries (demonstrates strong SQL fundamentals)
* Cloud database integration (Neon / PostgreSQL)
* Proper error handling with HTTP status responses
* Clean layered architecture (Controller → Service → DAO)

---

## 🚀 Tech Stack

* Java 17
* Spring Boot
* Spring Web
* Spring JDBC (JdbcTemplate)
* PostgreSQL
* Maven

---

## 🗂️ Project Structure

```
src/
 └── main/
     ├── java/com/employee/app/
     │   ├── controller
     │   ├── service
     │   ├── dao
     │   └── model
     └── resources/
         └── application.properties
```

---

## ⚙️ Database Setup

This project uses PostgreSQL (cloud-hosted or local).

### Create Table

```sql
CREATE TABLE employee (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    salary INT,
    role VARCHAR(50)
);
```

---

## 🔧 Configuration

Update `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://<host>:5432/<database>?sslmode=require
spring.datasource.username=<username>
spring.datasource.password=<password>
spring.datasource.driver-class-name=org.postgresql.Driver

server.port=8088
```

---

## ▶️ Running the Application

Using Maven Wrapper:

```bash
./mvnw spring-boot:run
```

Or:

```bash
mvn spring-boot:run
```

---

## 🌐 API Endpoints

### ➕ Create Employee

```
POST /employees
```

```json
{
  "name": "Vinsmoke Sanji",
  "salary": 1989679,
  "role": "Cook"
}
```

---

### 📄 Get All Employees

```
GET /employees
```

---

### 🔍 Get Employee by ID

```
GET /employees/{id}
```

---

### ✏️ Update Employee

```
PUT /employees/{id}
```
for id = 3 :

```json
{
  "name": "Zoro",
  "salary": 2141990,
  "role": "Vice Captain"
}
```

---

### ❌ Delete Employee

```
DELETE /employees/{id}
```

---

## ⚠️ Error Handling

* Returns meaningful messages when:

  * Employee ID does not exist
* Uses HTTP status codes:

  * `200 OK`
  * `404 Not Found`

---

## 📮 Testing

You can test APIs using:

* Browser (GET endpoints)
* Postman for full CRUD operations

---

## 📌 Note

This project is intentionally implemented using **JDBC instead of JPA** to demonstrate strong SQL and database handling skills.
