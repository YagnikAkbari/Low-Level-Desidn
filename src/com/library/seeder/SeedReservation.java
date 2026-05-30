package com.library.seeder;

import java.time.LocalDate;
import java.util.List;

import com.library.entity.LibraryBook;
import com.library.entity.Patron;
import com.library.entity.Reservation;
import com.library.enums.BorrowStatus;
import com.library.repository.ReservationRepository;
import com.library.service.InventoryService;
import com.library.service.PatronService;

public class SeedReservation {
  public static void seed(InventoryService inventoryService, PatronService patronService,
      ReservationRepository reservationRepository) {
    List<LibraryBook> libraryBooks = inventoryService.listLibraryBooks();
    List<Patron> patrons = patronService.listPatron();

    if (libraryBooks.isEmpty() || patrons.isEmpty()) {
      return;
    }

    int seedCount = Math.min(10, libraryBooks.size());

    for (int i = 0; i < seedCount; i++) {
      LibraryBook libraryBook = libraryBooks.get(libraryBooks.size() - 1 - i);
      Patron patron = patrons.get((i + 5) % patrons.size());

      inventoryService.reserveCopies(libraryBook.getBranchId(), libraryBook.getBookId(), 1);

      LocalDate reservationDate = LocalDate.of(2026, 2, 1).plusDays(i * 2L);
      Reservation reservation = new Reservation(
          libraryBook.getBranchId(),
          libraryBook.getBookId(),
          patron.getId(),
          reservationDate);

      if (i % 4 == 1) {
        reservation.setStatus(BorrowStatus.FULFILLED);
      } else if (i % 4 == 3) {
        reservation.setStatus(BorrowStatus.CANCELLED);
      }

      reservationRepository.save(reservation);
    }
  }
}
