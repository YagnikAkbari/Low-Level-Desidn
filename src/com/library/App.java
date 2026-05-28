package com.library;

import java.time.LocalDate;

import com.library.entity.Book;
import com.library.entity.LibraryBook;
import com.library.entity.Patron;
import com.library.entity.Reservation;
import com.library.repository.AuthorRepository;
import com.library.repository.BookRepository;
import com.library.repository.InventoryRepository;
import com.library.repository.LibraryRepository;
import com.library.repository.MasterDataRepository;
import com.library.repository.PatronRepository;
import com.library.repository.ReservationRepository;
import com.library.seeder.SeedBook;
import com.library.seeder.SeedInventory;
import com.library.seeder.SeedLibrary;
import com.library.seeder.SeedPatron;
import com.library.service.AuthorService;
import com.library.service.BookService;
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
    ReservationRepository reservationRepo = new ReservationRepository();
    ReservationService reservationService = new ReservationService(reservationRepo);
    PatronRepository patronRepo = new PatronRepository();
    PatronService patronService = new PatronService(patronRepo);
    SeedBook.seed(authorService, masterDataService, bookService);
    SeedLibrary.seed(libraryService);
    SeedInventory.seed(bookService, libraryService, inventoryService);
    SeedPatron.seed(patronService);
    // Patron p1 = patronService.getPatronById(2);
    // Book b1 = bookService.getBookById(5);
    Reservation reservation = new Reservation(1, 5, 2, LocalDate.now());
    Reservation reservation1 = new Reservation(1, 4, 1, LocalDate.now());
    Reservation reservation2 = new Reservation(1, 5, 1, LocalDate.now());
    Reservation reservation3 = new Reservation(1, 5, 3, LocalDate.now());
    reservationService.reserveBook(reservation);
    reservationService.reserveBook(reservation1);
    reservationService.reserveBook(reservation2);
    reservationService.reserveBook(reservation3);

    for (Reservation res : reservationService.listReservation()) {
      System.out.println(res);
    }
    // for (LibraryBook libraryBook : inventoryService.listLibraryBooks()) {
    // System.out.println(libraryBook);
    // }
    // Book book = bookService.getBookById(5).get();
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
