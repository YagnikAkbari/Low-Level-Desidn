package com.library.seeder;

import java.time.LocalDate;
import java.util.List;

import com.library.entity.Borrowing;
import com.library.entity.LibraryBook;
import com.library.entity.Patron;
import com.library.repository.BorrowingRepository;
import com.library.service.InventoryService;
import com.library.service.PatronService;

public class SeedBorrowing {
  public static void seed(InventoryService inventoryService, PatronService patronService,
      BorrowingRepository borrowingRepository) {
    List<LibraryBook> libraryBooks = inventoryService.listLibraryBooks();
    List<Patron> patrons = patronService.listPatron();

    if (libraryBooks.isEmpty() || patrons.isEmpty()) {
      return;
    }

    int seedCount = Math.min(10, libraryBooks.size());

    for (int i = 0; i < seedCount; i++) {
      LibraryBook libraryBook = libraryBooks.get(i);
      Patron patron = patrons.get(i % patrons.size());

      inventoryService.borrowBook(libraryBook.getBranchId(), libraryBook.getBookId(), patron.getId(), 1);

      LocalDate borrowDate = LocalDate.of(2026, 1, 5).plusDays(i * 3L);
      LocalDate dueDate = borrowDate.plusDays(14);
      Borrowing borrowing = new Borrowing(
          libraryBook.getBranchId(),
          libraryBook.getBookId(),
          patron.getId(),
          dueDate);
      borrowing.setReturnDate(i % 3 == 0 ? borrowDate.plusDays(7) : null);
      borrowingRepository.save(borrowing);
    }
  }
}
