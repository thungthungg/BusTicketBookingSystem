# 🚌 Bus Ticket Booking System

[![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.java.com/)
[![Swing](https://img.shields.io/badge/Swing-5382a1?style=for-the-badge&logo=java&logoColor=white)](https://docs.oracle.com/javase/tutorial/uiswing/)
[![OOP](https://img.shields.io/badge/OOP-4B8BBE?style=for-the-badge&logo=object&logoColor=white)](https://en.wikipedia.org/wiki/Object-oriented_programming)
[![Version](https://img.shields.io/badge/Version-2.0-blue?style=for-the-badge)]()

<p align="center">
  <img src="https://img.shields.io/badge/Status-Active-brightgreen?style=flat-square" alt="Active">
  <img src="https://img.shields.io/badge/Platform-Cross%20Platform-lightgrey?style=flat-square" alt="Cross Platform">
  <img src="https://img.shields.io/badge/License-Academic-blue?style=flat-square" alt="Academic">
</p>

---

## 📖 Table of Contents

- [✨ Overview](#-overview)
- [🚀 Features](#-features)
- [📚 OOP Concepts](#-oop-concepts)
- [🛠️ Technologies](#️-technologies)
- [📂 Project Structure](#-project-structure)
- [🎮 User Guide](#-user-guide)
- [👥 Contributors](#-contributors)

---

## ✨ Overview

> **A comprehensive Java-based bus ticket reservation system** built with Object-Oriented Programming principles. This application provides an intuitive interface for passengers to browse routes, book tickets, apply discounts, and manage reservations efficiently.

The system supports **multiple ticket types** (Standard & Premium), **dynamic discount options**, and **robust exception handling** to ensure a seamless booking experience.

---

## 🚀 Features

### 🎫 Ticket Management
| Feature | Description |
|---------|-------------|
| **Standard Ticket** | Basic ticket with baggage allowance |
| **Premium Ticket** | Luxury ticket with meal inclusion |
| **Multiple Routes** | KL ↔ Penang, KL ↔ Johor Bahru, and more |
| **Real-time Availability** | Automatic ticket status management |

### 👤 Passenger Management
- Store passenger details (ID, Name, Address, Phone)
- Passenger information validation
- View passenger booking history

### 💰 Discount System
| Discount Type | Percentage |
|---------------|------------|
| 🎓 Student Discount | 10% |
| 👴 Senior Citizen | 15% |
| 🌅 Early Bird | 20% |

### 💳 Payment Methods
- 💵 Cash
- 💳 Credit Card
- 🏦 Online Banking
- 📱 E-Wallet

### 🛡️ Exception Handling
- `TicketNotAvailableException` - No tickets for selected route
- `BookingNotFoundException` - Invalid booking cancellation
- Input validation for all user entries

---

## 📚 OOP Concepts

| Concept | Implementation |
|---------|----------------|
| **Encapsulation** | Private attributes with public getters/setters in Passenger, Ticket, Booking classes |
| **Inheritance** | `StandardTicket` and `PremiumTicket` extend `Ticket` |
| **Polymorphism** | `displayTicket()` method overridden in subclasses |
| **Abstraction** | `Ticket` abstract class with abstract method `displayTicket()` |
| **Interface** | `Discountable` interface implemented by `Ticket` |
| **Exception Handling** | Custom exceptions (`TicketNotAvailableException`, `BookingNotFoundException`) |

---

## 🛠️ Technologies

| Technology | Purpose |
|------------|---------|
| ☕ **Java SE** | Core programming language |
| 🖼️ **Java Swing** | GUI components (JOptionPane) |
| 📚 **Collections Framework** | ArrayList for data storage |
| 🔧 **OOP Principles** | System design and architecture |

---


---

## 🎮 User Guide

### Main Menu Options

| Option | Action |
|--------|--------|
| 1 | 📝 Book a Ticket |
| 2 | ❌ Cancel Booking |
| 3 | 📋 View All Bookings |
| 4 | 🗺️ View Available Routes |
| 5 | 🚪 Exit |

### Booking Flow

1. Enter passenger details (ID, Name, Address, Phone)
2. Select origin and destination
3. Choose travel date
4. Select ticket type (Standard/Premium)
5. Apply discount (if applicable)
6. Choose payment method
7. Confirm booking
8. Receive unique Booking ID

### Available Routes

| Route | Standard Price | Premium Price |
|-------|---------------|---------------|
| Kuala Lumpur → Penang | RM 45 | RM 85 |
| Kuala Lumpur → Johor Bahru | RM 55 | RM 95 |
| Penang → Kuala Lumpur | RM 45 | RM 85 |
| Johor Bahru → Kuala Lumpur | RM 55 | - |

---

## 🎯 System Capabilities

- ✅ Create new bookings with passenger details
- ✅ Browse available routes and schedules
- ✅ Select between Standard and Premium tickets
- ✅ Apply various discount types
- ✅ Choose from multiple payment methods
- ✅ Cancel existing bookings
- ✅ View all booking records
- ✅ Generate unique Booking IDs
- ✅ Handle errors gracefully with custom exceptions

---

## 👥 Contributors

This project is developed as a group assignment. Team members contributed to:

| Module | Responsibility |
|--------|----------------|
| Passenger Management | Passenger class implementation |
| Ticket Management | Ticket, StandardTicket, PremiumTicket |
| Booking Management | Booking class & discount logic |
| Exception Handling | Custom exceptions & validation |
| UI & Integration | Main menu & system workflow |
| Documentation | README & project report |

---

## 📄 License

This project is developed for **educational and academic purposes** only.

---

## 🙏 Acknowledgments

- Java Swing library for GUI components
- Object-Oriented Programming principles
- Bus booking domain requirements

---

<div align="center">

### 🚀 Happy Booking! 🚀

*Developed with ☕ Java and OOP principles*

</div>

## 📂 Project Structure
