# CampusTracker Design Diagrams



## 1. System Architecture

```mermaid
flowchart TD
    U[User] --> M[CampusTracker Main Menu]
    M --> S[Student Management]
    M --> C[Course Management]
    M --> E[Enrollment Management]
    M --> A[Attendance Management]
    M --> R[Report and Dashboard]
    S --> V[Validation and Exceptions]
    C --> V
    E --> V
    A --> V
    S --> D[Data Store]
    C --> D
    E --> D
    A --> D
    R --> D
    T[Auto Save Thread] --> D
    D --> F[(Text Files)]
```

## 2. Workflow Diagram

```mermaid
flowchart TD
    A([Start]) --> B[Load saved data]
    B --> C[Show main menu]
    C --> D{Choose option}
    D -->|Student| E[Student CRUD]
    D -->|Course| F[Course CRUD]
    D -->|Enrollment| G[Enroll student]
    D -->|Attendance| H[Record attendance]
    D -->|Report| I[Generate report]
    D -->|Dashboard| J[Show dashboard]
    D -->|Save| K[Save data]
    D -->|Exit| L[Final save]
    E --> V{Valid input?}
    F --> V
    G --> V
    H --> V
    V -->|No| X[Show error]
    V -->|Yes| Y[Update records]
    X --> C
    Y --> C
    I --> C
    J --> C
    K --> C
    L --> Z([End])
```

## 3. Use Case Diagram

```mermaid
flowchart LR
    U[User]
    U --> A1[Manage Students]
    U --> A2[Manage Courses]
    U --> A3[Enroll Student]
    U --> A4[Manage Attendance]
    U --> A5[Generate Student Report]
    U --> A6[View Dashboard]
    U --> A7[Save Data]
```

## 4. Class Diagram

```mermaid
classDiagram
    class CampusTracker
    class St
    class Cr
    class En
    class At
    class Ss
    class Cs
    class Es
    class As
    class Rs
    class Ds
    class Ast
    class VE
    class SE

    CampusTracker --> Ss
    CampusTracker --> Cs
    CampusTracker --> Es
    CampusTracker --> As
    CampusTracker --> Rs
    CampusTracker --> Ds
    CampusTracker --> Ast
    Ss --> St
    Cs --> Cr
    Es --> En
    As --> At
    Es --> Ss
    Es --> Cs
    As --> Es
    Rs --> St
    Rs --> Cr
    Rs --> En
    Rs --> At
    Ds --> St
    Ds --> Cr
    Ds --> En
    Ds --> At
    Ast --> Ds
    VE <|-- CampusTracker
    SE <|-- Ds
```

## 5. Storage Schema

The project uses text-file persistence instead of a relational database.

```mermaid
erDiagram
    STUDENT ||--o{ ENROLLMENT : has
    COURSE ||--o{ ENROLLMENT : contains
    STUDENT ||--o{ ATTENDANCE : has
    COURSE ||--o{ ATTENDANCE : records

    STUDENT {
        string id PK
        string name
        string email
        string department
        int semester
    }
    COURSE {
        string code PK
        string title
        int credits
        string faculty
    }
    ENROLLMENT {
        string student_id FK
        string course_code FK
    }
    ATTENDANCE {
        string student_id FK
        string course_code FK
        int attended
        int total
    }
```
