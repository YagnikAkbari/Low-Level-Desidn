package com.library.validators;

import java.util.List;

import com.library.entity.Author;
import com.library.entity.Branch;
import com.library.entity.Category;
import com.library.entity.Genre;
import com.library.entity.Library;
import com.library.entity.LibraryBook;
import com.library.entity.Patron;
import com.library.entity.Reservation;
import com.library.exception.InvalidInputException;
import com.library.utils.InputValidator;

public final class LibraryValidators {
  private LibraryValidators() {
  }

  public static void validateAuthor(Author author) throws InvalidInputException {
    if (author == null) {
      throw new InvalidInputException("Author data is required.");
    }
    if (!InputValidator.validateString(author.getName(), 1, 255)) {
      throw new InvalidInputException("Author name is required.");
    }
  }

  public static void validateGenre(Genre genre) throws InvalidInputException {
    if (genre == null) {
      throw new InvalidInputException("Genre data is required.");
    }
    if (!InputValidator.validateString(genre.getName(), 1, 255)) {
      throw new InvalidInputException("Genre name is required.");
    }
  }

  public static void validateCategory(Category category) throws InvalidInputException {
    if (category == null) {
      throw new InvalidInputException("Category data is required.");
    }
    if (!InputValidator.validateString(category.getName(), 1, 255)) {
      throw new InvalidInputException("Category name is required.");
    }
  }

  public static void validateLibrary(Library library) throws InvalidInputException {
    if (library == null) {
      throw new InvalidInputException("Library data is required.");
    }
    if (!InputValidator.validateString(library.getName(), 1, 255)) {
      throw new InvalidInputException("Library name is required.");
    }
  }

  public static void validateBranch(Branch branch) throws InvalidInputException {
    if (branch == null) {
      throw new InvalidInputException("Branch data is required.");
    }
    if (!InputValidator.validateString(branch.getName(), 1, 255)) {
      throw new InvalidInputException("Branch name is required.");
    }
    if (!InputValidator.validateString(branch.getLocation(), 1, 255)) {
      throw new InvalidInputException("Branch location is required.");
    }
    if (branch.getLibraryId() <= 0) {
      throw new InvalidInputException("Valid library id is required.");
    }
  }

  public static void validatePatron(Patron patron) throws InvalidInputException {
    if (patron == null) {
      throw new InvalidInputException("Patron data is required.");
    }
    if (!InputValidator.validateString(patron.getName(), 1, 255)) {
      throw new InvalidInputException("Patron name is required.");
    }
    if (!InputValidator.validateEmail(patron.getEmail())) {
      throw new InvalidInputException("A valid email is required.");
    }
    if (!InputValidator.validateMobile(patron.getMobile_no())) {
      throw new InvalidInputException("A valid 10 digit mobile number is required.");
    }
  }

  public static void validateLibraryBook(LibraryBook libraryBook) throws InvalidInputException {
    if (libraryBook == null) {
      throw new InvalidInputException("Inventory data is required.");
    }
    if (libraryBook.getBranchId() <= 0) {
      throw new InvalidInputException("Valid branch id is required.");
    }
    if (libraryBook.getBookId() <= 0) {
      throw new InvalidInputException("Valid book id is required.");
    }
    if (libraryBook.getTotalCopies() < 0) {
      throw new InvalidInputException("Total copies cannot be negative.");
    }
  }

  public static void validateCopies(int copies) throws InvalidInputException {
    if (copies <= 0) {
      throw new InvalidInputException("Copies must be greater than 0.");
    }
  }

  public static void validateReservation(Reservation reservation) throws InvalidInputException {
    if (reservation == null) {
      throw new InvalidInputException("Reservation data is required.");
    }
    if (reservation.getBranchId() <= 0) {
      throw new InvalidInputException("Valid branch id is required.");
    }
    if (reservation.getBookId() <= 0) {
      throw new InvalidInputException("Valid book id is required.");
    }
    if (reservation.getPatronId() <= 0) {
      throw new InvalidInputException("Valid patron id is required.");
    }
  }

  public static void validateIds(List<Integer> ids, String label) throws InvalidInputException {
    if (ids == null) {
      throw new InvalidInputException(label + " list is required.");
    }
    for (Integer id : ids) {
      if (id == null || id.intValue() <= 0) {
        throw new InvalidInputException(label + " ids must be positive.");
      }
    }
  }
}
