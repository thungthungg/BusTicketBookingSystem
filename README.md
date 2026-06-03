# 🚌 Bus Ticket Booking System

## 📌 Project Overview

The Bus Ticket Booking System is a Java Object-Oriented Programming (OOP) application developed to manage bus ticket reservations. The system allows passengers to book seats, select different ticket types, apply discounts, confirm bookings, and manage seat availability efficiently.

This project demonstrates the implementation of fundamental OOP concepts such as Encapsulation, Inheritance, Polymorphism, Abstraction, Interface Implementation, and Exception Handling.

---

## 🚀 Features

### Passenger Management
- Store passenger information including ID, name, address, and phone number.
- Display passenger details through a graphical user interface.

### Ticket Management
- Support multiple ticket categories:
  - Standard Ticket
  - Premium Ticket
- Apply ticket discounts through the Discountable interface.
- Display ticket information using polymorphism.

### Booking Management
- Allow passengers to select and reserve seats.
- Prevent duplicate seat bookings.
- Confirm and cancel bookings.
- Calculate and display total booking price.
- Manage seat availability automatically.

### Exception Handling
- Validate seat numbers.
- Prevent booking of occupied seats.
- Display appropriate error messages when invalid operations occur.

---

## 🏗️ System Components

### Passenger Class
Responsible for storing and managing passenger information.

### Discountable Interface
Provides discount functionality that can be applied to ticket prices.

### Ticket Class (Abstract)
Serves as the parent class for all ticket types and contains common ticket attributes and behaviors.

### StandardTicket Class
Represents a standard bus ticket with baggage allowance features.

### PremiumTicket Class
Represents a premium bus ticket with additional benefits such as meal inclusion.

### Booking Class
Handles seat reservations, booking confirmation, cancellation, and booking information management.

### Custom Exceptions
- InvalidSeatException
- SeatTakenException

These exceptions improve system reliability by handling invalid seat selections and duplicate bookings.

### Main Class
Acts as the entry point of the application and demonstrates the system functionality.

---

## 📚 Object-Oriented Programming Concepts Implemented

### Encapsulation
Private attributes are protected and accessed through public getter and setter methods.

### Inheritance
StandardTicket and PremiumTicket inherit common properties and behaviors from the Ticket class.

### Polymorphism
Different ticket types implement their own version of ticket display functionality through method overriding.

### Abstraction
The Ticket class defines common ticket behavior while allowing subclasses to provide specific implementations.

### Interface Implementation
The Discountable interface provides a contract for applying discounts to ticket prices.

### Exception Handling
Custom exceptions are used to validate seat selection and prevent booking conflicts.

---

## 🛠️ Technologies Used

- Java
- Java Swing (JOptionPane)
- Object-Oriented Programming (OOP)
- Java Collections Framework (ArrayList)

---

## 📂 Project Structure

```text
busbooking/
│
├── Passenger.java
├── Discountable.java
├── Ticket.java
├── StandardTicket.java
├── PremiumTicket.java
├── Booking.java
├── SeatTakenException.java
├── InvalidSeatException.java
└── Main.java
```

---

## 🎯 Project Objectives

- Develop a bus ticket reservation system using Java.
- Apply Object-Oriented Programming principles in a real-world application.
- Demonstrate the use of inheritance, abstraction, polymorphism, and interfaces.
- Implement exception handling to improve system robustness.
- Provide a simple and user-friendly booking experience.

---

## 👥 Contributors

This project is developed as a group assignment. Team members contribute to different modules including passenger management, ticket management, booking management, exception handling, testing, and documentation.

---

## 📄 License

This project is developed for educational and academic purposes only.

---

## 🖥️ System Features (Interactive Menu)

The system now works as a **full interactive application** using a menu system:

### Main Menu Options
1. Create Booking  
   - Enter passenger details  
   - Choose ticket type (Standard / Premium)  
   - Enter destination and price  

2. Choose Seat  
   - Select seat number (1–100)  
   - Prevent duplicate seat booking  

3. Confirm Booking  
   - Finalize booking  
   - Calculate total price  

4. View Booking  
   - Display full booking details  
   - Show passenger + ticket info  

5. Cancel Booking  
   - Release reserved seat  
   - Cancel current booking  

6. Exit System  

---

## 🎯 System Upgrade

This version converts the project from a simple test program into a **fully interactive Java OOP system** with:

- Menu-driven user interface (JOptionPane)
- Real booking workflow
- Seat management system
- Exception handling integration
- Full OOP structure working together
