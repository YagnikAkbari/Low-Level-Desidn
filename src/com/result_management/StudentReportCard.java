package com.result_management;

public class StudentReportCard {
  private String name;
  private int rollNumber;
  private double mathScore;
  private double scienceScore;
  private double englishScore;
  private static ScoreValidator scoreValidator;

  public StudentReportCard(String name, int rollNumber) {
    this.name = name;
    this.rollNumber = rollNumber;
  }

  public String getName() {
    return name;
  }

  public int getRollNumber() {
    return this.rollNumber;
  }

  public double getMathScore() {
    return this.mathScore;
  }

  public double getScienceScore() {
    return this.scienceScore;
  }

  public double getEnglishScore() {
    return this.englishScore;
  }

  public void setMathScore(double score) {
    if (!scoreValidator.validateScore(score)) {
      System.out.println("Provide valid score.");
      return;
    }
    this.mathScore = score;
  }

  public void setScienceScore(double score) {
    if (!scoreValidator.validateScore(score)) {
      System.out.println("Provide valid score.");
      return;
    }
    this.scienceScore = score;
  }

  public void setEnglishScore(double score) {
    if (!scoreValidator.validateScore(score)) {
      System.out.println("Provide valid score.");
      return;
    }
    this.englishScore = score;
  }

  public double getPercentage() {
    return (this.englishScore + this.mathScore + this.scienceScore) / 3;
  }

  public char getGrade() {
    double percentage = getPercentage();
    if (percentage >= 80) {
      return 'A';
    } else if (percentage >= 60) {
      return 'B';
    } else if (percentage >= 40) {
      return 'C';
    } else if (percentage < 40) {
      return 'F';
    } else {
      return 'F';
    }
  }

  public void printScoreCard() {
    System.out.println("=== Report Card ===");
    System.out.println("Name: " + this.name);
    System.out.println("Roll Number: " + this.rollNumber);
    System.out.println("Math: " + this.mathScore);
    System.out.println("Science: " + this.scienceScore);
    System.out.println("English: " + this.englishScore);
    System.out.printf("Percentage: %.2f%%", getPercentage());
    System.out.println();
    System.out.println("Grade: " + getGrade());
    System.out.println("===================");
  }

  public static void setScoreValidator(ScoreValidator validator) {
    scoreValidator = validator;
  }
}
