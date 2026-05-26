package com.learntrack.repository;

import java.util.ArrayList;

import com.learntrack.entity.Course;

public class CourseRepository {
  private final ArrayList<Course> courses = new ArrayList<>();

  public void addCourse(Course courseDetails) {
    courses.add(courseDetails);
  }

  public void updateCourse(Course courseDetails) {
    int index = getCourseIndexById(courseDetails.getId());
    if (index >= 0) {
      courses.set(index, courseDetails);
    }
  }

  private int getCourseIndexById(int courseId) {
    for (int i = 0; i < courses.size(); i++) {
      if (courses.get(i).getId() == courseId) {
        return i;
      }
    }
    return -1;
  }

  public Course getCourseById(int courseId) {
    for (Course course : courses) {
      if (course.getId() == courseId) {
        return course;
      }
    }
    return null;
  }

  public ArrayList<Course> getAllCourse() {
    return courses;
  }

  public void removeCourse(int courseId) {
    int index = getCourseIndexById(courseId);
    if (index >= 0) {
      courses.remove(index);
    }
  }
}