package com.learntrack.repository;

import java.util.ArrayList;

import com.learntrack.entity.Student;

public class StudentRepository {
  private final ArrayList<Student> students = new ArrayList<>();

  public void addStudent(Student details) {
    students.add(details);
  }

  public void updateStudent(Student details) {
    int index = getStudentIndexById(details.getId());
    if (index >= 0) {
      students.set(index, details);
    }
  }

  private int getStudentIndexById(int studentId) {
    for (int i = 0; i < students.size(); i++) {
      if (students.get(i).getId() == studentId) {
        return i;
      }
    }
    return -1;
  }

  public Student getStudentById(int studentId) {
    for (Student student : students) {
      if (student.getId() == studentId) {
        return student;
      }
    }
    return null;
  }

  /**
   * Overloaded method — accepts a String ID and parses it to int.
   * Demonstrates method overloading concept.
   */
  public Student getStudentById(String studentId) {
    int parsedId = Integer.parseInt(studentId);
    return getStudentById(parsedId);
  }

  public ArrayList<Student> getAllStudents() {
    return students;
  }

  public void removeStudent(int studentId) {
    int index = getStudentIndexById(studentId);
    if (index >= 0) {
      students.remove(index);
    }
  }
}