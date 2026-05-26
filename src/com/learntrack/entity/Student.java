package com.learntrack.entity;

import com.learntrack.util.IdGenerator;

/**
 * Student class is used for creating a Student with it's identity information
 * which extends Person and have some extra information like status and batch.
 * Student holds information about:
 * 1. batch - to store batch of the Student
 * 2. active - to store status of Student (true or false)
 */
public class Student extends Person {
  int id;
  String batch;
  boolean active;

  /**
   * Default constructor — creates an empty Student.
   * Demonstrates default constructor requirement.
   */
  public Student() {
    super();
    this.id = IdGenerator.getNextStudentId();
    this.batch = "";
    this.active = true;
  }

  /**
   * Overloaded constructor — creates a Student with name only (no email/batch).
   * Demonstrates constructor overloading.
   */
  public Student(String firstName, String lastName) {
    super(firstName, lastName);
    this.id = IdGenerator.getNextStudentId();
    this.batch = "";
    this.active = true;
  }

  /**
   * Parameterized constructor — creates a Student with all fields.
   */
  public Student(String firstName, String lastName, String email, String batch) {
    super(firstName, lastName, email);
    this.id = IdGenerator.getNextStudentId();
    this.batch = batch;
    this.active = true;
  }

  public int getId() {
    return id;
  }

  public String getBatch() {
    return batch;
  }

  public boolean getStatus() {
    return active;
  }

  public void setStatus(boolean status) {
    this.active = status;
  }

  /**
   * Overrides Person.getDisplayName() to include batch info.
   * Demonstrates method overriding / polymorphism.
   */
  @Override
  public String getDisplayName() {
    return getFirstName() + " " + getLastName() + " (" + batch + ")";
  }

  @Override
  public String toString() {
    return "Student{id=" + id
        + ", firstName='" + getFirstName() + '\''
        + ", lastName='" + getLastName() + '\''
        + ", email='" + getEmail() + '\''
        + ", batch='" + batch + '\''
        + ", active=" + active
        + '}';
  }
}
