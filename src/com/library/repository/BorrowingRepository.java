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
    int borrowingIdx = borrowings.indexOf(borrowing);
    if (borrowingIdx >= 0) {
      borrowings.set(borrowingIdx, borrowing);
    }
  }

  public void delete(int borrowingId) {
    Borrowing borrowing = this.getBorrowingById(borrowingId).get();
    if (borrowing == null) {
      return;
    }
    borrowings.remove(borrowing);
  }

  public Optional<Borrowing> getBorrowingById(int borrowingId) {
    for (Borrowing borrowing : borrowings) {
      if (borrowing.getId() == borrowingId) {
        return Optional.ofNullable(borrowing);
      }
    }
    return Optional.empty();
  }
}
