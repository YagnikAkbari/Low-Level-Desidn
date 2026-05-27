package com.library.seeder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.library.entity.Book;
import com.library.entity.Branch;
import com.library.entity.LibraryBook;
import com.library.service.BookService;
import com.library.service.InventoryService;
import com.library.service.LibraryService;

public class SeedInventory {
  public static void seed(BookService bookService, LibraryService libraryService, InventoryService inventoryService) {
    List<Book> books = bookService.listBook();
    List<Branch> branches = libraryService.listBranch();
    if (books.isEmpty() || branches.isEmpty()) {
      return;
    }

    Random random = new Random();

    for (Branch branch : branches) {
      int maxBooksForBranch = Math.min(3, books.size());
      int bookCount = random.nextInt(maxBooksForBranch) + 1;
      List<Book> shuffledBooks = new ArrayList<>(books);
      Collections.shuffle(shuffledBooks, random);

      for (int i = 0; i < bookCount; i++) {
        Book book = shuffledBooks.get(i);
        int totalCopies = random.nextInt(100) + 1;
        LibraryBook libraryBook = new LibraryBook(branch.getId(), book.getId(), totalCopies);
        inventoryService.createInventory(libraryBook);
      }
    }
  }
}
