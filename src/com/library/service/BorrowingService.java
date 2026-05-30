package com.library.service;

import java.time.LocalDate;
import java.util.List;

import com.library.entity.Borrowing;
import com.library.entity.Reservation;
import com.library.repository.BorrowingRepository;
import com.library.repository.ReservationRepository;

public class BorrowingService {
  private BorrowingRepository borrowingRepo;
  private InventoryService inventoryService;
  private final NotificationService notificationService;
  private final ReservationRepository reservationRepository;

  public BorrowingService() {
    this(new BorrowingRepository(), new InventoryService(new com.library.repository.InventoryRepository()),
        new NotificationService(), null);
  }

  public BorrowingService(BorrowingRepository borrowingRepo, InventoryService inventoryService) {
    this(borrowingRepo, inventoryService, new NotificationService(), null);
  }

  public BorrowingService(BorrowingRepository borrowingRepo, InventoryService inventoryService,
      NotificationService notificationService, ReservationRepository reservationRepository) {
    this.borrowingRepo = borrowingRepo;
    this.inventoryService = inventoryService;
    this.notificationService = notificationService;
    this.reservationRepository = reservationRepository;
  }

  public void borrowBook(int branchId, int bookId, int patronId, int copies) {
    inventoryService.borrowBook(branchId, bookId, patronId, copies);
    Borrowing borrow = new Borrowing(branchId, bookId, patronId, LocalDate.now().plusDays(14));
    borrow.setBorrowDate(LocalDate.now());
    borrowingRepo.save(borrow);
    notificationService.notifyUser(String.valueOf(patronId),
        "Borrowing recorded for book " + bookId);
  }

  public void returnBook(int branchId, int bookId, int patronId, int copies) {
    inventoryService.returnBook(branchId, bookId, patronId, copies);
    notificationService.notifyUser(String.valueOf(patronId),
        "Return recorded for book " + bookId);
  }

  public List<Borrowing> listBorrowings() {
    return borrowingRepo.list();
  }

  public void fulfillReservation(int branchId, int bookId) {
    if (reservationRepository == null) {
      return;
    }
    List<Reservation> reservations = reservationRepository.listByBook(bookId);
    for (Reservation reservation : reservations) {
      if (reservation.getBranchId() == branchId) {
        reservation.setStatus(com.library.enums.BorrowStatus.FULFILLED);
        reservationRepository.update(reservation);
        notificationService.notifyUser(String.valueOf(reservation.getPatronId()),
            "Reservation fulfilled for book " + bookId);
        break;
      }
    }
  }
}
