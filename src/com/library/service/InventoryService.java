package com.library.service;

import java.util.List;

import com.library.entity.LibraryBook;
import com.library.repository.InventoryRepository;
import com.library.exception.InvalidInputException;
import com.library.validators.LibraryValidators;

public class InventoryService {
  private InventoryRepository inventoryRepo;
  private final NotificationService notificationService;

  public InventoryService() {
    this(new InventoryRepository(), new NotificationService());
  }

  public InventoryService(InventoryRepository inventoryRepo) {
    this(inventoryRepo, new NotificationService());
  }

  public InventoryService(InventoryRepository inventoryRepo, NotificationService notificationService) {
    this.inventoryRepo = inventoryRepo;
    this.notificationService = notificationService;
  }

  public int createInventory(LibraryBook libraryBook) {
    validateLibraryBook(libraryBook);
    return inventoryRepo.save(libraryBook);
  }

  public void addCopies(int libraryId, int bookId, int copies) {
    validateCopies(copies);
    LibraryBook libraryBook = getLibraryBookOrThrow(libraryId, bookId);
    libraryBook.addCopies(copies);
    inventoryRepo.update(libraryBook);
  }

  public void removeCopies(int libraryId, int bookId, int copies) {
    validateCopies(copies);
    LibraryBook libraryBook = getLibraryBookOrThrow(libraryId, bookId);
    libraryBook.removeCopies(copies);
    inventoryRepo.update(libraryBook);
  }

  public void removeInventory(int libraryBookId) {
    if (inventoryRepo.getLibraryBook(libraryBookId).isEmpty()) {
      throw new IllegalArgumentException("Inventory record not found");
    }
    inventoryRepo.delete(libraryBookId);
  }

  public void reserveCopies(int libraryId, int bookId, int copies) {
    validateCopies(copies);
    LibraryBook libraryBook = getLibraryBookOrThrow(libraryId, bookId);
    libraryBook.reserveCopies(copies);
    inventoryRepo.update(libraryBook);
  }

  public void borrowBook(int branchId, int bookId, int patronId, int copies) {
    validateCopies(copies);
    LibraryBook libraryBook = getLibraryBookOrThrow(branchId, bookId);
    libraryBook.borrowCopies(copies);
    inventoryRepo.update(libraryBook);
    notificationService.notifyUser(String.valueOf(patronId),
        "Borrowed book " + bookId + " from branch " + branchId);
  }

  public void returnBook(int branchId, int bookId, int patronId, int copies) {
    validateCopies(copies);
    LibraryBook libraryBook = getLibraryBookOrThrow(branchId, bookId);
    libraryBook.returnBorrowedCopies(copies);
    inventoryRepo.update(libraryBook);
    notificationService.notifyUser(String.valueOf(patronId),
        "Returned book " + bookId + " to branch " + branchId);
  }

  public void reserveBook(int branchId, int bookId, int patronId, int copies) {
    validateCopies(copies);
    LibraryBook libraryBook = getLibraryBookOrThrow(branchId, bookId);
    libraryBook.reserveCopies(copies);
    inventoryRepo.update(libraryBook);
    notificationService.notifyUser(String.valueOf(patronId),
        "Reserved book " + bookId + " at branch " + branchId);
  }

  public void cancelReservation(int branchId, int bookId, int copies) {
    validateCopies(copies);
    LibraryBook libraryBook = getLibraryBookOrThrow(branchId, bookId);
    libraryBook.releaseReservedCopies(copies);
    inventoryRepo.update(libraryBook);
  }

  public void transferBookToBranch(int fromBranchId, int toBranchId, int bookId, int copies) {
    inventoryRepo.transferBookToBranch(fromBranchId, toBranchId, bookId, copies);
  }

  public List<LibraryBook> listLibraryBooks() {
    return inventoryRepo.listLibraryBooks();
  }

  public List<LibraryBook> listLibraryBooks(int libraryId) {
    return inventoryRepo.listLibraryBooks(libraryId);
  }

  public int[] getTotalAvailable(int bookId) {
    return inventoryRepo.getTotalAvailable(bookId);
  }

  public List<int[]> getTotalAvailable(List<Integer> bookIds) {
    return inventoryRepo.getTotalAvailable(bookIds);
  }

  public LibraryBook getLibraryBook(int branchId, int bookId) {
    return getLibraryBookOrThrow(branchId, bookId);
  }

  public boolean hasLibraryBook(int branchId, int bookId) {
    return inventoryRepo.getLibraryBook(branchId, bookId).isPresent();
  }

  private void validateLibraryBook(LibraryBook libraryBook) {
    try {
      LibraryValidators.validateLibraryBook(libraryBook);
    } catch (InvalidInputException exception) {
      throw new IllegalArgumentException(exception.getMessage(), exception);
    }
  }

  private void validateCopies(int copies) {
    try {
      LibraryValidators.validateCopies(copies);
    } catch (InvalidInputException exception) {
      throw new IllegalArgumentException(exception.getMessage(), exception);
    }
  }

  private LibraryBook getLibraryBookOrThrow(int branchId, int bookId) {
    return inventoryRepo.getLibraryBook(branchId, bookId)
        .orElseThrow(() -> new IllegalArgumentException(
            "Inventory record not found for branch " + branchId + " and book " + bookId));
  }
}
