package com.library.service;

import java.util.List;

import com.library.entity.Book;
import com.library.enums.BookSearchField;
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
    try {
      BookValidators.validate(book);
    } catch (Exception exception) {
      throw new IllegalArgumentException(exception.getMessage(), exception);
    }
    bookRepo.save(book);
  }

  public void updateBook(Book book) {
    try {
      BookValidators.validate(book);
    } catch (Exception exception) {
      throw new IllegalArgumentException(exception.getMessage(), exception);
    }
    if (bookRepo.getBookById(book.getId()).isEmpty()) {
      throw new IllegalArgumentException("Book not found");
    }
    bookRepo.update(book);
  }

  public void removeBook(int bookId) {
    if (bookRepo.getBookById(bookId).isEmpty()) {
      throw new IllegalArgumentException("Book not found");
    }
    bookRepo.delete(bookId);
  }

  public Book getBookById(int bookId) {
    return bookRepo.getBookById(bookId).get();
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
}
