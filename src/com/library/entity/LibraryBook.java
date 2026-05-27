package com.library.entity;

public class LibraryBook {
  private int id;
  private int libraryId;
  private int bookId;
  private int totalCopies;
  private int availableCopies;
  private int borrowedCopies;
  private int reservedCopies;

  public LibraryBook(int libraryId, int bookId, int totalCopies) {
    this.libraryId = libraryId;
    this.bookId = bookId;
    this.totalCopies = totalCopies;
  }

  public void addCopies(int copy) {
    this.totalCopies += copy;
  }

  public void returnCopies(int copy) {
    this.totalCopies -= copy;
  }

  public void borrowCopy(int copy) {
    this.borrowedCopies += copy;
  }

  public void reserveCopy(int copy) {
    this.reservedCopies += copy;
  }
}
