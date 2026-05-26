package com.learntrack.repository;

import java.util.ArrayList;

import com.learntrack.entity.Enrollment;

public class EnrollmentRepository {
  private final ArrayList<Enrollment> enrollments = new ArrayList<>();

  public void addEnrollment(Enrollment details) {
    enrollments.add(details);
  }

  public void updateEnrollment(Enrollment details) {
    int index = getEnrollmentIndexById(details.getId());
    if (index >= 0) {
      enrollments.set(index, details);
    }
  }

  private int getEnrollmentIndexById(int enrollmentId) {
    for (int i = 0; i < enrollments.size(); i++) {
      if (enrollments.get(i).getId() == enrollmentId) {
        return i;
      }
    }
    return -1;
  }

  public Enrollment getEnrollmentById(int enrollmentId) {
    for (Enrollment enrollment : enrollments) {
      if (enrollment.getId() == enrollmentId) {
        return enrollment;
      }
    }
    return null;
  }

  public ArrayList<Enrollment> getAllEnrollments() {
    return enrollments;
  }

  public void removeEnrollment(int enrollmentId) {
    int index = getEnrollmentIndexById(enrollmentId);
    if (index >= 0) {
      enrollments.remove(index);
    }
  }
}