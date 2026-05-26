package com.learntrack.validators;

import com.learntrack.entity.Enrollment;
import com.learntrack.exception.InvalidInputException;

public class EnrollmentValidator {
  public void validateEnrollment(Enrollment enrollment) throws InvalidInputException {
    if (enrollment.getStudentId() <= 0) {
      throw new InvalidInputException("Valid Student ID is required");
    }
    if (enrollment.getCourseId() <= 0) {
      throw new InvalidInputException("Valid Course ID is required");
    }
  }
}
