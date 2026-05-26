package com.learntrack.service;

import java.util.ArrayList;

import com.learntrack.entity.Course;
import com.learntrack.enums.CourseStatus;
import com.learntrack.exception.EntityNotFoundException;
import com.learntrack.exception.InvalidInputException;
import com.learntrack.repository.CourseRepository;
import com.learntrack.validators.CourseValidator;

public class CourseService {
  private final CourseRepository courseRepository;
  private final CourseValidator courseValidator;

  public CourseService(CourseRepository courseRepository, CourseValidator courseValidator) {
    this.courseRepository = courseRepository;
    this.courseValidator = courseValidator;
  }

  public Course addCourse(Course course) throws InvalidInputException {
    courseValidator.validateCourse(course);
    courseRepository.addCourse(course);
    return course;
  }

  public Course getCourse(int courseId) throws EntityNotFoundException {
    return getCourseOrThrow(courseId);
  }

  public ArrayList<Course> listCourses() {
    return courseRepository.getAllCourse();
  }

  public void activateCourse(int courseId) throws EntityNotFoundException {
    Course c = getCourseOrThrow(courseId);
    c.setStatus(CourseStatus.ACTIVE);
    courseRepository.updateCourse(c);
  }

  public void deactivateCourse(int courseId) throws EntityNotFoundException {
    Course c = getCourseOrThrow(courseId);
    c.setStatus(CourseStatus.INACTIVE);
    courseRepository.updateCourse(c);
  }

  public void removeCourse(int courseId) throws EntityNotFoundException {
    getCourseOrThrow(courseId);
    courseRepository.removeCourse(courseId);
  }

  private Course getCourseOrThrow(int courseId) throws EntityNotFoundException {
    Course c = courseRepository.getCourseById(courseId);
    if (c == null) {
      throw new EntityNotFoundException("Course Not Found!");
    }
    return c;
  }
}