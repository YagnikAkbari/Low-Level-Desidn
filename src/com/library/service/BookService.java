package com.library.service;

import java.util.List;

import com.library.entity.Book;
import com.library.enums.BookSearchField;
import com.library.exception.InvalidInputException;
import com.library.repository.BookRepository;
import com.library.validators.BookValidators;

public class BookService {
  private BookRepository bookRepo;

  public BookService() {
    this(new BookRepository());
  }

  public BookService(BookRepository bookRepo) {
    this.bookRepo = bookRepo;
  }

  public void addBook(Book book) {
    validateBook(book);
    bookRepo.save(book);
  }

  public void updateBook(Book book) {
    validateBook(book);
    ensureBookExists(book.getId());
    bookRepo.update(book);
  }

  public void removeBook(int bookId) {
    ensureBookExists(bookId);
    bookRepo.delete(bookId);
  }

  public Book getBookById(int bookId) {
    return bookRepo.getBookById(bookId)
        .orElseThrow(() -> new IllegalArgumentException("Book not found"));
  }

  public List<Book> searchBooks(String search) {
    return bookRepo.searchBooks(search);
  }

  public List<Book> searchBooks(String search, BookSearchField bookSearchField) {
    if (bookSearchField == null) {
      return bookRepo.searchBooks(search);
    }
    return bookRepo.searchBooks(search, bookSearchField);
  }

  public List<Book> listBook() {
    return bookRepo.list();
  }

  public List<Book> recommendBook(int authorId, int genreId, int categoryId) {
    return bookRepo.recommendBook(authorId, genreId, categoryId);
  }

  public boolean bookExists(int bookId) {
    return bookRepo.getBookById(bookId).isPresent();
  }

  private void validateBook(Book book) {
    try {
      BookValidators.validate(book);
    } catch (InvalidInputException exception) {
      throw new IllegalArgumentException(exception.getMessage(), exception);
    }
  }

  private void ensureBookExists(int bookId) {
    if (!bookExists(bookId)) {
      throw new IllegalArgumentException("Book not found");
    }
  }
}
