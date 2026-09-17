CampusTracker

CampusTracker is a command-line Student Academic Management System developed as a second-year Java college project. It manages students, courses, enrollments, attendance, academic reports, and dashboard information using core Java concepts.

Main Modules

Student Management - add, view, update, and delete student records.

Course and Enrollment Management - manage courses and enroll students.

Attendance and Reporting - record attendance, calculate percentages, generate student reports, and show dashboard summaries.

Local Storage - save and load application data using text files.

Java Concepts Used

Classes and objects

Encapsulation

Constructors and methods

Inheritance through the background save thread

ArrayList and HashMap

Custom exception handling

File I/O with Reader and Writer classes

Input validation

Multithreading

Basic service-based separation of responsibilities

Requirements

JDK 27

Apache Maven

Git

Command Prompt, PowerShell, or another terminal

Check Java:

java -version

Check Maven:

mvn -version

Project Structure

CampusTracker/
|-- pom.xml
|-- README.md
|-- statement.md
|-- .gitignore
|-- data/
|-- docs/
|   |-- design.md
|   `-- test-plan.md
|-- report/
|   `-- CampusTracker_Project_Report.pdf
`-- src/
    `-- main/
        `-- java/
            `-- com/
                `-- mycompany/
                    `-- campustracker/
                        `-- CampusTracker.java

The data directory is created automatically if it is missing.

Clone the Repository

git clone https://github.com/Chirag-Patilll/CampusTracker.git
cd CampusTracker

Build the Project

Run from the project root:

mvn clean package

A successful build should end with BUILD SUCCESS.

Run from the Command Line

After a successful build:

java -cp target/classes com.mycompany.campustracker.CampusTracker

The application runs completely in the terminal and does not require a graphical interface.

Run Through NetBeans

Open the project as a Maven project in NetBeans. The main class is:

com.mycompany.campustracker.CampusTracker

Menu

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
0. Exit

Example Workflow

Add a student:

Student ID: S101
Name: Rahul Sharma
Email: rahul@gmail.com
Department: Computer Science
Semester (1-8): 4

Add a course:

Course code: JAVA201
Course title: Object Oriented Programming
Credits (1-6): 4
Faculty name: Dr Mehta

Enroll the student:

Student ID: S101
Course code: JAVA201

Record attendance:

Student ID: S101
Course code: JAVA201
Classes attended: 18
Total classes: 20

The system calculates 90.00% attendance for this example.

Data Storage

The application stores data in these text files:

data/students.txt
data/courses.txt
data/enrollments.txt
data/attendance.txt

Data is loaded when the application starts and saved when the user selects Save Data or exits the program. A background thread also performs periodic saving.

Validation and Error Handling

The application checks for:

Missing student and course fields

Invalid email format

Invalid semester values

Invalid course credit values

Duplicate student IDs

Duplicate course codes

Missing students or courses during enrollment

Invalid attendance values

Attendance entry before enrollment

File read/write problems

Invalid numeric input

Testing

The manual test plan is available in docs/test-plan.md.

Basic command-line verification:

mvn clean package
java -cp target/classes com.mycompany.campustracker.CampusTracker

Test the normal workflow, invalid inputs, duplicate records, attendance calculations, data saving, and data loading after restarting the application.

Documentation

The docs/design.md file contains the project architecture, workflow, use case, class, and storage diagrams in Mermaid format.

The project report is available at:

report/CampusTracker_Project_Report.pdf

Author

Chirag Patil
25BAI10151