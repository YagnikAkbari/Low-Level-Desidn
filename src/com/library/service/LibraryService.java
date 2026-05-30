package com.library.service;

import java.util.List;

import com.library.entity.Branch;
import com.library.entity.Library;
import com.library.repository.LibraryRepository;
import com.library.exception.InvalidInputException;
import com.library.validators.LibraryValidators;

public class LibraryService {
  private LibraryRepository libraryRepo;

  public LibraryService() {
    this(new LibraryRepository());
  }

  public LibraryService(LibraryRepository libraryRepo) {
    this.libraryRepo = libraryRepo;
  }

  public int addLibrary(Library library) {
    validateLibrary(library);
    return libraryRepo.saveLibrary(library);
  }

  public void updateLibrary(Library library) {
    validateLibrary(library);
    ensureLibraryExists(library.getId());
    libraryRepo.updateLibrary(library);
  }

  public void removeLibrary(int libraryId) {
    ensureLibraryExists(libraryId);
    libraryRepo.deleteLibrary(libraryId);
  }

  public int addBranch(Branch branch) {
    validateBranch(branch);
    ensureLibraryExists(branch.getLibraryId());
    return libraryRepo.saveBranch(branch);
  }

  public void updateBranch(Branch branch) {
    validateBranch(branch);
    ensureBranchExists(branch.getId());
    ensureLibraryExists(branch.getLibraryId());
    libraryRepo.updateBranch(branch);
  }

  public void removeBranch(int branchId) {
    ensureBranchExists(branchId);
    libraryRepo.deleteBranch(branchId);
  }

  public List<Branch> listBranch() {
    return libraryRepo.listBranch();
  }

  public List<Library> listLibrary() {
    return libraryRepo.listLibrary();
  }

  public Library getLibraryById(int libraryId) {
    return libraryRepo.getLibraryById(libraryId)
        .orElseThrow(() -> new IllegalArgumentException("Library not found"));
  }

  public Branch getBranchById(int branchId) {
    return libraryRepo.getBranchById(branchId)
        .orElseThrow(() -> new IllegalArgumentException("Branch not found"));
  }

  public boolean libraryExists(int libraryId) {
    return libraryRepo.getLibraryById(libraryId).isPresent();
  }

  public boolean branchExists(int branchId) {
    return libraryRepo.getBranchById(branchId).isPresent();
  }

  private void validateLibrary(Library library) {
    try {
      LibraryValidators.validateLibrary(library);
    } catch (InvalidInputException exception) {
      throw new IllegalArgumentException(exception.getMessage(), exception);
    }
  }

  private void validateBranch(Branch branch) {
    try {
      LibraryValidators.validateBranch(branch);
    } catch (InvalidInputException exception) {
      throw new IllegalArgumentException(exception.getMessage(), exception);
    }
  }

  private void ensureLibraryExists(int libraryId) {
    if (!libraryExists(libraryId)) {
      throw new IllegalArgumentException("Library not found");
    }
  }

  private void ensureBranchExists(int branchId) {
    if (!branchExists(branchId)) {
      throw new IllegalArgumentException("Branch not found");
    }
  }
}
