package com.library.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.library.entity.Branch;
import com.library.entity.Library;
import com.library.utils.IDGenerator;

public class LibraryRepository {
  private static List<Library> libraries = new ArrayList<>();
  private static List<Branch> branches = new ArrayList<>();

  public int saveLibrary(Library library) {
    int libraryId = IDGenerator.nextLibraryId();
    library.setId(libraryId);
    libraries.add(library);
    return libraryId;
  }

  public void updateLibrary(Library library) {
    for (int i = 0; i < libraries.size(); i++) {
      if (libraries.get(i).getId() == library.getId()) {
        libraries.set(i, library);
        return;
      }
    }
  }

  public void deleteLibrary(int libraryId) {
    for (int i = 0; i < libraries.size(); i++) {
      if (libraries.get(i).getId() == libraryId) {
        libraries.remove(i);
        return;
      }
    }
  }

  public Optional<Library> getLibraryById(int libraryId) {
    for (Library library : libraries) {
      if (library.getId() == libraryId) {
        return Optional.ofNullable(library);
      }
    }
    return Optional.empty();
  }

  public List<Library> listLibrary() {
    return libraries;
  }

  public int saveBranch(Branch branch) {
    int branchId = IDGenerator.nextBranchId();
    branch.setId(branchId);
    branches.add(branch);
    return branchId;
  }

  public void updateBranch(Branch branch) {
    for (int i = 0; i < branches.size(); i++) {
      if (branches.get(i).getId() == branch.getId()) {
        branches.set(i, branch);
        return;
      }
    }
  }

  public void deleteBranch(int branchId) {
    for (int i = 0; i < branches.size(); i++) {
      if (branches.get(i).getId() == branchId) {
        branches.remove(i);
        return;
      }
    }
  }

  public Optional<Branch> getBranchById(int branchId) {
    for (Branch branch : branches) {
      if (branch.getId() == branchId) {
        return Optional.ofNullable(branch);
      }
    }
    return Optional.empty();
  }

  public List<Branch> listBranch() {
    return branches;
  }
}
