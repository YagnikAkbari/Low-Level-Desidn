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

  public void removeCopies(int copies) {
    this.totalCopies -= copies;
    if (this.totalCopies < 0) {
      this.totalCopies = 0;
    }
  }

  public void borrowCopies(int copies) {
    if (copies > getAvailableCopies()) {
      throw new IllegalArgumentException("Not enough available copies");
    }
    this.borrowedCopies += copies;
  }

  public void reserveCopies(int copies) {
    if (copies > getAvailableCopies()) {
      throw new IllegalArgumentException("Not enough available copies");
    }
    this.reservedCopies += copies;
  }

  public void returnBorrowedCopies(int copies) {
    this.borrowedCopies -= copies;
    if (this.borrowedCopies < 0) {
      this.borrowedCopies = 0;
    }
  }

  public void releaseReservedCopies(int copies) {
    this.reservedCopies -= copies;
    if (this.reservedCopies < 0) {
      this.reservedCopies = 0;
    }
  }

  public int getTotalCopies() {
    return totalCopies;
  }

  public int getBorrowedCopies() {
    return borrowedCopies;
  }

  public int getReservedCopies() {
    return reservedCopies;
  }

  public int getAvailableCopies() {
    return totalCopies - borrowedCopies - reservedCopies;
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

  @Override
  public String toString() {
    return String.format(
        "{\"id\":%d,\"branchId\":%d,\"bookId\":%d,\"totalCopies\":%d,\"borrowedCopies\":%d,\"reservedCopies\":%d}",
        id,
        branchId,
        bookId,
        totalCopies,
        borrowedCopies,
        reservedCopies);
  }
}
