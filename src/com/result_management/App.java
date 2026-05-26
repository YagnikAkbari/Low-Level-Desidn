package com.result_management;

public class App {
  public static void run() {
    System.out.println("Result Management System");
    ScoreValidator scoreValidator = new ScoreValidator(0, 100);
    StudentReportCard.setScoreValidator(scoreValidator);
    StudentReportCard student = new StudentReportCard("Yagnik", 1);
    student.setMathScore(75);
    student.setScienceScore(42);
    student.setEnglishScore(27);
    student.printScoreCard();
    StudentReportCard student2 = new StudentReportCard("Rahul", 101);
    student2.setMathScore(85);
    student2.setScienceScore(72);
    student2.setEnglishScore(90);
    student2.printScoreCard();
    StudentReportCard student3 = new StudentReportCard("Priya", 102);
    student3.setMathScore(80);
    student3.setScienceScore(12);
    student3.setEnglishScore(10);
    student3.printScoreCard();
  }

  public static void main(String[] args) {
    run();
  }
}
