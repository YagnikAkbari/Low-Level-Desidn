package com.library.entity;

import java.util.Date;

public class Borrowing {
  private int id;
  private int bookId;
  private int patronId;
  private Date dueDate;
  private Date returnDate;

  public Borrowing(int bookId, int patronId, Date dueDate) {
    this.bookId = bookId;
    this.patronId = patronId;
    this.dueDate = dueDate;
  }

  public void setReturnDate(Date returnDate) {
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

  public void setBookId(int bookId) {
    this.bookId = bookId;
  }

  public int getPatronId() {
    return patronId;
  }

  public void setPatronId(int patronId) {
    this.patronId = patronId;
  }

  public Date getDueDate() {
    return dueDate;
  }

  public void setDueDate(Date dueDate) {
    this.dueDate = dueDate;
  }

  public Date getReturnDate() {
    return returnDate;
  }
}
