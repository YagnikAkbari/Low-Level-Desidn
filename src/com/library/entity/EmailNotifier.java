package com.library.entity;

public class EmailNotifier implements Notifier {
  private String toEmail;
  private String fromEmail;
  private String clienId;
  private String clienSecret;

  public EmailNotifier() {
    this.fromEmail = "support@library.com";
    this.clienId = "SKJAECJDKFCNS4543j5bmjK";
    this.clienSecret = "SKJAECJDKFCNSasdfsdjgvn";
  }

  public void setFromEmail(String fromEmail) {
    this.fromEmail = fromEmail;
  }

    public static class LibraryBook {
      private int id;
      private int libraryId;
      private int bookId;
      private int totalCopies;
      private int availableCopies;
      private int borrowedCopies;
      private int reservedCopies;

      public int getId() {
        return id;
      }

      public void setId(int id) {
        this.id = id;
      }

      public int getLibraryId() {
        return libraryId;
      }

      public void setLibraryId(int libraryId) {
        this.libraryId = libraryId;
      }

      public int getBookId() {
        return bookId;
      }

      public void setBookId(int bookId) {
        this.bookId = bookId;
      }

      public int getTotalCopies() {
        return totalCopies;
      }

      public void setTotalCopies(int totalCopies) {
        this.totalCopies = totalCopies;
      }

      public int getAvailableCopies() {
        return availableCopies;
      }

      public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
      }

      public int getBorrowedCopies() {
        return borrowedCopies;
      }

      public void setBorrowedCopies(int borrowedCopies) {
        this.borrowedCopies = borrowedCopies;
      }

      public int getReservedCopies() {
        return reservedCopies;
      }

      public void setReservedCopies(int reservedCopies) {
        this.reservedCopies = reservedCopies;
      }

      public LibraryBook(int libraryId, int bookId, int totalCopies) {
        this.libraryId = libraryId;
        this.bookId = bookId;
        this.totalCopies = totalCopies;
      }

      public void borrowBook() {
        this.availableCopies--;
        this.borrowedCopies++;
      }

      public void reserveBook() {
        this.reservedCopies++;
      }
    }
}
