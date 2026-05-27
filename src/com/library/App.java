package com.library;

import com.library.entity.Author;
import com.library.entity.Book;
import com.library.entity.Branch;
import com.library.entity.Category;
import com.library.entity.Genre;
import com.library.entity.Library;
import com.library.entity.LibraryBook;
import com.library.repository.AuthorRepository;
import com.library.repository.BookRepository;
import com.library.repository.InventoryRepository;
import com.library.repository.LibraryRepository;
import com.library.repository.MasterDataRepository;
import com.library.seeder.SeedBook;
import com.library.service.AuthorService;
import com.library.service.BookService;
import com.library.service.InventoryService;
import com.library.service.LibraryService;
import com.library.service.MasterDataService;

public class App {
  public static void run() {
    AuthorRepository authorRepo = new AuthorRepository();
    AuthorService authorService = new AuthorService(authorRepo);
    LibraryRepository libraryRepo = new LibraryRepository();
    LibraryService libraryService = new LibraryService(libraryRepo);
    MasterDataRepository masterDataRepo = new MasterDataRepository();
    MasterDataService masterDataService = new MasterDataService(masterDataRepo);
    BookRepository bookRepo = new BookRepository();
    BookService bookService = new BookService(bookRepo);
    InventoryRepository inventoryRepo = new InventoryRepository();
    InventoryService inventoryService = new InventoryService(inventoryRepo);
    SeedBook.seed(authorService, masterDataService, bookService);
    for (Book book : bookService.listBook()) {
      for (Branch libraryBranch : libraryService.listBranch()) {
        LibraryBook lB = new LibraryBook(book.getId(), libraryBranch.getId(), 15);
        inventoryService.createInventory(lB);
      }
    }
    for (LibraryBook libraryBook : inventoryService.listLibraryBooks()) {
      System.out.println(libraryBook);
    }
    // for (Genre genre : masterDataService.listGenre()) {
    // System.out.println(genre);
    // }
    // for (Category category : masterDataService.listCategory()) {
    // System.out.println(category);
    // }
  }

  public static void main(String[] args) {
    run();
  }
}