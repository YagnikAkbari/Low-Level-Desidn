# 📘 LearnTrack – Project Summary & Learning Objectives

## 1. Project Summary

**LearnTrack** is a console-based **Student & Course Management System** built using Core Java.

It allows admins to manage:

- Students
- Courses
- Enrollments

### 🎯 Purpose of the Project

This project is designed to help you practice:

- Java basics (variables, data types, control flow)
- Classes, objects, and constructors
- Static vs instance members
- OOP principles:
  - Encapsulation
  - Basic inheritance
  - Polymorphism
- Collections (`ArrayList`)
- Basic exception handling
- Writing clean, readable, and modular code

### ⚠️ Scope Note

This project intentionally focuses on **fundamentals only**.

Advanced topics like:

- Concurrency
- Streams
- Complex design patterns

👉 are **not included for now** and can be added later as you progress.

---

## 2. Learning Objectives

By completing LearnTrack, you should be comfortable with the following:

---

### ⚙️ Java Setup & Compilation

- Installing and configuring JDK
- Understanding:
  - JDK vs JRE vs JVM
- Compiling and running Java programs using:
  - IDE
  - Terminal

---

### 🧠 Core Java Syntax & Basics

- Packages, classes, and `main` method
- Data types:
  - Primitive types
  - Reference types
- Variables and scope:
  - Local
  - Instance
  - Static
- Basics of typecasting

---

### 🏗️ OOP Fundamentals

- Creating classes and objects
- Constructors:
  - Default constructor
  - Parameterized constructor
  - Constructor overloading
- Encapsulation:
  - Private fields
  - Getters and setters
- Inheritance (basic)
- Method overriding
- Simple polymorphism

---

### 🔁 Logic & Control Flow

- Conditional statements:
  - `if / else`
  - `switch`
- Loops:
  - `for`
  - `while`
  - `do-while`
- Using control flow in a menu-driven application

---

### 📦 Collections

- Difference between:
  - Arrays
  - `ArrayList`
- Why `ArrayList` is preferred for dynamic data
- Storing and retrieving objects using `ArrayList`

---

### ⚠️ Exception Handling (Basic)

- Using `try-catch`
- Handling:
  - Invalid input
  - Wrong menu options
  - Empty data scenarios

---

### 🧼 Clean Code Mindset

- Writing small, focused functions
- Using meaningful method names
- Separation of concerns:
  - Entity layer
  - Service layer
  - UI layer

---

## 🚀 End Goal

Build a **structured, maintainable console application** that demonstrates:

- Strong Core Java fundamentals
- Clear architecture
- Real-world coding discipline

---

## 3. Project Summary

**LearnTrack** is a console-based **Student & Course Management System** built using Core Java.

It allows admins to manage:

- Students
- Courses
- Enrollments

### 🎯 Purpose of the Project

This project is designed to help you practice:

- Java basics (variables, data types, control flow)
- Classes, objects, and constructors
- Static vs instance members
- OOP principles:
  - Encapsulation
  - Basic inheritance
  - Polymorphism
- Collections (`ArrayList`)
- Basic exception handling
- Writing clean, readable, and modular code

### ⚠️ Scope Note

This project intentionally focuses on **fundamentals only**.

Advanced topics like:

- Concurrency
- Streams
- Complex design patterns

👉 are **not included for now** and can be added later as you progress.

---

## 2. Learning Objectives

By completing LearnTrack, you should be comfortable with the following:

---

### ⚙️ Java Setup & Compilation

- Installing and configuring JDK
- Understanding:
  - JDK vs JRE vs JVM
- Compiling and running Java programs using:
  - IDE
  - Terminal

---

### 🧠 Core Java Syntax & Basics

- Packages, classes, and `main` method
- Data types:
  - Primitive types
  - Reference types
- Variables and scope:
  - Local
  - Instance
  - Static
- Basics of typecasting

---

### 🏗️ OOP Fundamentals

- Creating classes and objects
- Constructors:
  - Default constructor
  - Parameterized constructor
  - Constructor overloading
- Encapsulation:
  - Private fields
  - Getters and setters
- Inheritance (basic)
- Method overriding
- Simple polymorphism

---

### 🔁 Logic & Control Flow

- Conditional statements:
  - `if / else`
  - `switch`
- Loops:
  - `for`
  - `while`
  - `do-while`
- Using control flow in a menu-driven application

---

### 📦 Collections

- Difference between:
  - Arrays
  - `ArrayList`
- Why `ArrayList` is preferred for dynamic data
- Storing and retrieving objects using `ArrayList`

---

### ⚠️ Exception Handling (Basic)

- Using `try-catch`
- Handling:
  - Invalid input
  - Wrong menu options
  - Empty data scenarios

---

### 🧼 Clean Code Mindset

- Writing small, focused functions
- Using meaningful method names
- Separation of concerns:
  - Entity layer
  - Service layer
  - UI layer

---

## 🚀 End Goal

Build a **structured, maintainable console application** that demonstrates:

