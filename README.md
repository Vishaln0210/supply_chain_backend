# 🚀 Supply Chain Backend (Product Management System)

## 📌 Overview

This project is a **Spring Boot backend application** for managing products, suppliers, inventory, and orders.
It is designed with **clean architecture**, proper **database normalization**, and **Docker-based deployment**.

---

## 🧱 Tech Stack

* Java 21
* Spring Boot
* Spring Data JPA (Hibernate)
* MySQL
* Flyway (Database Migrations)
* MapStruct (DTO Mapping)
* Docker & Docker Compose
* Gradle

---

## 🏗️ Architecture

The project follows a layered architecture:

Client → Controller → Service → Repository → Database

* **Controller** → Handles HTTP requests
* **Service** → Business logic
* **Repository** → Database operations

---

## 🗄️ Database Design (ER Summary)

* Supplier → Product (One-to-Many)
* Product ↔ Warehouse (via Stock)
* Order → OrderItems (One-to-Many)
* OrderItems → Product

👉 Inventory is handled using a **Stock table** (Product + Warehouse + Quantity)

---

## ⚙️ Features

* ✅ Supplier Management (CRUD)
* ✅ Product Management (CRUD)
* ✅ Inventory tracking (Stock)
* ✅ Order Management
* ✅ DTO-based API design
* ✅ Clean mapping using MapStruct
* ✅ Flyway migrations
* ✅ Dockerized setup

---

## 🐳 Run with Docker

### Step 1: Clone repo

```bash
git clone https://github.com/Vishaln0210/supply_chain_backend.git
cd supply_chain_backend
```

### Step 2: Run application

```bash
docker-compose up --build
```

---

## 🌐 API Endpoints

### Supplier APIs

* POST /suppliers
* GET /suppliers
* GET /suppliers/{id}
* PUT /suppliers/{id}
* DELETE /suppliers/{id}

### Product APIs

* POST /products
* GET /products
* GET /products/{id}
* PUT /products/{id}
* DELETE /products/{id}

---

## 🧠 Key Design Decisions

* Used **Stock table** instead of direct Product-Warehouse relation to handle quantity
* Used **OrderItems** to support multiple products per order
* Used **Enum (STRING)** for readability and safety
* Used **Flyway** for version-controlled schema management

---

## 🚀 Future Improvements

* Pagination & Filtering
* Global Exception Handling
* Swagger API Documentation
* Unit Testing
* Code Coverage & Static Analysis

---

## 👨‍💻 Author

Vishal N
