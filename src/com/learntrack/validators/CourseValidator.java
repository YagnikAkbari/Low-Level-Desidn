package com.learntrack.validators;

import com.learntrack.entity.Course;
import com.learntrack.exception.InvalidInputException;
import com.learntrack.util.InputValidator;

public class CourseValidator {
  public void validateCourse(Course course) throws InvalidInputException {
    if (course.getCourseName() == null || course.getCourseName().isEmpty()) {
      throw new InvalidInputException("Course Name is required");
    }
    if (!InputValidator.validateString(course.getCourseName(), 1, 255)) {
      throw new InvalidInputException("Please Enter Valid Course Name (min character 1 - max character 255)");
    }
    if (course.getDescription() == null || course.getDescription().isEmpty()) {
      throw new InvalidInputException("Description is required");
    }
    if (!InputValidator.validateString(course.getDescription(), 1, 1000)) {
      throw new InvalidInputException("Please Enter Valid Description (min character 1 - max character 1000)");
    }
    if (course.getDurationInWeeks() <= 0) {
      throw new InvalidInputException("Duration in weeks must be greater than 0");
    }
  }
}
