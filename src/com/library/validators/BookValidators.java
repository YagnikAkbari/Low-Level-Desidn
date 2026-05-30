package com.library.validators;

import java.time.Year;

import com.library.entity.Book;
import com.library.exception.InvalidInputException;

public class BookValidators {
  public static void validate(Book book) throws InvalidInputException {
    if (book.getTitle() == null || book.getTitle().isEmpty()) {
      throw new InvalidInputException("Book Name is required.");
    }
    if (book.getISBN() == null || book.getISBN().isEmpty()) {
      throw new InvalidInputException("ISBN is required.");
    }
    if (book.getAuthorId() <= 0) {
      throw new InvalidInputException("Author is required.");
    }
    if (book.getPublishedYear() != null && book.getPublishedYear().isAfter(Year.now())) {
      throw new InvalidInputException("Published year cannot be in the future.");
    }
  }
}
