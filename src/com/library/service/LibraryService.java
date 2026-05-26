package com.library.service;

import com.library.entity.Library;
import com.library.repository.LibraryRepository;

public class LibraryService {
  private LibraryRepository libraryRepo;

  public LibraryService(LibraryRepository libraryRepo) {
    this.libraryRepo = libraryRepo;
  }

  public void addLibrary(Library library) {
    libraryRepo.save(library);
  }

  public void updateLibrary(Library library) {
    libraryRepo.update(library);
  }

  public void removeLibrary(int libraryId) {
    libraryRepo.delete(libraryId);
  }
}
