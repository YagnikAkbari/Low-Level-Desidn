package com.library.entity;

import java.time.LocalDate;

public class Borrowing {
  private int id;
  private int branchId;
  private int bookId;
  private int patronId;
  private LocalDate dueDate;
  private LocalDate borrowDate;
  private LocalDate returnDate;

  public Borrowing(int branchId, int bookId, int patronId, LocalDate dueDate) {
    this.branchId = branchId;
    this.bookId = bookId;
    this.patronId = patronId;
    this.dueDate = dueDate;
  }

  public void setReturnDate(LocalDate returnDate) {
    this.returnDate = returnDate;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public int getBookId() {
    return bookId;
  }

  public int getBranchId() {
    return branchId;
  }

  public void setBranchId(int branchId) {
    this.branchId = branchId;
  }

  public void setBookId(int bookId) {
    this.bookId = bookId;
  }

  public int getPatronId() {
    return patronId;
  }

  public void setPatronId(int patronId) {
    this.patronId = patronId;
  }

  public LocalDate getDueDate() {
    return dueDate;
  }

  public void setDueDate(LocalDate dueDate) {
    this.dueDate = dueDate;
  }

  public LocalDate getReturnDate() {
    return returnDate;
  }

  public LocalDate getBorrowDate() {
    return borrowDate;
  }

  public void setBorrowDate(LocalDate borrowDate) {
    this.borrowDate = borrowDate;
  }
}
