Project Statement



Project Title



CampusTracker - Student Academic Management System



Problem Statement



Managing student academic records manually can become difficult when student details, course information, enrollments, and attendance records grow over time. Basic activities such as updating records, checking attendance, and preparing student-level reports become inconvenient when information is stored separately.



CampusTracker provides a small command-line Java application that keeps these academic activities in one place and supports common record-management operations through a menu-driven interface.



Scope



The project covers:



Student CRUD operations



Course CRUD operations



Course enrollment



Attendance recording and updating



Attendance percentage calculation



Student academic reports



Dashboard summaries



Local file-based persistence



Input validation and custom error handling



Background auto-save



Target Users



Students demonstrating Java programming concepts



Faculty members who need simple academic record management



Academic/project evaluators reviewing the implementation



High-Level Features



Student Management



Users can add, view, update, and delete student records. The system checks required fields, email format, duplicate IDs, and semester range.



Course Management



Users can add, view, update, and delete course records. Course code duplication and credit range are validated.



Enrollment Management



Users can enroll an existing student in an existing course. Duplicate enrollments are prevented.



Attendance Management



Users can store attendance for enrolled students. The system validates the attended and total class counts and calculates attendance percentage.



Reporting



The system generates a student academic report and a dashboard summary containing overall record counts and attendance eligibility information.



Storage



Application records are stored locally in text files and loaded again when the program starts.



Objectives



Apply object-oriented programming concepts to a practical academic problem.



Demonstrate Java collections for record management.



Use file handling for persistent storage.



Apply exception handling and input validation.



Demonstrate multithreading through automatic background saving.



Provide a fully command-line executable application.



Non-Functional Requirements



Performance



For normal college-sized datasets, common menu operations should complete without noticeable delay.



Usability



The application should provide clear menu options and simple prompts so a first-time user can operate it from a terminal.



Reliability



Saved records should remain available after the application is closed and started again, provided the data files are not removed or corrupted.



Maintainability



The implementation separates model, service, reporting, storage, and thread responsibilities through distinct classes, even though the current submission uses a single Java source file.



Error Handling



Invalid input and storage errors should be reported without unexpectedly terminating the application.



Limitations



The current interface is command-line based.



Data is stored in text files instead of a database.



There is no user authentication or role management.



The system is intended for small-scale academic record management.



Future Enhancements



GUI using JavaFX or Swing



JDBC/database integration



User authentication and roles



Marks and grade management



PDF report export



Search and filtering



Attendance analytics and charts



Summary



CampusTracker demonstrates how core Java features can be combined to solve a practical academic record-management problem. The project includes CRUD operations, collections, file I/O, exception handling, validation, reporting, and multithreading in a single terminal-based application.

