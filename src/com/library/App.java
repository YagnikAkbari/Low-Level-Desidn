package com.library;

import com.library.entity.LibraryBook;
import com.library.repository.AuthorRepository;
import com.library.repository.BookRepository;
import com.library.repository.BorrowingRepository;
import com.library.repository.InventoryRepository;
import com.library.repository.LibraryRepository;
import com.library.repository.MasterDataRepository;
import com.library.repository.PatronRepository;
import com.library.repository.ReservationRepository;
import com.library.seeder.SeedBook;
import com.library.seeder.SeedBorrowing;
import com.library.seeder.SeedInventory;
import com.library.seeder.SeedLibrary;
import com.library.seeder.SeedPatron;
import com.library.seeder.SeedReservation;
import com.library.service.AuthorService;
import com.library.service.BookService;
import com.library.service.BorrowingService;
import com.library.service.InventoryService;
import com.library.service.LibraryService;
import com.library.service.MasterDataService;
import com.library.service.PatronService;
import com.library.service.ReservationService;

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
    BorrowingRepository borrowingRepo = new BorrowingRepository();
    BorrowingService borrowingService = new BorrowingService(borrowingRepo, inventoryService);
    ReservationRepository reservationRepo = new ReservationRepository();
    ReservationService reservationService = new ReservationService(reservationRepo);
    PatronRepository patronRepo = new PatronRepository();
    PatronService patronService = new PatronService(patronRepo);
    SeedBook.seed(authorService, masterDataService, bookService);
    SeedLibrary.seed(libraryService);
    SeedInventory.seed(bookService, libraryService, inventoryService);
    SeedPatron.seed(patronService);
    SeedBorrowing.seed(inventoryService, patronService, borrowingRepo);
    SeedReservation.seed(inventoryService, patronService, reservationRepo);
    for (LibraryBook libBook : inventoryService.listLibraryBooks()) {
      System.out.println(libBook);
    }
  }

  public static void main(String[] args) {
    run();
  }
}
