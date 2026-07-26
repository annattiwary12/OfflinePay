# 💳 OfflinePay – Offline Digital Wallet & Payment System

> A next-generation offline digital payment system that enables secure QR-based transactions without an active internet connection.

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-brightgreen)
![Angular](https://img.shields.io/badge/Angular-20-red)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Database-blue)
![License](https://img.shields.io/badge/License-MIT-green)

---

## 📌 Overview

OfflinePay is a digital wallet platform that allows users to make payments even when there is no internet connectivity.

Unlike traditional UPI systems that depend on bank servers, OfflinePay enables secure offline QR transactions using one-time cryptographic payment tokens. Once internet connectivity returns, all transactions are automatically synchronized with the backend. :contentReference[oaicite:2]{index=2}

---

## ✨ Features

- 🔐 Secure User Authentication
- 💰 Digital Wallet
- 📱 Offline QR Payments
- 🔄 Automatic Transaction Sync
- 🛡️ Double Spend Prevention
- 📊 Transaction History
- 📡 Offline-first Architecture
- ⚡ Progressive Web App (PWA)

---
<img width="613" height="438" alt="image" src="https://github.com/user-attachments/assets/0bacd26b-1410-4337-bd4e-3e6a54d4783e" />

---
## 🏗️ Tech Stack

### Frontend
- Angular 20 (PWA)
- TypeScript
- IndexedDB
- ZXing QR Scanner

### Backend
- Java 21
- Spring Boot
- Spring Security
- Spring Data JPA
- REST APIs

### Database
- PostgreSQL

### Tools
- Docker
- Maven
- Git
- GitHub
- Postman

---

## 🏛️ System Architecture

```
Angular PWA
      │
IndexedDB (Offline Storage)
      │
 QR Payment Engine
      │
Spring Boot REST API
      │
Authentication
Wallet Service
Token Service
Sync Engine
      │
 PostgreSQL
```

---

## 🚀 Project Roadmap

### ✅ Phase 1
- Spring Boot Setup
- User Registration
- Authentication
- PostgreSQL Integration

### ⏳ Phase 2
- Wallet Management
- JWT Authentication
- QR Code Generation

### ⏳ Phase 3
- Offline Token Generation
- IndexedDB Integration
- Offline Transactions

### ⏳ Phase 4
- Sync Engine
- Double Spend Prevention
- Transaction History

### ⏳ Phase 5
- Deployment
- Security Improvements
- Performance Optimization

---

## 📂 Project Structure

```
backend/
├── src/
│   ├── main/
│   │   ├── java/
│   │   ├── resources/
│   └── test/
├── pom.xml
├── docker-compose.yml
└── README.md
```

---

## ⚙️ Getting Started

### Clone Repository

```bash
git clone https://github.com/annattiwary12/OfflinePay.git
```

### Navigate

```bash
cd OfflinePay/backend
```

### Run PostgreSQL

```bash
docker compose up -d
```

### Start Spring Boot

```bash
./mvnw spring-boot:run
```

or

```bash
mvn spring-boot:run
```

---

## 📅 Current Progress

- ✅ Backend Initialized
- ✅ Spring Boot Configuration
- ✅ User Entity
- ✅ Registration API
- ✅ PostgreSQL Setup
- 🔄 Login API
- 🔄 JWT Authentication
- 🔄 Wallet APIs

---



## 🎯 Future Enhancements

- UPI Integration
- NFC Payments
- Biometric Authentication
- AI Fraud Detection
- Push Notifications
- Merchant Dashboard

---

## 👨‍💻 Author

**Anant Tiwary**

- LinkedIn: https://linkedin.com/in/annattiwary12
- GitHub: https://github.com/annattiwary12

---

⭐ If you like this project, consider giving it a star!
