package com.library.service;

import java.util.List;

import com.library.entity.Reservation;
import com.library.repository.ReservationRepository;

public class ReservationService {
  private ReservationRepository reservationRepo;

  public ReservationService(ReservationRepository reservationRepo) {
    this.reservationRepo = reservationRepo;
  }

  public int reserveBook(Reservation reservation) {
    return reservationRepo.save(reservation);
  }

  public List<Reservation> listReservation() {
    return reservationRepo.list();
  }
}
