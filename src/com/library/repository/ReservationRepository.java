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
    for (int i = 0; i < reservations.size(); i++) {
      if (reservations.get(i).getId() == reservation.getId()) {
        reservations.set(i, reservation);
        return;
      }
    }
  }

  public void delete(int reservationId) {
    for (int i = 0; i < reservations.size(); i++) {
      if (reservations.get(i).getId() == reservationId) {
        reservations.remove(i);
        return;
      }
    }
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

  public List<Reservation> listByBook(int bookId) {
    List<Reservation> result = new ArrayList<>();
    for (Reservation reservation : reservations) {
      if (reservation.getBookId() == bookId) {
        result.add(reservation);
      }
    }
    return result;
  }

  public List<Reservation> listByPatron(int patronId) {
    List<Reservation> result = new ArrayList<>();
    for (Reservation reservation : reservations) {
      if (reservation.getPatronId() == patronId) {
        result.add(reservation);
      }
    }
    return result;
  }
}
