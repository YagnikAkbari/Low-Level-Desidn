package com.learntrack.entity;

import com.learntrack.enums.CourseStatus;
import com.learntrack.util.IdGenerator;

/**
 * Course class is used for create Course in which Student can enroll
 * Course holds information about:
 * 1. id - unique id for each Course
 * 2. courseName - to store Course's name
 * 3. description - to store Coruse's description
 * 4. durationInWeeks - hold Course's total learning week
 * 5. active - holds status of the course (eg. ACTIVE, INACTIVE)
 */
public class Course {
  private int id;
  private String courseName;
  private String description;
  private int durationInWeeks;
  private CourseStatus active;

  /**
   * Default constructor — creates an empty Course.
   * Demonstrates default constructor requirement.
   */
  public Course() {
    this.id = IdGenerator.getNextCourseId();
    this.courseName = "";
    this.description = "";
    this.durationInWeeks = 0;
    this.active = CourseStatus.ACTIVE;
  }

  /**
   * Overloaded constructor — creates a Course with name only.
   * Demonstrates constructor overloading.
   */
  public Course(String courseName) {
    this.id = IdGenerator.getNextCourseId();
    this.courseName = courseName;
    this.description = "";
    this.durationInWeeks = 0;
    this.active = CourseStatus.ACTIVE;
  }

  /**
   * Parameterized constructor — creates a Course with all fields.
   */
  public Course(String courseName, String description, int durationInWeeks) {
    this.id = IdGenerator.getNextCourseId();
    this.courseName = courseName;
    this.description = description;
    this.durationInWeeks = durationInWeeks;
    this.active = CourseStatus.ACTIVE;
  }

  public int getId() {
    return id;
  }

  public String getCourseName() {
    return courseName;
  }

  public String getDescription() {
    return description;
  }

  public int getDurationInWeeks() {
    return durationInWeeks;
  }

  public CourseStatus getStatus() {
    return active;
  }

  public void setStatus(CourseStatus status) {
    this.active = status;
  }

  @Override
  public String toString() {
    return "Course{id=" + id
        + ", courseName='" + courseName + '\''
        + ", description='" + description + '\''
        + ", durationInWeeks=" + durationInWeeks
        + ", active=" + active
        + '}';
  }
}
