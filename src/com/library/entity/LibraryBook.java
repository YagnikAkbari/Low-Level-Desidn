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
    if (copies <= 0) {
      throw new IllegalArgumentException("Copies must be greater than 0");
    }
    this.totalCopies += copies;
  }

  public void removeCopies(int copies) {
    if (copies <= 0) {
      throw new IllegalArgumentException("Copies must be greater than 0");
    }
    if (copies > getAvailableCopies()) {
      throw new IllegalArgumentException("Not enough available copies");
    }
    this.totalCopies -= copies;
  }

  public void borrowCopies(int copies) {
    if (copies <= 0) {
      throw new IllegalArgumentException("Copies must be greater than 0");
    }
    if (copies > getAvailableCopies()) {
      throw new IllegalArgumentException("Not enough available copies");
    }
    this.borrowedCopies += copies;
  }

  public void reserveCopies(int copies) {
    if (copies <= 0) {
      throw new IllegalArgumentException("Copies must be greater than 0");
    }
    if (copies > getAvailableCopies()) {
      throw new IllegalArgumentException("Not enough available copies");
    }
    this.reservedCopies += copies;
  }

  public void returnBorrowedCopies(int copies) {
    if (copies <= 0) {
      throw new IllegalArgumentException("Copies must be greater than 0");
    }
    if (copies > this.borrowedCopies) {
      throw new IllegalArgumentException("Cannot return more copies than borrowed");
    }
    this.borrowedCopies -= copies;
  }

  public void releaseReservedCopies(int copies) {
    if (copies <= 0) {
      throw new IllegalArgumentException("Copies must be greater than 0");
    }
    if (copies > this.reservedCopies) {
      throw new IllegalArgumentException("Cannot release more copies than reserved");
    }
    this.reservedCopies -= copies;
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
