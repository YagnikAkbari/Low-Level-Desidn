package com.library.validators;

import java.time.Year;
import java.util.List;

import com.library.entity.Book;
import com.library.exception.InvalidInputException;
import com.library.utils.InputValidator;

public class BookValidators {
  public static void validate(Book book) throws InvalidInputException {
    if (book == null) {
      throw new InvalidInputException("Book data is required.");
    }
    if (!InputValidator.validateString(book.getTitle(), 1, 255)) {
      throw new InvalidInputException("Book Name is required.");
    }
    if (!InputValidator.validateString(book.getISBN(), 1, 64)) {
      throw new InvalidInputException("ISBN is required.");
    }
    if (book.getAuthorId() <= 0) {
      throw new InvalidInputException("Author is required.");
    }
    if (book.getPublishedYear() != null && book.getPublishedYear().isAfter(Year.now())) {
      throw new InvalidInputException("Published year cannot be in the future.");
    }
    validateIds(book.getGenreIds(), "Genre");
    validateIds(book.getCategoryIds(), "Category");
  }

  private static void validateIds(List<Integer> ids, String label) throws InvalidInputException {
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
