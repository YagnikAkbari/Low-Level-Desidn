package com.library.service;

import java.util.List;

import com.library.entity.LibraryBook;
import com.library.repository.InventoryRepository;

public class InventoryService {
  private InventoryRepository inventoryRepo;

  public InventoryService(InventoryRepository inventoryRepo) {
    this.inventoryRepo = inventoryRepo;
  }

  public int createInventory(LibraryBook libraryBook) {
    return inventoryRepo.save(libraryBook);
  }

  public void addCopies(int libraryId, int bookId, int copies) {
    LibraryBook libraryBook = inventoryRepo.getLibraryBook(libraryId, bookId).get();
    libraryBook.addCopies(copies);
    inventoryRepo.update(libraryBook);
  }

  public void reserveCopies(int libraryId, int bookId, int copies) {
    LibraryBook libraryBook = inventoryRepo.getLibraryBook(libraryId, bookId).get();
    libraryBook.reserveCopies(copies);
    inventoryRepo.update(libraryBook);
  }

  public void borrowBook(int branchId, int bookId, int patronId, int copies) {
    LibraryBook libraryBook = inventoryRepo.getLibraryBook(branchId, bookId).get();
    libraryBook.borrowCopies(copies);
    inventoryRepo.update(libraryBook);
  }

  public List<LibraryBook> listLibraryBooks() {
    return inventoryRepo.listLibraryBooks();
  }
}
