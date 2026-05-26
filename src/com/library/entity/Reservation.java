package com.library.entity;

import java.util.Date;

import com.library.enums.BorrowStatus;

public class Reservation {
  private int id;
  private int bookId;
  private int patronId;
  private Date reservationDate;
  private BorrowStatus status;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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

  public Date getReservationDate() {
    return reservationDate;
  }

  public void setReservationDate(Date reservationDate) {
    this.reservationDate = reservationDate;
  }

  public BorrowStatus getStatus() {
    return status;
  }

  public void setStatus(BorrowStatus status) {
    this.status = status;
  }

  public Reservation(int bookId, int patronId, Date reservationDate) {
    this.bookId = bookId;
    this.patronId = patronId;
    this.reservationDate = reservationDate;
    this.status = BorrowStatus.PENDING;
  }
}
