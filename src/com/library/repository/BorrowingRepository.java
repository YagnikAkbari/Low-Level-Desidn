package com.library.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.library.entity.Borrowing;
import com.library.utils.IDGenerator;

public class BorrowingRepository {
  private static List<Borrowing> borrowings = new ArrayList<>();

  public int save(Borrowing borrowing) {
    int borrowingId = IDGenerator.nextBorrowingId();
    borrowing.setId(borrowingId);
    borrowings.add(borrowing);
    return borrowingId;
  }

  public void update(Borrowing borrowing) {
    for (int i = 0; i < borrowings.size(); i++) {
      if (borrowings.get(i).getId() == borrowing.getId()) {
        borrowings.set(i, borrowing);
        return;
      }
    }
  }

  public void delete(int borrowingId) {
    for (int i = 0; i < borrowings.size(); i++) {
      if (borrowings.get(i).getId() == borrowingId) {
        borrowings.remove(i);
        return;
      }
    }
  }

  public Optional<Borrowing> getBorrowingById(int borrowingId) {
    for (Borrowing borrowing : borrowings) {
      if (borrowing.getId() == borrowingId) {
        return Optional.ofNullable(borrowing);
      }
    }
    return Optional.empty();
  }

  public List<Borrowing> list() {
    return borrowings;
  }
}
