package com.library.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.library.entity.Patron;
import com.library.utils.IDGenerator;

public class PatronRepository {
  private static List<Patron> patrons = new ArrayList<>();

  public void save(Patron patron) {
    int patronId = IDGenerator.nextPatronId();
    patron.setId(patronId);
    patrons.add(patron);
  }

  public void update(Patron patron) {
    int patronIdx = patrons.indexOf(patron);
    if (patronIdx >= 0) {
      patrons.set(patronIdx, patron);
    }
  }

  public void delete(int patronId) {
    Patron patron = this.getPatronById(patronId).get();
    if (patron == null) {
      return;
    }
    patrons.remove(patron);
  }

  public Optional<Patron> getPatronById(int patronId) {
    for (Patron patron : patrons) {
      if (patron.getId() == patronId) {
        return Optional.ofNullable(patron);
      }
    }
    return Optional.empty();
  }

  public List<Patron> list() {
    return patrons;
  }
}
