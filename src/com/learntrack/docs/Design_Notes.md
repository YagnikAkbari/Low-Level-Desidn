# Design Notes — LearnTrack

## 1. Why ArrayList?

We use `ArrayList` as the in-memory data store for Students, Courses, and Enrollments because:

- **Dynamic sizing** — Unlike arrays, `ArrayList` grows and shrinks automatically as we add/remove items.
- **Index-based access** — We can retrieve, update, and remove elements efficiently by index.
- **Simple iteration** — Enhanced `for` loops and `for` index loops both work well with `ArrayList`.
- **No database needed** — Since this is a console-based project, `ArrayList` simulates persistence during runtime without needing any external dependencies.

Each repository (`StudentRepository`, `CourseRepository`, `EnrollmentRepository`) wraps its own `ArrayList` to keep data access centralized and clean.

---

## 2. Where `static` is Used

| Location | Usage |
|----------|-------|
| `IdGenerator` | Static counters (`studentIdCounter`, `courseIdCounter`, `enrollmentIdCounter`) and static methods (`getNextStudentId()`, etc.) ensure **globally unique IDs** without creating an instance. |
| `MenuOptions` | Static final strings for menu display — these are constants, not instance-specific data. |
| `AppConstants` | Static final values for validation limits and common messages. |
| `InputValidator` | Static utility methods (`validateString()`, `validateEmail()`) — pure functions with no state. |
| `Main` class helper methods | `addStudent()`, `addCourse()`, `addEnrollment()`, etc. are static because `main` is static and they are called directly without an instance. |

---

## 3. Where Inheritance is Used

| Parent Class | Child Class | Relationship |
|-------------|-------------|-------------|
| `Person` | `Student` | Student **extends** Person, inheriting `firstName`, `lastName`, and `email` fields and their getters. Uses `super()` to call the parent constructor. |
| `Person` | `Trainer` | Trainer **extends** Person, same inheritance chain. Adds trainer-specific fields (`weeklyCost`, `status`). |

### Polymorphism (Method Overriding)

- `Person` defines `getDisplayName()` which returns `"firstName lastName"`.
- `Student` **overrides** it to return `"firstName lastName (batch)"` — adding batch context.
- `Trainer` **overrides** it to return `"Trainer: firstName lastName"` — adding role prefix.

This means if you have a `Person` reference pointing to a `Student` or `Trainer`, calling `getDisplayName()` will use the child's version (runtime polymorphism).

---

## 4. Constructor Overloading

Each entity demonstrates **constructor overloading** with multiple constructors:

- **Default constructor** (no arguments) — initializes with empty/default values.
- **Partially parameterized constructor** — takes a subset of fields.
- **Fully parameterized constructor** — takes all fields.

Example in `Student`:
```java
Student()                                         // default
Student(String firstName, String lastName)         // name only
Student(String firstName, String lastName, String email, String batch)  // all fields
```

---

## 5. Method Overloading

`StudentRepository` demonstrates **method overloading** with two versions of `getStudentById`:

```java
public Student getStudentById(int studentId)       // accepts int
public Student getStudentById(String studentId)    // accepts String, parses to int
```

Same method name, different parameter types — the compiler resolves which to call at compile time.

---

## 6. Exception Handling Strategy

| Exception | When Thrown |
|-----------|-----------|
| `InvalidInputException` | When validation fails (empty name, invalid email, zero duration, etc.) |
| `EntityNotFoundException` | When trying to find/update/deactivate a non-existent entity |
| `InputMismatchException` | When user types text instead of a number in the menu — caught in `Main.java` to show a friendly message |

---

## 7. Architecture Pattern

The project follows a **layered architecture**:

```
Main.java (UI Layer — input/output only)
    ↓
Service Layer (business logic + validation)
    ↓
Repository Layer (data access — ArrayList storage)
    ↓
Entity Layer (data models)
```

This separation ensures:
- **Main stays thin** — only handles Scanner I/O and calls service methods.
- **Services own the logic** — validation, status changes, lookups.
- **Repositories own the data** — add, update, remove, find operations.
