package com.library.seeder;

import java.util.List;
import java.util.Random;

import com.library.entity.Branch;
import com.library.entity.Library;
import com.library.service.LibraryService;

public class SeedLibrary {
  private static final List<String> BRANCH_CITIES = List.of(
      "Seattle",
      "Vancouver",
      "Chicago",
      "Austin",
      "Boston",
      "Denver",
      "Portland",
      "San Diego",
      "Atlanta",
      "Phoenix");

  public static void seed(LibraryService libraryService) {
    Random random = new Random();

    for (int i = 1; i <= 10; i++) {
      Library library = new Library("Library " + i);
      int libraryId = libraryService.addLibrary(library);
      int branchCount = random.nextInt(3) + 1;

      for (int branchIndex = 1; branchIndex <= branchCount; branchIndex++) {
        String city = BRANCH_CITIES.get(random.nextInt(BRANCH_CITIES.size()));
        Branch branch = new Branch(
            "Library " + i + " Branch " + branchIndex,
            city,
            libraryId);
        libraryService.addBranch(branch);
      }
    }
  }
}
