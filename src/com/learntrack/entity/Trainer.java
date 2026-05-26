package com.learntrack.entity;

/**
 * Trainer class extends Person to represent a course trainer.
 * Demonstrates inheritance and method overriding (polymorphism).
 */
public class Trainer extends Person {
  double weeklyCost;
  boolean status;

  /**
   * Default constructor — creates an empty Trainer.
   * Demonstrates default constructor requirement.
   */
  public Trainer() {
    super();
    this.weeklyCost = 0.0;
    this.status = true;
  }

  /**
   * Parameterized constructor — creates a Trainer with all fields.
   */
  public Trainer(String firstName, String lastName, String email, double weeklyCost) {
    super(firstName, lastName, email);
    this.weeklyCost = weeklyCost;
    this.status = true;
  }

  public double getWeeklyCost() {
    return weeklyCost;
  }

  public boolean getStatus() {
    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }

  /**
   * Overrides Person.getDisplayName() to include "Trainer:" prefix.
   * Demonstrates method overriding / polymorphism.
   */
  @Override
  public String getDisplayName() {
    return "Trainer: " + getFirstName() + " " + getLastName();
  }

  @Override
  public String toString() {
    return "Trainer{firstName='" + getFirstName() + '\''
        + ", lastName='" + getLastName() + '\''
        + ", email='" + getEmail() + '\''
        + ", weeklyCost=" + weeklyCost
        + ", status=" + status
        + '}';
  }
}
