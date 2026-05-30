package com.library.service;

import java.util.List;

import com.library.entity.Branch;
import com.library.entity.Library;
import com.library.repository.LibraryRepository;

public class LibraryService {
  private LibraryRepository libraryRepo;

  public LibraryService() {
    this(new LibraryRepository());
  }

  public LibraryService(LibraryRepository libraryRepo) {
    this.libraryRepo = libraryRepo;
  }

  public int addLibrary(Library library) {
    return libraryRepo.saveLibrary(library);
  }

  public void updateLibrary(Library library) {
    libraryRepo.updateLibrary(library);
  }

  public void removeLibrary(int libraryId) {
    libraryRepo.deleteLibrary(libraryId);
  }

  public int addBranch(Branch branch) {
    return libraryRepo.saveBranch(branch);
  }

  public void updateBranch(Branch branch) {
    libraryRepo.updateBranch(branch);
  }

  public void removeBranch(int branchId) {
    libraryRepo.deleteBranch(branchId);
  }

  public List<Branch> listBranch() {
    return libraryRepo.listBranch();
  }

  public List<Library> listLibrary() {
    return libraryRepo.listLibrary();
  }
}
