package com.learntrack.service;

import java.util.ArrayList;

import com.learntrack.entity.Student;
import com.learntrack.exception.EntityNotFoundException;
import com.learntrack.exception.InvalidInputException;
import com.learntrack.repository.StudentRepository;
import com.learntrack.validators.StudentValidator;

public class StudentService {

  private final StudentRepository studentRepository;
  private final StudentValidator studentValidator;

  public StudentService(StudentRepository studentRepository, StudentValidator studentValidator) {
    this.studentRepository = studentRepository;
    this.studentValidator = studentValidator;
  }

  public Student addStudent(Student student) throws InvalidInputException {
    studentValidator.validateStudent(student);
    studentRepository.addStudent(student);
    return student;
  }

  public Student updateStudent(Student student) throws InvalidInputException {
    studentValidator.validateStudent(student);
    studentRepository.updateStudent(student);
    return student;
  }

  public Student getStudent(int studentId) throws EntityNotFoundException {
    return getStudentOrThrow(studentId);
  }

  public void removeStudent(int studentId) throws EntityNotFoundException {
    getStudentOrThrow(studentId);
    studentRepository.removeStudent(studentId);
  }

  public void changeStatus(int studentId, boolean status) throws EntityNotFoundException, InvalidInputException {
    Student s = getStudentOrThrow(studentId);
    s.setStatus(status);
    updateStudent(s);
  }

  public ArrayList<Student> listStudents() {
    return studentRepository.getAllStudents();
  }

  private Student getStudentOrThrow(int studentId) throws EntityNotFoundException {
    Student s = studentRepository.getStudentById(studentId);
    if (s == null) {
      throw new EntityNotFoundException("Student Not Found!");
    }
    return s;
  }
}