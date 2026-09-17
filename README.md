# CampusTracker

## Student Academic Management System

### Project Overview

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

# Features

## 1. Student Management

Provides complete student record management.

- Add student
- List students
- Update student
- Delete student
- Validate student details
- Prevent duplicate student IDs

## 2. Course Management

Handles course information in the system.

- Add course
- List courses
- Update course
- Delete course
- Store course code
- Store course title
- Store credits
- Store faculty name
- Prevent duplicate course codes

## 3. Enrollment Management

Connects students with available courses.

- Enroll a student into a course
- List enrollments
- Validate student ID
- Validate course code
- Prevent duplicate enrollments

## 4. Attendance Management

Records and calculates student attendance.

- Record attendance
- Update attendance
- Store attended classes
- Store total classes
- Calculate attendance percentage
- Check attendance eligibility

### Attendance Formula

    Attendance Percentage =
    (Classes Attended / Total Classes) × 100

### Example

    Classes Attended = 18
    Total Classes = 20

    Attendance Percentage = 90.00%

## 5. Academic Reporting

The system provides:

- Student academic reports
- Attendance information
- Enrollment information
- Dashboard summaries
- Overall record counts
- Attendance eligibility information

## 6. Local Storage

Application data is stored locally using text files.

    data/students.txt
    data/courses.txt
    data/enrollments.txt
    data/attendance.txt

Data is loaded when the application starts and saved during application use.

## 7. Background Auto-Save

A background thread periodically saves application data while the program is running.

---

# Technologies and Concepts Used

| Technology / Concept | Usage |
|---|---|
| **Java** | Main programming language |
| **Core Java** | Application development |
| **OOP** | Classes, objects, encapsulation, constructors, and methods |
| **Inheritance** | Background save thread |
| **ArrayList** | Record storage |
| **HashMap** | Key-based data handling |
| **Exception Handling** | Error management |
| **Custom Exceptions** | Application-specific validation errors |
| **File I/O** | Data persistence |
| **Reader / Writer** | Text file operations |
| **Input Validation** | Checking user input |
| **Multithreading** | Background automatic saving |
| **Apache Maven** | Project build |
| **Git** | Version control |
| **GitHub** | Project repository |

---

# Requirements

- **JDK 27**
- **Apache Maven**
- **Git**
- Command Prompt, PowerShell, or another terminal
- NetBeans is optional

### Check Java

    java -version

### Check Maven

    mvn -version

---

# Installation and Run

## Clone the Repository

    git clone https://github.com/Chirag-Patilll/CampusTracker.git

    cd CampusTracker

## Build the Project

    mvn clean package

A successful build should end with:

    BUILD SUCCESS

## Run the Application

    java -cp target/classes com.mycompany.campustracker.CampusTracker

The application runs completely in the terminal and does not require a graphical interface.

---

# Run Through NetBeans

The project can also be opened as a Maven project in NetBeans.

### Main Class

    com.mycompany.campustracker.CampusTracker

Run the main class from NetBeans to start the application.

---

# Application Menu

    1. Add Student
    2. List Students
    3. Update Student
    4. Delete Student
    5. Add Course
    6. List Courses
    7. Update Course
    8. Delete Course
    9. Enroll Student in Course
    10. List Enrollments
    11. Record / Update Attendance
    12. Student Academic Report
    13. Dashboard
    14. Save Data Now
    15. Exit

---

# Example Workflow

## Add a Student

    Student ID: S101
    Name: Rahul Sharma
    Email: rahul@gmail.com
    Department: Computer Science
    Semester (1-8): 4

## Add a Course

    Course Code: JAVA201
    Course Title: Object Oriented Programming
    Credits (1-6): 4
    Faculty Name: Dr Mehta

## Enroll the Student

    Student ID: S101
    Course Code: JAVA201

## Record Attendance

    Student ID: S101
    Course Code: JAVA201
    Classes Attended: 18
    Total Classes: 20

