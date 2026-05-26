package com.learntrack.constants;

/**
 * AppConstants stores application-level constant values
 * used across the project for validation and configuration.
 */
public class AppConstants {
  // Validation limits
  public static final int MIN_NAME_LENGTH = 1;
  public static final int MAX_NAME_LENGTH = 255;
  public static final int MAX_DESCRIPTION_LENGTH = 1000;

  // Application messages
  public static final String APP_NAME = "LearnTrack";
  public static final String EXIT_MESSAGE = "Thank you for visiting The Terminal of mine.";
  public static final String INVALID_OPTION_MESSAGE = "Invalid option. Please try again.";
  public static final String INPUT_ERROR_MESSAGE = "Invalid input! Please enter a valid number.";

  // Minimum allowed values
  public static final int MIN_DURATION_WEEKS = 1;
}
