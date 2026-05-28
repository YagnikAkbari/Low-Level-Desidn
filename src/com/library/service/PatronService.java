package com.library.service;

import java.util.List;
import java.util.Optional;

import com.library.entity.Book;
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

  public Patron getPatronById(int patronId) {
    return patronRepo.getPatronById(patronId).get();
  }

  public List<Patron> listPatron() {
    return patronRepo.list();
  }
}
