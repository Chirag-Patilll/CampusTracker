# CampusTracker Test Plan

## Command-Line Build Test

Command:

```bash
mvn clean package
```

Expected result: Maven completes with `BUILD SUCCESS` and creates compiled classes in `target/classes`.

## Command-Line Run Test

Command:

```bash
java -cp target/classes com.mycompany.campustracker.CampusTracker
```

Expected result: The CampusTrack main menu is displayed in the terminal.

## Functional Test Cases

| Test | Input / Action | Expected Result |
|---|---|---|
| T1 | Add a valid student | Student is added |
| T2 | Add the same student ID again | Duplicate ID error |
| T3 | Enter invalid email | Validation error |
| T4 | Enter semester outside 1-8 | Validation error |
| T5 | Add a valid course | Course is added |
| T6 | Add duplicate course code | Duplicate code error |
| T7 | Enroll an existing student in an existing course | Enrollment succeeds |
| T8 | Enroll the same student twice | Duplicate enrollment error |
| T9 | Record attendance for an enrolled student | Attendance is saved |
| T10 | Record attended classes greater than total | Validation error |
| T11 | Generate a student report | Course and attendance details are shown |
| T12 | Open dashboard | Summary counts are shown |
| T13 | Save data and restart application | Previous records are loaded |
| T14 | Enter letters where numbers are required | Number-format error is shown |
| T15 | Exit application | Final data save is attempted |

## Acceptance Criteria

The project is ready for submission when:

1. `mvn clean package` completes successfully.
2. The main class runs from a terminal.
3. Core CRUD operations work.
4. Enrollment and attendance validation work.
5. Reports and dashboard display correctly.
6. Data persists across application restarts.
7. README and statement files are present at repository root.
8. The design documentation and report are included in the repository.
