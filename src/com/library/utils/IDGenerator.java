package com.library.utils;

public class IDGenerator {
  private static int bookId = 0;
  private static int genreId = 0;
  private static int authorId = 0;
  private static int categoryId = 0;
  private static int libraryId = 0;
  private static int branchId = 0;
  private static int patronId = 0;
  private static int libraryBookId = 0;
  private static int reservationId = 0;

  public static int nextBookId() {
    bookId = bookId + 1;
    return bookId;
  }

  public static int nextAuthorId() {
    authorId = authorId + 1;
    return authorId;
  }

  public static int nextGenreId() {
    genreId = genreId + 1;
    return genreId;
  }

  public static int nextCategoryId() {
    categoryId = categoryId + 1;
    return categoryId;
  }

  public static int nextLibraryId() {
    libraryId = libraryId + 1;
    return libraryId;
  }

  public static int nextBranchId() {
    branchId = branchId + 1;
    return branchId;
  }

  public static int nextPatronId() {
    patronId = patronId + 1;
    return patronId;
  }

  public static int nextLibraryBookId() {
    libraryBookId = libraryBookId + 1;
    return libraryBookId;
  }

  public static int nextReservationId() {
    reservationId = reservationId + 1;
    return reservationId;
  }
}
