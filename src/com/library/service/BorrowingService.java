package com.library.service;

import com.library.entity.Borrowing;
import com.library.repository.BorrowingRepository;

public class BorrowingService {
  private BorrowingRepository borrowingRepo;
  private InventoryService inventoryService;

  public BorrowingService(BorrowingRepository borrowingRepo, InventoryService inventoryService) {
    this.borrowingRepo = borrowingRepo;
    this.inventoryService = inventoryService;
  }

  public void borrowBook(int branchId, int bookId, int patronId, int copies) {
    inventoryService.borrowBook(branchId, bookId, patronId, copies);
    Borrowing borrow = new Borrowing(branchId, bookId, patronId, null);
    borrowingRepo.save(borrow);
  }
}
