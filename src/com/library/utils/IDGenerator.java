package com.library.utils;

public class IDGenerator {
  private static int bookId = 0;
  private static int genreId = 0;

  public static int nextBookId() {
    bookId = bookId + 1;
    return bookId;
  }

  public static int nextGenreId() {
    genreId = genreId + 1;
    return genreId;
  }
}
