package com.library.service;

import com.library.entity.Patron;
import com.library.repository.PatronRepository;

public class PatronService {
  private PatronRepository patronRepo;

  public PatronService(PatronRepository patronRepo) {
    this.patronRepo = patronRepo;
  }

  public void addPatron(Patron patron) {
    patronRepo.save(patron);
  }

  public void updatePatron(Patron patron) {
    patronRepo.update(patron);
  }

  public void removePatron(int patronId) {
    patronRepo.delete(patronId);
  }
}
