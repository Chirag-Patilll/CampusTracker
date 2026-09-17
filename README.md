\# CampusTracker



CampusTracker is a Java-based Student Academic Management System developed as a second-year college project. The application provides a command-line interface for managing students, courses, course enrollments, attendance records, and academic reports.



The project is designed using Java, Maven, object-oriented programming, collections, file handling, exception handling, and multithreading.



\## Features



\* Add new students

\* View all students

\* Update student details

\* Delete students

\* Add new courses

\* View all courses

\* Update course details

\* Delete courses

\* Enroll students in courses

\* View enrollments

\* Record and update attendance

\* Generate individual student academic reports

\* Display an academic dashboard

\* Save data to text files

\* Load saved data when the application starts

\* Automatic background data saving

\* Input validation and exception handling



\## Technologies Used



\* Java

\* Maven

\* Java Collections Framework

\* File Handling

\* Exception Handling

\* Multithreading

\* Object-Oriented Programming



\## Requirements



The following software is required:



\* JDK 27

\* Apache Maven

\* Git

\* Command Prompt or any terminal



Check Java installation:



```bash

java -version

```



Check Maven installation:



```bash

mvn -version

```



\## Project Structure



```text

CampusTracker/

├── pom.xml

├── README.md

├── statement.md

├── src/

│   └── main/

│       └── java/

│           └── com/

│               └── mycompany/

│                   └── campustracker/

│                       └── CampusTracker.java

└── data/

```



The `data` folder is created automatically when the application runs.



\## Setup



First clone the repository:



```bash

git clone https://github.com/Chirag-Patilll/CampusTracker.git

```



Move into the project directory:



```bash

cd CampusTracker

```



\## Build the Project



Run the following command:



```bash

mvn clean package

```



This compiles the Java source code and creates the project build files.



\## Run the Project



The application can be run from the command line with:



```bash

java -cp target/classes com.mycompany.campustracker.CampusTracker

```



The program will start in the terminal and display the main menu.



\## Running Through NetBeans



The project can also be opened in Apache NetBeans as a Maven project.



Open the project in NetBeans and run the main class:



```text

com.mycompany.campustracker.CampusTracker

```



\## Main Menu



When the program starts, the following options are available:



```text

1\\. Add Student

2\\. List Students

3\\. Update Student

4\\. Delete Student

5\\. Add Course

6\\. List Courses

7\\. Update Course

8\\. Delete Course

9\\. Enroll Student in Course

10\\. List Enrollments

11\\. Record / Update Attendance

12\\. Student Academic Report

13\\. Dashboard

14\\. Save Data Now

0\\. Exit

```



\## Student Example



Select option `1` and enter:



```text

Student ID: S101

Name: Rahul Sharma

Email: rahul@gmail.com

Department: Computer Science

Semester (1-8): 4

```



The system validates the student information before saving it.



\## Course Example



Select option `5` and enter:



```text

Course code: JAVA201

Course title: Object Oriented Programming

Credits (1-6): 4

Faculty name: Dr Mehta

```



\## Enrollment Example



Select option `9`:



```text

Student ID: S101

Course code: JAVA201

```



The student must exist and the course must exist before enrollment is accepted.



\## Attendance Example



Select option `11`:



```text

Student ID: S101

Course code: JAVA201

Classes attended: 18

Total classes: 20

```



The application calculates the attendance percentage automatically.



For the above example:



```text

Attendance = 90.00%

```



The system marks attendance as `ELIGIBLE` when the percentage is 75% or above.



\## Academic Report



Select option `12` and enter the student ID:



```text

S101

```



The report displays the student's department, semester, enrolled courses, and attendance information.



\## Dashboard



Select option `13` to display:



\* Total students

\* Total courses

\* Total enrollments

\* Total attendance records

\* Eligible attendance records

\* Student count by department



\## Data Storage



The application uses text files for persistent storage.



The following files are used:



```text

data/students.txt

data/courses.txt

data/enrollments.txt

data/attendance.txt

```



Records are loaded when the application starts and saved when requested or when the application exits.



\## Validation



The application checks:



\* Empty student fields

\* Empty course fields

\* Valid email format

\* Valid semester range

\* Valid credit range

\* Duplicate student IDs

\* Duplicate course codes

\* Existing students and courses for enrollment

\* Valid attendance values

\* Enrollment before recording attendance



\## Exception Handling



The application uses custom exceptions for validation and storage-related errors.



Invalid input is handled without stopping the entire application.



\## Multithreading



The project includes an automatic save thread.



The background thread periodically saves the current application data while the program is running.



\## Testing



The project can be tested from the command line using:



```bash

mvn clean package

```



Then:



```bash

java -cp target/classes com.mycompany.campustracker.CampusTracker

```



Important test cases include:



```text

1\\. Add a valid student

2\\. Add a duplicate student

3\\. Add a valid course

4\\. Add a duplicate course

5\\. Update student information

6\\. Update course information

7\\. Enroll an existing student

8\\. Try enrolling a non-existing student

9\\. Record valid attendance

10\\. Try invalid attendance values

11\\. Generate a student report

12\\. Display the dashboard

13\\. Save and reload data

14\\. Exit the application and verify stored data

```



\## Author



Chirag Patil



\## Project Type



Second Year College Project



\## Repository



https://github.com/Chirag-Patilll/CampusTracker

