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
    int libraryBookId = libraryBooks.indexOf(libraryBook);
    if (libraryBookId >= 0) {
      libraryBooks.set(libraryBookId, libraryBook);
    }
  }

  public void delete(int libraryBookId) {
    LibraryBook libraryBook = this.getLibraryBook(libraryBookId).get();
    if (libraryBook == null) {
      return;
    }
    libraryBooks.remove(libraryBook);
  }

  public Optional<LibraryBook> getLibraryBook(int libraryBookId) {
    for (LibraryBook libraryBook : libraryBooks) {
      if (libraryBook.getId() == libraryBookId) {
        return Optional.ofNullable(libraryBook);
      }
    }
    return Optional.empty();
  }

  public Optional<LibraryBook> getLibraryBook(int libraryId, int bookId) {
    for (LibraryBook libraryBook : libraryBooks) {
      if (libraryBook.getBranchId() == libraryId && libraryBook.getBookId() == bookId) {
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
      result.add(lB);
    }
    return result;
  }
}
