package com.learntrack.entity;

/**
 * Person class is used for creating a Person with it's identity information
 * Person holds information about:
 * 1. id - unique id for each entrollment
 * 2. firstName - to store Person's firstName
 * 3. lastName - to store Person's lastName
 * 4. email - to store Person's email
 */
public class Person {
  private String firstName;
  private String lastName;
  private String email;

  /**
   * Default constructor — required to demonstrate default constructor concept.
   */
  public Person() {
    this.firstName = "";
    this.lastName = "";
    this.email = "";
  }

  /**
   * Overloaded constructor — creates a Person with name only (no email).
   * Demonstrates constructor overloading.
   */
  public Person(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = "";
  }

  /**
   * Parameterized constructor — creates a Person with all fields.
   */
  Person(String firstName, String lastName, String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getEmail() {
    return email;
  }

  /**
   * Returns the display name of the person.
   * Subclasses can override this for custom display (polymorphism demo).
   */
  public String getDisplayName() {
    return firstName + " " + lastName;
  }
}
