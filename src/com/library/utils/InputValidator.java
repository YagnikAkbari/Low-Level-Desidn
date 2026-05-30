package com.library.utils;

public class InputValidator {
  public static boolean validateEmail(String email) {
    if (email == null) {
      return false;
    }
    String trimmed = email.trim();
    if (trimmed.isEmpty()) {
      return false;
    }
    return trimmed.matches("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$");
  }

  public static boolean validateString(String str, int min, int max) {
    if (str == null) {
      return false;
    }

    String trimmed = str.trim();
    int len = trimmed.length();
    if (len < min) {
      return false;
    }

    if (len > max) {
      return false;
    }

    return true;
  }

  public static boolean validateMobile(String mobile) {
    if (mobile == null) {
      return false;
    }
    return mobile.trim().matches("^\\d{10}$");
  }

  public static boolean validatePositiveNumber(int value) {
    return value > 0;
  }
}
