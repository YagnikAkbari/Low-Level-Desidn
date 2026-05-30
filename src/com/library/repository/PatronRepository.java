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
    for (int i = 0; i < patrons.size(); i++) {
      if (patrons.get(i).getId() == patron.getId()) {
        patrons.set(i, patron);
        return;
      }
    }
  }

  public void delete(int patronId) {
    for (int i = 0; i < patrons.size(); i++) {
      if (patrons.get(i).getId() == patronId) {
        patrons.remove(i);
        return;
      }
    }
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
