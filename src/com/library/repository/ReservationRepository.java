package com.library.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.library.entity.Reservation;
import com.library.utils.IDGenerator;

public class ReservationRepository {
  private static List<Reservation> reservations = new ArrayList<>();

  public int save(Reservation reservation) {
    int reservationId = IDGenerator.nextReservationId();
    reservation.setId(reservationId);
    reservations.add(reservation);
    return reservationId;
  }

  public void update(Reservation reservation) {
    int reservationId = reservations.indexOf(reservation);
    if (reservationId >= 0) {
      reservations.set(reservationId, reservation);
    }
  }

  public void delete(int reservationId) {
    Reservation reservation = this.getReservation(reservationId).get();
    if (reservation == null) {
      return;
    }
    reservations.remove(reservation);
  }

  public Optional<Reservation> getReservation(int reservationId) {
    for (Reservation reservation : reservations) {
      if (reservation.getId() == reservationId) {
        return Optional.ofNullable(reservation);
      }
    }
    return Optional.empty();
  }

  public List<Reservation> list() {
    return reservations;
  }
}
