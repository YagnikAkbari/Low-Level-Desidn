package com.learntrack;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.learntrack.constants.AppConstants;
import com.learntrack.constants.MenuOptions;
import com.learntrack.entity.Course;
import com.learntrack.entity.Enrollment;
import com.learntrack.entity.Student;
import com.learntrack.enums.EnrollmentStatus;
import com.learntrack.exception.EntityNotFoundException;
import com.learntrack.repository.CourseRepository;
import com.learntrack.repository.EnrollmentRepository;
import com.learntrack.repository.StudentRepository;
import com.learntrack.service.CourseService;
import com.learntrack.service.EnrollmentService;
import com.learntrack.service.StudentService;
import com.learntrack.validators.CourseValidator;
import com.learntrack.validators.EnrollmentValidator;
import com.learntrack.validators.StudentValidator;

public class App {

  public static Student addStudent(Scanner sc) {
    String firstName, lastName, email, batch;
    System.out.println("Enter you first name:= ");
    firstName = sc.nextLine();
    System.out.println("Enter you last name:= ");
    lastName = sc.nextLine();
    System.out.println("Enter you email:= ");
    email = sc.nextLine();
    System.out.println("Enter you batch:= ");
    batch = sc.nextLine();
    return new Student(firstName, lastName, email, batch);
  }

  public static void viewAllStudent(ArrayList<Student> students) {
    if (students.size() == 0) {
      System.out.println("Hey, thank you in advance to be future of our first student.");
      return;
    }
    System.out.println("==========List of Student=============");
    for (Student student : students) {
      System.out.println(student);
    }
  }

  public static void searchStudentById(Scanner sc, StudentService studentService) {
    System.out.println("Enter Student ID:= ");
    int studentId = sc.nextInt();
    sc.nextLine();
    try {
      Student student = studentService.getStudent(studentId);
      System.out.println("==========Student Found=============");
      System.out.println(student);
    } catch (EntityNotFoundException error) {
      System.out.println("Error: " + error.getMessage());
    }
  }

  public static void deactivateStudent(Scanner sc, StudentService studentService) {
    System.out.println("Enter Student ID to deactivate:= ");
    int studentId = sc.nextInt();
    sc.nextLine();
    try {
      studentService.changeStatus(studentId, false);
      System.out.println("Student deactivated successfully.");
    } catch (EntityNotFoundException error) {
      System.out.println("Error: " + error.getMessage());
    } catch (Exception error) {
      System.out.println("Error deactivating student: " + error.getMessage());
    }
  }

  public static Course addCourse(Scanner sc) {
    String courseName, description;
    int durationInWeeks;
    System.out.println("Enter course name:= ");
    courseName = sc.nextLine();
    System.out.println("Enter course description:= ");
    description = sc.nextLine();
    System.out.println("Enter duration in weeks:= ");
    durationInWeeks = sc.nextInt();
    sc.nextLine();
    return new Course(courseName, description, durationInWeeks);
  }

  public static void viewAllCourses(ArrayList<Course> courses) {
    if (courses.size() == 0) {
      System.out.println("No courses available yet. Be the first to add one!");
      return;
    }
    System.out.println("==========List of Courses=============");
    for (Course course : courses) {
      System.out.println(course);
    }
  }

  public static void toggleCourseStatus(Scanner sc, CourseService courseService) {
    System.out.println("Enter Course ID:= ");
    int courseId = sc.nextInt();
    sc.nextLine();
    System.out.println("1. Activate");
    System.out.println("2. Deactivate");
    System.out.println("Choose action:= ");
    int choice = sc.nextInt();
    sc.nextLine();
    try {
      if (choice == 1) {
        courseService.activateCourse(courseId);
        System.out.println("Course activated successfully.");
      } else if (choice == 2) {
        courseService.deactivateCourse(courseId);
        System.out.println("Course deactivated successfully.");
      } else {
        System.out.println(AppConstants.INVALID_OPTION_MESSAGE);
      }
    } catch (EntityNotFoundException error) {
      System.out.println("Error: " + error.getMessage());
    }
  }

  public static Enrollment addEnrollment(Scanner sc) {
    System.out.println("Enter Student ID:= ");
    int studentId = sc.nextInt();
    sc.nextLine();
    System.out.println("Enter Course ID:= ");
    int courseId = sc.nextInt();
    sc.nextLine();
    return new Enrollment(studentId, courseId);
  }

  public static void viewAllEnrollments(ArrayList<Enrollment> enrollments) {
    if (enrollments.size() == 0) {
      System.out.println("No enrollments found. Enroll a student to get started!");
      return;
    }
    System.out.println("==========List of Enrollments=============");
    for (Enrollment enrollment : enrollments) {
      System.out.println(enrollment);
    }
  }

