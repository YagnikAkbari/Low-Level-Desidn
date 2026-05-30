package com.library.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.library.entity.Book;
import com.library.enums.BookSearchField;
import com.library.utils.IDGenerator;

public class BookRepository {

  private static List<Book> books = new ArrayList<>();

  public int save(Book book) {
    int bookId = IDGenerator.nextBookId();
    book.setId(bookId);
    books.add(book);
    return bookId;
  }

  public void update(Book book) {
    int bookIdx = books.indexOf(book);
    if (bookIdx >= 0) {
      books.set(bookIdx, book);
    }
  }

  public void delete(int bookId) {
    Book book = this.getBookById(bookId).get();
    if (book == null) {
      return;
    }
    books.remove(book);
  }

  public Optional<Book> getBookById(int bookId) {
    for (Book book : books) {
      if (book.getId() == bookId) {
        return Optional.ofNullable(book);
      }
    }
    return Optional.empty();
  }

  public List<Book> searchBookByTitle(String search) {
    List<Book> results = new ArrayList<>();
    if (search == null) {
      return results;
    }
    for (Book book : books) {
      if (book.getTitle() != null && book.getTitle().toLowerCase().contains(search.toLowerCase())) {
        results.add(book);
      }
    }
    return results;
  }

  public List<Book> searchBookByISBN(String search) {
    List<Book> results = new ArrayList<>();
    if (search == null) {
      return results;
    }
    for (Book book : books) {
      if (book.getISBN() != null && book.getTitle().toLowerCase().contains(search.toLowerCase())) {
        results.add(book);
      }
    }
    return results;
  }

  public List<Book> searchBooks(String search, BookSearchField bookSearchField) {
    switch (bookSearchField) {
      case ISBN:
        return searchBookByISBN(search);
      default:
        return searchBookByTitle(search);
    }
  }

  public List<Book> searchBooks(String search) {
    return searchBookByTitle(search);
  }

  public List<Book> list() {
    return books;
  }
}
