package com.learntrack.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * import statement is used when you want to access class from different package (for same package java resolve it automatically).
 */

import com.learntrack.enums.EnrollmentStatus;
import com.learntrack.util.IdGenerator;

/**
 * Enrollment class is used for create Enrollment of Students into one or more
 * Courses
 * Enrollment holds information about:
 * 1. id - unique id for each entrollment
 * 2. studenId - to store Student's id who is entrolled in
 * 3. courseId - to store coruse's id Student entrolled in
 * 4. enrollmentDate - hold student enrolled in the course on which date
 * 5. status - holds status of the student enrollment in course (eg. ACTIVE,
 * COMPLETED, CANCELLED)
 */
public class Enrollment {
  final static private DateTimeFormatter enrollmentDateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm a");
  private int id;
  private int studentId;
  private int courseId;
  private String enrollmentDate;
  private EnrollmentStatus status;

  /**
   * Default constructor — creates an empty Enrollment.
   * Demonstrates default constructor requirement.
   */
  public Enrollment() {
    this.id = IdGenerator.getNextEnrollmentId();
    this.studentId = 0;
    this.courseId = 0;
    this.enrollmentDate = LocalDateTime.now().format(enrollmentDateFormat);
    this.status = EnrollmentStatus.ACTIVE;
  }

  /**
   * Parameterized constructor — creates an Enrollment with student and course
   * IDs.
   */
  public Enrollment(int studentId, int courseId) {
    this.id = IdGenerator.getNextEnrollmentId();
    this.studentId = studentId;
    this.courseId = courseId;
    this.enrollmentDate = LocalDateTime.now().format(enrollmentDateFormat);
    this.status = EnrollmentStatus.ACTIVE;
  }

  /**
   * Overloaded constructor — creates an Enrollment with a specific status.
   * Demonstrates constructor overloading.
   */
  public Enrollment(int studentId, int courseId, EnrollmentStatus status) {
    this.id = IdGenerator.getNextEnrollmentId();
    this.studentId = studentId;
    this.courseId = courseId;
    this.enrollmentDate = LocalDateTime.now().format(enrollmentDateFormat);
    this.status = status;
  }

  public int getId() {
    return id;
  }

  public int getStudentId() {
    return studentId;
  }

  public int getCourseId() {
    return courseId;
  }

  public String getEnrollmentDate() {
    return enrollmentDate;
  }

  public EnrollmentStatus getStatus() {
    return status;
  }

  public void setStatus(EnrollmentStatus status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "Enrollment{id=" + id
        + ", studentId='" + studentId + '\''
        + ", courseId='" + courseId + '\''
        + ", enrollmentDate='" + enrollmentDate + '\''
        + ", status=" + status
        + '}';
  }
}
