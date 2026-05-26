package com.library.validators;

import com.library.entity.Book;
import com.library.exception.InvalidInputException;

public class BookValidators {
  public static void validate(Book book) throws InvalidInputException {
    if (book.getTitle() == null || book.getTitle().isEmpty()) {
      throw new InvalidInputException("Book Name is required.");
    }
  }
}
