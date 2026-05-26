package com.library.repository;

import java.util.List;

import com.library.entity.Library;
import com.library.utils.IDGenerator;

public class LibraryRepository {
  private static List<Library> libraries;

  public void save(Library library) {
    int libraryId = IDGenerator.nextLibraryId();
    library.setId(libraryId);
    libraries.add(library);
  }

  public void update(Library library) {
    int libraryIdx = libraries.indexOf(library);
    if (libraryIdx >= 0) {
      libraries.set(libraryIdx, library);
    }
  }

  public void delete(int libraryId) {
    Library library = this.getLibraryById(libraryId);
    libraries.remove(library);
  }

  public Library getLibraryById(int libraryId) {
    for (Library library : libraries) {
      if (library.getId() == libraryId) {
        return library;
      }
    }
    return null;
  }

  public List<Library> list() {
    return libraries;
  }
}
