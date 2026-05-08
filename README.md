# Smart Booking System for Soundproof Group Work Rooms

## 📌 Project Overview

This project was developed for **Narxoz University** (a business school) as part of the **Computer Architecture** course.

### The Problem

- Narxoz University has **many group projects** – almost every subject requires teamwork
- The library is **very noisy** – no separate rooms for group work
- The campus is **small** – cannot build many rooms
- There are **too many students** – long queues and wasted time

### Our Solution

- Create **soundproof rooms** for group projects
- Build a **web application** for online booking
- Implement a **7-person minimum rule** – prevents small groups from wasting space

---

## 🛠️ Technologies Used

| Technology | Purpose |
|------------|---------|
| Java 17 | Programming language |
| Spring Boot 4.0.6 | Web framework |
| Spring Data JPA | Database access |
| H2 Database | In-memory database |
| Maven | Build tool |
| REST API | Communication interface |

---

## 📁 Project Structure
src/main/java/bekarys/groupprojectmanager/
├── controller/ # Handles HTTP requests (REST API)
├── service/ # Business logic (7-person rule validation)
├── repository/ # Database operations (JPA)
├── entity/ # Database entities (Student, Room, etc.)
└── GroupProjectManagerApplication.java # Main entry point

**Architecture:** Controller → Service → Repository → Database

---

## 📊 Database Schema (5 Entities)

| Entity | Description |
|--------|-------------|
| **Student** | Student information (id, name, email, rating) |
| **ProjectGroup** | Group project details (topic, status, max 7 members) |
| **GroupMembership** | Links Students and Groups with confirmation status |
| **Room** | Soundproof room information (name, capacity, equipment) |
| **Booking** | Room booking records (time, status, access code) |

**Key rule:** A booking can only be created when a group has **7 confirmed members** (checked via `isGroupComplete()` method).

---

##  REST API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/students` | Get all students |
| POST | `/api/students` | Create a new student |
| GET | `/api/rooms` | Get all rooms |
| POST | `/api/rooms` | Create a new room |
| GET | `/api/groups` | Get all project groups |
| POST | `/api/groups` | Create a new group |
| GET | `/api/bookings` | Get all bookings |
| POST | `/api/bookings` | Create a booking (checks 7-person rule) |
| GET | `/api/bookings/group/{id}/canBook` | Check if group can book |

---

##  How to Run the Project

### Prerequisites
- Java 17 or higher
- IntelliJ IDEA (or any Java IDE)
- Maven

### Steps
1. Clone the repository:
   ```bash
   git clone https://github.com/YOUR_USERNAME/smart-booking-system.git
