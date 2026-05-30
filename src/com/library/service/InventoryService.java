package com.library.service;

import java.util.List;

import com.library.entity.LibraryBook;
import com.library.repository.InventoryRepository;

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
    return inventoryRepo.save(libraryBook);
  }

  public void addCopies(int libraryId, int bookId, int copies) {
    LibraryBook libraryBook = inventoryRepo.getLibraryBook(libraryId, bookId).orElseThrow();
    libraryBook.addCopies(copies);
    inventoryRepo.update(libraryBook);
  }

  public void reserveCopies(int libraryId, int bookId, int copies) {
    LibraryBook libraryBook = inventoryRepo.getLibraryBook(libraryId, bookId).orElseThrow();
    libraryBook.reserveCopies(copies);
    inventoryRepo.update(libraryBook);
  }

  public void borrowBook(int branchId, int bookId, int patronId, int copies) {
    LibraryBook libraryBook = inventoryRepo.getLibraryBook(branchId, bookId).orElseThrow();
    libraryBook.borrowCopies(copies);
    inventoryRepo.update(libraryBook);
    notificationService.notifyUser(String.valueOf(patronId),
        "Borrowed book " + bookId + " from branch " + branchId);
  }

  public void returnBook(int branchId, int bookId, int patronId, int copies) {
    LibraryBook libraryBook = inventoryRepo.getLibraryBook(branchId, bookId).orElseThrow();
    libraryBook.returnBorrowedCopies(copies);
    inventoryRepo.update(libraryBook);
    notificationService.notifyUser(String.valueOf(patronId),
        "Returned book " + bookId + " to branch " + branchId);
  }

  public void reserveBook(int branchId, int bookId, int patronId, int copies) {
    LibraryBook libraryBook = inventoryRepo.getLibraryBook(branchId, bookId).orElseThrow();
    libraryBook.reserveCopies(copies);
    inventoryRepo.update(libraryBook);
    notificationService.notifyUser(String.valueOf(patronId),
        "Reserved book " + bookId + " at branch " + branchId);
  }

  public void cancelReservation(int branchId, int bookId, int copies) {
    LibraryBook libraryBook = inventoryRepo.getLibraryBook(branchId, bookId).orElseThrow();
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
}
