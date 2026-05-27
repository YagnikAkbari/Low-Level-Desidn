package com.library.service;

import java.util.List;

import com.library.entity.LibraryBook;
import com.library.repository.InventoryRepository;

public class InventoryService {
  private InventoryRepository inventoryRepository;

  public InventoryService(InventoryRepository inventoryRepository) {
    this.inventoryRepository = inventoryRepository;
  }

  public int createInventory(LibraryBook libraryBook) {
    return inventoryRepository.save(libraryBook);
  }

  public void addCopies(int libraryId, int bookId, int copies) {
    LibraryBook libraryBook = inventoryRepository.getLibraryBook(libraryId, bookId).get();
    libraryBook.addCopies(copies);
    inventoryRepository.update(libraryBook);
  }

  public void reserveCopies(int libraryId, int bookId, int copies) {
    LibraryBook libraryBook = inventoryRepository.getLibraryBook(libraryId, bookId).get();
    libraryBook.reserveCopies(copies);
    inventoryRepository.update(libraryBook);
  }

  public void borrowCopies(int libraryId, int bookId, int copies) {
    LibraryBook libraryBook = inventoryRepository.getLibraryBook(libraryId, bookId).get();
    libraryBook.borrowCopies(copies);
    inventoryRepository.update(libraryBook);
  }

  public List<LibraryBook> listLibraryBooks() {
    return inventoryRepository.listLibraryBooks();
  }
}
