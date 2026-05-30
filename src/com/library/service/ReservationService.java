package com.library.service;

import java.util.List;
import java.time.LocalDate;

import com.library.entity.Reservation;
import com.library.enums.BorrowStatus;
import com.library.repository.ReservationRepository;

public class ReservationService {
  private ReservationRepository reservationRepo;
  private final InventoryService inventoryService;
  private final NotificationService notificationService;

  public ReservationService() {
    this(new ReservationRepository(), new InventoryService(), new NotificationService());
  }

  public ReservationService(ReservationRepository reservationRepo) {
    this(reservationRepo, new InventoryService(), new NotificationService());
  }

  public ReservationService(ReservationRepository reservationRepo, InventoryService inventoryService,
      NotificationService notificationService) {
    this.reservationRepo = reservationRepo;
    this.inventoryService = inventoryService;
    this.notificationService = notificationService;
  }

  public int reserveBook(Reservation reservation) {
    if (reservation.getReservationDate() == null) {
      reservation.setReservationDate(LocalDate.now());
    }
    reservation.setStatus(BorrowStatus.PENDING);
    if (inventoryService != null) {
      inventoryService.reserveBook(
          reservation.getBranchId(),
          reservation.getBookId(),
          reservation.getPatronId(),
          1);
    }
    notificationService.notifyUser(String.valueOf(reservation.getPatronId()),
        "Reservation created for book " + reservation.getBookId());
    return reservationRepo.save(reservation);
  }

  public List<Reservation> listReservation() {
    return reservationRepo.list();
  }

  public void cancelReservation(int reservationId) {
    Reservation reservation = reservationRepo.getReservation(reservationId).orElseThrow();
    reservation.setStatus(BorrowStatus.CANCELLED);
    reservationRepo.update(reservation);
    if (inventoryService != null) {
      inventoryService.cancelReservation(reservation.getBranchId(), reservation.getBookId(), 1);
    }
    notificationService.notifyUser(String.valueOf(reservation.getPatronId()),
        "Reservation cancelled for book " + reservation.getBookId());
  }

  public void transferBookToBranch(int fromBranchId, int toBranchId, int bookId, int copies) {
    if (inventoryService == null) {
      return;
    }
    inventoryService.transferBookToBranch(fromBranchId, toBranchId, bookId, copies);
  }

  public void notifyReservationReady(int bookId, int patronId) {
    notificationService.notifyUser(String.valueOf(patronId), "Book " + bookId + " is now available");
  }
}
