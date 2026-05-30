package com.library.service;

import java.util.List;

import com.library.entity.Patron;
import com.library.exception.InvalidInputException;
import com.library.repository.PatronRepository;
import com.library.validators.LibraryValidators;

public class PatronService {
  private PatronRepository patronRepo;

  public PatronService() {
    this(new PatronRepository());
  }

  public PatronService(PatronRepository patronRepo) {
    this.patronRepo = patronRepo;
  }

  public void addPatron(Patron patron) {
    validatePatron(patron);
    patronRepo.save(patron);
  }

  public void updatePatron(Patron patron) {
    validatePatron(patron);
    ensurePatronExists(patron.getId());
    patronRepo.update(patron);
  }

  public void removePatron(int patronId) {
    ensurePatronExists(patronId);
    patronRepo.delete(patronId);
  }

  public Patron getPatronById(int patronId) {
    return patronRepo.getPatronById(patronId)
        .orElseThrow(() -> new IllegalArgumentException("Patron not found"));
  }

  public List<Patron> listPatron() {
    return patronRepo.list();
  }

  public void addPatronIfMissing(Patron patron) {
    if (patronRepo.getPatronById(patron.getId()).isEmpty()) {
      patronRepo.save(patron);
    }
  }

  public boolean patronExists(int patronId) {
    return patronRepo.getPatronById(patronId).isPresent();
  }

  private void validatePatron(Patron patron) {
    try {
      LibraryValidators.validatePatron(patron);
    } catch (InvalidInputException exception) {
      throw new IllegalArgumentException(exception.getMessage(), exception);
    }
  }

  private void ensurePatronExists(int patronId) {
    if (!patronExists(patronId)) {
      throw new IllegalArgumentException("Patron not found");
    }
  }
}
