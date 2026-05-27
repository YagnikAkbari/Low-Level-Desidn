package com.library.service;

import com.library.entity.Branch;
import com.library.entity.Library;
import com.library.repository.LibraryRepository;

public class LibraryService {
  private LibraryRepository libraryRepo;

  public LibraryService(LibraryRepository libraryRepo) {
    this.libraryRepo = libraryRepo;
  }

  public void addLibrary(Library library) {
    libraryRepo.saveLibrary(library);
  }

  public void updateLibrary(Library library) {
    libraryRepo.updateLibrary(library);
  }

  public void removeLibrary(int libraryId) {
    libraryRepo.deleteLibrary(libraryId);
  }

  public void addBranch(Branch branch) {
    libraryRepo.saveBranch(branch);
  }

  public void updateBranch(Branch branch) {
    libraryRepo.updateBranch(branch);
  }

  public void removeBranch(int branchId) {
    libraryRepo.deleteBranch(branchId);
  }
}
