package com.library.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.library.entity.LibraryBook;
import com.library.utils.IDGenerator;

public class InventoryRepository {
  private static List<LibraryBook> libraryBooks = new ArrayList<>();

  public int save(LibraryBook libraryBook) {
    int libraryBookId = IDGenerator.nextLibraryBookId();
    libraryBook.setId(libraryBookId);
    libraryBooks.add(libraryBook);
    return libraryBookId;
  }

  public void update(LibraryBook libraryBook) {
    for (int i = 0; i < libraryBooks.size(); i++) {
      if (libraryBooks.get(i).getId() == libraryBook.getId()) {
        libraryBooks.set(i, libraryBook);
        return;
      }
    }
  }

  public void delete(int libraryBookId) {
    for (int i = 0; i < libraryBooks.size(); i++) {
      if (libraryBooks.get(i).getId() == libraryBookId) {
        libraryBooks.remove(i);
        return;
      }
    }
  }

  public Optional<LibraryBook> getLibraryBook(int libraryBookId) {
    for (LibraryBook libraryBook : libraryBooks) {
      if (libraryBook.getId() == libraryBookId) {
        return Optional.ofNullable(libraryBook);
      }
    }
    return Optional.empty();
  }

  public Optional<LibraryBook> getLibraryBook(int branchId, int bookId) {
    for (LibraryBook libraryBook : libraryBooks) {
      if (libraryBook.getBranchId() == branchId && libraryBook.getBookId() == bookId) {
        return Optional.ofNullable(libraryBook);
      }
    }
    return Optional.empty();
  }

  public List<LibraryBook> listLibraryBooks() {
    return libraryBooks;
  }

  public List<LibraryBook> listLibraryBooks(int libraryId) {
    List<LibraryBook> result = new ArrayList<>();
    for (LibraryBook lB : libraryBooks) {
      if (lB.getBranchId() == libraryId) {
        result.add(lB);
      }
    }
    return result;
  }

  public int[] getTotalAvailable(int bookId) {
    int total = 0;
    int available = 0;
    int borrowed = 0;
    int reserved = 0;
    for (LibraryBook libraryBook : libraryBooks) {
      if (libraryBook.getBookId() == bookId) {
        total += libraryBook.getTotalCopies();
        available += libraryBook.getAvailableCopies();
        borrowed += libraryBook.getBorrowedCopies();
        reserved += libraryBook.getReservedCopies();
      }
    }
    return new int[] { total, available, borrowed, reserved };
  }

  public List<int[]> getTotalAvailable(List<Integer> bookIds) {
    List<int[]> result = new ArrayList<>();
    for (int i = 0; i < bookIds.size(); i++) {
      result.add(getTotalAvailable(bookIds.get(i)));
    }
    return result;
  }

  public void addBookCopy(int branchId, int bookId, int copies) {
    LibraryBook libraryBook = this.getLibraryBook(branchId, bookId).orElse(null);
    if (libraryBook == null) {
      return;
    }
    libraryBook.addCopies(copies);
    update(libraryBook);
  }

  public void removeBookCopy(int branchId, int bookId, int copies) {
    LibraryBook libraryBook = this.getLibraryBook(branchId, bookId).orElse(null);
    if (libraryBook == null) {
      return;
    }
    libraryBook.removeCopies(copies);
    update(libraryBook);
  }

  public void borrowBook(int branchId, int bookId, int patronId, int copies) {
    LibraryBook libraryBook = this.getLibraryBook(branchId, bookId).orElse(null);
    if (libraryBook == null) {
      return;
    }
    libraryBook.borrowCopies(copies);
    update(libraryBook);
  }

  public void returnBook(int branchId, int bookId, int patronId, int copies) {
    LibraryBook libraryBook = this.getLibraryBook(branchId, bookId).orElse(null);
    if (libraryBook == null) {
      return;
    }
    libraryBook.returnBorrowedCopies(copies);
    update(libraryBook);
  }

  public void reserveBook(int branchId, int bookId, int patronId, int copies) {
    LibraryBook libraryBook = this.getLibraryBook(branchId, bookId).orElse(null);
    if (libraryBook == null) {
      return;
    }
    libraryBook.reserveCopies(copies);
    update(libraryBook);
  }

  public void cancelReservation(int branchId, int bookId, int copies) {
    LibraryBook libraryBook = this.getLibraryBook(branchId, bookId).orElse(null);
    if (libraryBook == null) {
      return;
    }
    libraryBook.releaseReservedCopies(copies);
    update(libraryBook);
  }

  public void transferBookToBranch(int fromBranchId, int toBranchId, int bookId, int copies) {
    LibraryBook source = this.getLibraryBook(fromBranchId, bookId).orElse(null);
    if (source == null) {
      return;
    }
    LibraryBook destination = this.getLibraryBook(toBranchId, bookId).orElse(null);
    if (destination == null) {
      destination = new LibraryBook(toBranchId, bookId, 0);
      save(destination);
    }
    source.removeCopies(copies);
    destination.addCopies(copies);
    update(source);
    update(destination);
  }
}
