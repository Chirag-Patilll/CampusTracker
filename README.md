# CampusTracker

## Student Academic Management System

**CampusTracker** is a command-line based **Student Academic Management System** developed as a second-year college project using **Java**.

The system provides a simple way to manage:

- Student records
- Course records
- Student enrollments
- Attendance
- Academic reports
- Dashboard summaries
- Local file-based storage

The project demonstrates practical use of **Core Java, Object-Oriented Programming, Collections, Exception Handling, File I/O, Input Validation, and Multithreading**.

---

# Highlights

| Area | Details |
|------|---------|
| **Interface** | Command-line / Terminal based |
| **Language** | Java |
| **Build Tool** | Apache Maven |
| **Storage** | Text files |
| **Collections** | ArrayList, HashMap |
| **Error Handling** | Custom exceptions and validation |
| **Multithreading** | Background automatic save |
| **Version Control** | Git and GitHub |
| **Project Type** | Second-year Java college project |

---

# Main Modules

## 1. Student Management

Provides complete student record management.

### Features
- Add student
- List students
- Update student
- Delete student
- Validate student details
- Prevent duplicate student IDs

---

## 2. Course Management

Handles course information in the system.

### Features
- Add course
- List courses
- Update course
- Delete course
- Store course code
- Store course title
- Store credits
- Store faculty name
- Prevent duplicate course codes

---

## 3. Enrollment Management

Connects students with available courses.

### Features
- Enroll a student into a course
- List enrollments
- Validate student ID
- Validate course code
- Prevent invalid enrollment operations

---

## 4. Attendance Management

Records and calculates student attendance.

### Features
- Record attendance
- Update attendance
- Store attended classes
- Store total classes
- Calculate attendance percentage
- Check attendance eligibility

### Attendance Formula

```text
Attendance Percentage =
(Classes Attended / Total Classes) × 100

