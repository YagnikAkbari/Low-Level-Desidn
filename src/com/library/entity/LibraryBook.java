package com.library.entity;

public class LibraryBook {
  private int id;
  private int branchId;
  private int bookId;
  private int totalCopies;
  private int borrowedCopies;
  private int reservedCopies;

  public LibraryBook(int branchId, int bookId, int totalCopies) {
    this.branchId = branchId;
    this.bookId = bookId;
    this.totalCopies = totalCopies;
  }

  public void addCopies(int copies) {
    this.totalCopies += copies;
  }

  public void returnCopies(int copies) {
    this.totalCopies -= copies;
  }

  public void borrowCopies(int copies) {
    this.borrowedCopies += copies;
  }

  public void reserveCopies(int copies) {
    this.reservedCopies += copies;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getBranchId() {
    return branchId;
  }

  public void setBranchId(int branchId) {
    this.branchId = branchId;
  }

  public int getBookId() {
    return bookId;
  }

  public void setBookId(int bookId) {
    this.bookId = bookId;
  }

}