- Strong Core Java fundamentals
- Clear architecture
- Real-world coding discipline

 
## 3. LearnTrack Project Guide (Core Java)

## A. Environment Setup & JVM Understanding (10 marks)

### Setup Instructions

- Install JDK (Java Development Kit)
- Verify installation:
  ```bash
  java -version
  javac -version
  ```

### Setup_Instructions.md should include:

- JDK version used
- Steps to run Hello World:

  ```java
  public class Main {
      public static void main(String[] args) {
          System.out.println("Hello World");
      }
  }
  ```

- Compile & Run:

  ```bash
  javac Main.java
  java Main
  ```

### JVM_Basics.md

#### JDK, JRE, JVM

- **JDK**: Full toolkit for development (compiler + tools)
- **JRE**: Runtime environment to run Java programs
- **JVM**: Executes Java bytecode

#### Bytecode

- Intermediate code generated by compiler
- Platform-independent

#### Write Once, Run Anywhere

Java code is compiled into bytecode which runs on JVM. Since JVM exists on multiple platforms, the same code runs everywhere without changes.

---

## B. Package Structure & Basics (10 marks)

### Base Package

```
com.learntrack
```

### Sub-packages

- `entity` → Student, Course, Enrollment
- `service` → Business logic
- `ui` → Main.java (menu)
- `exception` → Custom exceptions
- `util` → Helper classes
- `docs` → Documentation

### Concepts to Demonstrate

- Proper package usage
- Access modifiers:
  - `public`
  - `private`
  - `default`

- Static usage:
  - ID generators
  - Utility methods

---

## C. Core OOP Implementation (40 marks)

### 1. Entities & Encapsulation (15 marks)

#### Student

- id, firstName, lastName, email, batch, active (boolean)

#### Course

- id, courseName, description, durationInWeeks, active

#### Enrollment

- id, studentId, courseId, enrollmentDate, status (e.g., "ACTIVE", "COMPLETED", "CANCELLED" as String or simple enum if you want slightly advanced)

### Requirements

- Private fields + getters/setters
- Constructors (default + parameterized)
- Constructor overloading

---

### 2. Inheritance & Polymorphism (10 marks)

#### Base Class: Person

- id, firstName, lastName, email

#### Child Classes

- Student extends Person
- (Optional) Trainer extends Person

### Concepts

- Use of `super` keyword
- Method overriding (e.g., `getDisplayName()`)

---

### 3. Static, Methods, Utility (15 marks)

#### IdGenerator

- Static counters (eg. studentIdCounter)
- Methods:
  - `getNextStudentId()`
  - `getNextCourseId()`

#### Service Methods

- addStudent
- updateStudent
- removeStudent
- listStudents

#### Concepts

- Method overloading
- Static usage

---

## D. Application Logic & Menu UI (25 marks)

### Features

#### Student Management

- Add student
- View all students
- Search by ID
- Deactivate student

#### Course Management

- Add course
- View courses
- Activate/Deactivate

#### Enrollment Management

- Enroll student
- View enrollments
- Update status (Mark enrollment as completed/cancelled)

### Implementation

- Use `ArrayList` for storage
- Menu-driven console
- Use loops & conditionals
- Handle invalid input gracefully:
  - Option not found
  - Non-existent student/course IDs

### Best Practice

- Keep logic in services
- Keep Main.java only for:
  - Input
  - Menu display
  - Method calls (service method)

---

## E. Exception Handling (10 marks)

### Custom Exceptions

- `EntityNotFoundException` (Student or Course is not found.)
- `InvalidInputException` (optional)

### Usage

- Handle invalid IDs
- Handle wrong inputs
- Use try-catch
- Show user-friendly messages

---

## F. Documentation & Clean Code (5 marks)

### README.md

- Project overview
- Compile & run steps

### Design_Notes.md

- Why ArrayList used
- Where static is used
- Where inheritance is used

### Clean Code Principles

- Small methods
- Meaningful names
- Avoid unnecessary complexity

---

## 📁 Suggested Directory Structure

```
src/
└── com/
    └── airtribe/
        └── learntrack/
            ├── Main.java
            │
            ├── entity/
            │   ├── Person.java
            │   ├── Student.java
            │   ├── Course.java
            │   └── Enrollment.java
            │
            ├── repository/
            │   ├── StudentRepository.java
            │   ├── CourseRepository.java
            │   └── EnrollmentRepository.java
            │
            ├── service/
            │   ├── StudentService.java
            │   ├── CourseService.java
            │   └── EnrollmentService.java
            │
            ├── exception/
            │   ├── EntityNotFoundException.java
            │   └── InvalidInputException.java
            │
            ├── util/
            │   ├── IdGenerator.java
            │   └── InputValidator.java
            │
            ├── constants/
            │   ├── MenuOptions.java
            │   └── AppConstants.java
            │
            └── enums/
                ├── EnrollmentStatus.java
                └── CourseStatus.java
```

---

## 🎯 Goal

Build a **menu-driven Java application** demonstrating:

- OOP concepts
- Clean architecture
- Proper package structure
- Real-world coding practices
