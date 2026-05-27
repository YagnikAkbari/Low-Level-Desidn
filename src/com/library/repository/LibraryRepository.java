package com.library.repository;

import java.util.ArrayList;
import java.util.List;

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
    int libraryIdx = libraries.indexOf(library);
    if (libraryIdx >= 0) {
      libraries.set(libraryIdx, library);
    }
  }

  public void deleteLibrary(int libraryId) {
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
    int branchIdx = branches.indexOf(branch);
    if (branchIdx >= 0) {
      branches.set(branchIdx, branch);
    }
  }

  public void deleteBranch(int branchId) {
    Branch branch = this.getBranchById(branchId);
    branches.remove(branch);
  }

  public Branch getBranchById(int branchId) {
    for (Branch branch : branches) {
      if (branch.getId() == branchId) {
        return branch;
      }
    }
    return null;
  }

  public List<Branch> listBranch() {
    return branches;
  }
}
