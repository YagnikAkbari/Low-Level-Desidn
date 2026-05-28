package com.library.entity;

import com.library.enums.BorrowStatus;

import java.time.LocalDate;

public class Reservation {
  private int id;
  private int branchId;
  private int bookId;
  private int patronId;
  private LocalDate reservationDate;
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

  public int getBranchId() {
    return branchId;
  }

  public void setBranchId(int branchId) {
    this.branchId = branchId;
  }

  public int getPatronId() {
    return patronId;
  }

  public void setPatronId(int patronId) {
    this.patronId = patronId;
  }

  public LocalDate getReservationDate() {
    return reservationDate;
  }

  public void setReservationDate(LocalDate reservationDate) {
    this.reservationDate = reservationDate;
  }

  public BorrowStatus getStatus() {
    return status;
  }

  public void setStatus(BorrowStatus status) {
    this.status = status;
  }

  public Reservation(int branchId, int bookId, int patronId, LocalDate reservationDate) {
    this.branchId = branchId;
    this.bookId = bookId;
    this.patronId = patronId;
    this.reservationDate = reservationDate;
    this.status = BorrowStatus.PENDING;
  }

  @Override
  public String toString() {
    return String.format(
        "{\"id\":%d,\"branchId\":%d,\"bookId\":%d,\"patronId\":%d,\"reservationDate\":\"%s\",\"status\":\"%s\"}",
        id,
        branchId,
        bookId,
        patronId,
        reservationDate,
        status);
  }
}