Result:

    Attendance Percentage: 90.00%

---

# Validation and Error Handling

The application checks for:

- Missing student fields
- Missing course fields
- Invalid email format
- Invalid semester values
- Invalid course credit values
- Duplicate student IDs
- Duplicate course codes
- Missing students during enrollment
- Missing courses during enrollment
- Duplicate enrollments
- Invalid attendance values
- Attendance entry before enrollment
- Invalid numeric input
- File read/write problems

Invalid operations are reported to the user without unexpectedly terminating the application.

---

# Project Structure

    CampusTracker/
    ├── pom.xml
    ├── README.md
    ├── statement.md
    ├── .gitignore
    ├── data/
    ├── docs/
    │   ├── design.md
    │   └── test-plan.md
    ├── report/
    │   └── CampusTracker_Project_Report.pdf
    └── src/
        └── main/
            └── java/
                └── com/
                    └── mycompany/
                        └── campustracker/
                            └── CampusTracker.java

---

# Testing

The project includes a manual test plan located at:

    docs/test-plan.md

Testing covers:

- Student CRUD operations
- Course CRUD operations
- Enrollment
- Attendance recording
- Attendance calculation
- Invalid inputs
- Duplicate records
- Missing records
- Data saving
- Data loading
- Student reports
- Dashboard
- Background automatic saving

### Basic Verification

    mvn clean package

    java -cp target/classes com.mycompany.campustracker.CampusTracker

---

# Documentation

## Design Documentation

    docs/design.md

Contains:

- System architecture
- Application workflow
- Use case
- Class structure
- Storage design
- Project diagrams

## Test Documentation

    docs/test-plan.md

Contains:

- Manual test cases
- Testing approach
- Expected results
- Validation scenarios

---

# Project Report

The complete project report is available at:

    report/CampusTracker_Project_Report.pdf

The report contains:

- Introduction
- Problem Statement
- Functional Requirements
- Non-Functional Requirements
- System Architecture
- Workflow
- Use Case Design
- Class and Component Structure
- Sequence Design
- Data Storage
- Implementation
- Screenshots
- Testing
- Results
- Challenges
- Learnings
- Future Enhancements
- Conclusion
- References

---

# Key Project Features

| Feature | Description |
|---|---|
| **Student CRUD** | Add, view, update, and delete student records |
| **Course CRUD** | Add, view, update, and delete course records |
| **Enrollment** | Enroll students into courses |
| **Attendance** | Record attendance and calculate percentage |
| **Reporting** | Generate student academic reports |
| **Dashboard** | Display academic summaries |
| **File Storage** | Save and load data using text files |
| **Validation** | Check user input and record consistency |
| **Exception Handling** | Handle expected application errors |
| **Auto-Save** | Periodically save data using a background thread |
| **Collections** | Manage records using Java collections |
| **GitHub** | Maintain source code using version control |

---

# Learning Outcomes

This project provides practical experience in:

- **Java Programming**
- **Object-Oriented Programming**
- **Classes and Objects**
- **Encapsulation**
- **Inheritance**
- **Constructors and Methods**
- **Collections**
- **File Input and Output**
- **Reader and Writer**
- **Exception Handling**
- **Custom Exceptions**
- **Input Validation**
- **Multithreading**
- **Modular Programming**
- **Maven**
- **Git and GitHub**
- **Software Testing**
- **Technical Documentation**

---

# Future Enhancements

- Graphical User Interface using **JavaFX or Swing**
- Database integration using **JDBC**
- User authentication
- Role-based access
- Marks and grade management
- Semester result management
- PDF report generation
- Search and filtering
- Attendance analytics
- Charts and visual dashboards
- Web-based version

---

# Author

**Chirag Patil**  
**25BAI10151**  
**Programming in Java**  
**VIT Bhopal University**

---

# Repository

**GitHub Repository:**

https://github.com/Chirag-Patilll/CampusTracker
