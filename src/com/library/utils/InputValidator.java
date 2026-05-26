package com.library.utils;

public class InputValidator {
  public static boolean validateEmail(String email) {
    if (email == null || email.isEmpty()) {
      return false;
    }
    return email.contains("@");
  }

  public static boolean validateString(String str, int min, int max) {
    if (str == null)
      return false;

    int len = str.length();
    if (len < min)
      return false;

    if (len > max)
      return false;

    return true;
  }
}