  public static void updateEnrollmentStatus(Scanner sc, EnrollmentService enrollmentService) {
    System.out.println("Enter Enrollment ID:= ");
    int enrollmentId = sc.nextInt();
    sc.nextLine();
    System.out.println("1. Mark as Completed");
    System.out.println("2. Mark as Cancelled");
    System.out.println("Choose action:= ");
    int choice = sc.nextInt();
    sc.nextLine();
    try {
      if (choice == 1) {
        enrollmentService.updateStatus(enrollmentId, EnrollmentStatus.COMPLETED);
        System.out.println("Enrollment marked as COMPLETED.");
      } else if (choice == 2) {
        enrollmentService.updateStatus(enrollmentId, EnrollmentStatus.CANCELLED);
        System.out.println("Enrollment marked as CANCELLED.");
      } else {
        System.out.println(AppConstants.INVALID_OPTION_MESSAGE);
      }
    } catch (EntityNotFoundException error) {
      System.out.println("Error: " + error.getMessage());
    }
  }

  public static void run() {
    StudentRepository studentRepository = new StudentRepository();
    StudentValidator studentValidator = new StudentValidator();
    StudentService studentService = new StudentService(studentRepository,
        studentValidator);

    CourseRepository courseRepository = new CourseRepository();
    CourseValidator courseValidator = new CourseValidator();
    CourseService courseService = new CourseService(courseRepository,
        courseValidator);

    EnrollmentRepository enrollmentRepository = new EnrollmentRepository();
    EnrollmentValidator enrollmentValidator = new EnrollmentValidator();
    EnrollmentService enrollmentService = new EnrollmentService(enrollmentRepository, enrollmentValidator);
    Scanner sc = new Scanner(System.in);
    int module, action;
    while (true) {
      try {
        System.out.println(MenuOptions.menu);
        module = sc.nextInt();
        if (module == 4) {
          System.out.println(AppConstants.EXIT_MESSAGE);
          break;
        }

        switch (module) {
          case 1:
            while (true) {
              try {
                System.out.println(MenuOptions.studentOptions);
                action = sc.nextInt();
                sc.nextLine();
                switch (action) {
                  case 1:
                    try {
                      studentService.addStudent(addStudent(sc));
                      System.out.println("Student Added Successfully.");
                    } catch (Exception error) {
                      System.out.println("Error Adding Student: " + error.getMessage());
                    }
                    break;
                  case 2:
                    viewAllStudent(studentService.listStudents());
                    break;
                  case 3:
                    searchStudentById(sc, studentService);
                    break;
                  case 4:
                    deactivateStudent(sc, studentService);
                    break;
                  case 5:
                    break;
                  default:
                    System.out.println(AppConstants.INVALID_OPTION_MESSAGE);
                    break;
                }
                if (action == 5)
                  break;
              } catch (InputMismatchException e) {
                System.out.println(AppConstants.INPUT_ERROR_MESSAGE);
                sc.nextLine();
              }
            }
            break;
          case 2:
            while (true) {
              try {
                System.out.println(MenuOptions.courseOptions);
                action = sc.nextInt();
                sc.nextLine();
                switch (action) {
                  case 1:
                    try {
                      courseService.addCourse(addCourse(sc));
                      System.out.println("Course Added Successfully.");
                    } catch (Exception error) {
                      System.out.println("Error Adding Course: " + error.getMessage());
                    }
                    break;
                  case 2:
                    viewAllCourses(courseService.listCourses());
                    break;
                  case 3:
                    toggleCourseStatus(sc, courseService);
                    break;
                  case 4:
                    break;
                  default:
                    System.out.println(AppConstants.INVALID_OPTION_MESSAGE);
                    break;
                }
                if (action == 4)
                  break;
              } catch (InputMismatchException e) {
                System.out.println(AppConstants.INPUT_ERROR_MESSAGE);
                sc.nextLine();
              }
            }
            break;
          case 3:
            while (true) {
              try {
                System.out.println(MenuOptions.enrollmentOptions);
                action = sc.nextInt();
                sc.nextLine();
                switch (action) {
                  case 1:
                    try {
                      enrollmentService.enrollStudent(addEnrollment(sc));
                      System.out.println("Student Enrolled Successfully.");
                    } catch (Exception error) {
                      System.out.println("Error Enrolling Student: " + error.getMessage());
                    }
                    break;
                  case 2:
                    viewAllEnrollments(enrollmentService.listEnrollments());
                    break;
                  case 3:
                    updateEnrollmentStatus(sc, enrollmentService);
                    break;
                  case 4:
                    break;
                  default:
                    System.out.println(AppConstants.INVALID_OPTION_MESSAGE);
                    break;
                }
                if (action == 4)
                  break;
              } catch (InputMismatchException e) {
                System.out.println(AppConstants.INPUT_ERROR_MESSAGE);
                sc.nextLine();
              }
            }
            break;
          default:
            System.out.println(AppConstants.INVALID_OPTION_MESSAGE);
            break;
        }
      } catch (InputMismatchException e) {
        System.out.println(AppConstants.INPUT_ERROR_MESSAGE);
        sc.nextLine();
      }
    }
    sc.close();
  }

  public static void main(String[] args) {
    run();
  }
}