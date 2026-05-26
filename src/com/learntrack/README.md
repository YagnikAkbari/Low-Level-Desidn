# LearnTrack — Student Enrollment Management System

A console-based Java application for managing Students, Courses, and Enrollments. Built to demonstrate core Java OOP concepts including inheritance, polymorphism, encapsulation, constructor/method overloading, exception handling, and layered architecture.

---

## Features

- **Student Management** — Add, view all, search by ID, deactivate students
- **Course Management** — Add, view all, activate/deactivate courses
- **Enrollment Management** — Enroll students in courses, view all enrollments, update status (Completed/Cancelled)
- **Interactive Menu** — Menu-driven console UI using `Scanner` with `while` + `switch`
- **Input Validation** — Custom validators with `InvalidInputException` for bad data
- **Error Handling** — `EntityNotFoundException` for missing records, `InputMismatchException` for invalid menu input

---

## Project Structure

```
src/com/airtribe/learntrack/
├── Main.java                          # Entry point — interactive menu UI
├── constants/
│   ├── AppConstants.java              # App-level constants (limits, messages)
│   └── MenuOptions.java               # Menu display strings
├── entity/
│   ├── Person.java                    # Base class (inheritance)
│   ├── Student.java                   # Extends Person
│   ├── Trainer.java                   # Extends Person
│   ├── Course.java                    # Course entity
│   └── Enrollment.java               # Enrollment entity
├── enums/
│   ├── CourseStatus.java              # ACTIVE, INACTIVE
│   └── EnrollmentStatus.java         # ACTIVE, COMPLETED, CANCELLED
├── exception/
│   ├── EntityNotFoundException.java   # Custom exception
│   └── InvalidInputException.java     # Custom exception
├── repository/
│   ├── StudentRepository.java         # Student data access (ArrayList)
│   ├── CourseRepository.java          # Course data access (ArrayList)
│   └── EnrollmentRepository.java      # Enrollment data access (ArrayList)
├── service/
│   ├── StudentService.java            # Student business logic
│   ├── CourseService.java             # Course business logic
│   └── EnrollmentService.java         # Enrollment business logic
├── util/
│   ├── IdGenerator.java               # Centralized static ID generation
│   └── InputValidator.java            # String/email validation utilities
├── validators/
│   ├── StudentValidator.java          # Student input validation
│   ├── CourseValidator.java           # Course input validation
│   └── EnrollmentValidator.java       # Enrollment input validation
└── docs/
    ├── Setup_Instructions.md          # Environment setup guide
    ├── JVM_Basics.md                  # JDK vs JRE vs JVM, bytecode, WORA
    └── Design_Notes.md               # Architecture & design decisions
```

---

## How to Compile & Run

### Prerequisites
- **JDK 17+** installed
- Terminal / Command Prompt

### Compile
```bash
cd LearnTrack
javac -d out src/com/airtribe/learntrack/**/*.java src/com/airtribe/learntrack/Main.java
```

### Run
```bash
java -cp out com.learntrack.Main
```

---

## OOP Concepts Demonstrated

| Concept | Where |
|---------|-------|
| **Encapsulation** | Private fields + public getters/setters in all entities |
| **Inheritance** | `Student extends Person`, `Trainer extends Person` |
| **Polymorphism** | `getDisplayName()` overridden in Student and Trainer |
| **Constructor Overloading** | Default + parameterized constructors on every entity |
| **Method Overloading** | `getStudentById(int)` and `getStudentById(String)` in StudentRepository |
| **Static** | `IdGenerator` counters, `AppConstants`, `MenuOptions`, `InputValidator` |
| **Custom Exceptions** | `EntityNotFoundException`, `InvalidInputException` |
| **Exception Handling** | try-catch for business errors + `InputMismatchException` for menu input |
