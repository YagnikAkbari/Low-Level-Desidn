package com.result_management;

public class ScoreValidator {
  private double minValue;
  private double maxValue;

  public ScoreValidator(double min, double max) {
    this.minValue = min;
    this.maxValue = max;
  }

  public boolean validateScore(double score) {
    return (this.minValue <= score && this.maxValue >= score);
  }
}
