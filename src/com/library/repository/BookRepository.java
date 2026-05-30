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
    for (int i = 0; i < books.size(); i++) {
      if (books.get(i).getId() == book.getId()) {
        books.set(i, book);
        return;
      }
    }
  }

  public void delete(int bookId) {
    for (int i = 0; i < books.size(); i++) {
      if (books.get(i).getId() == bookId) {
        books.remove(i);
        return;
      }
    }
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
      if (book.getISBN() != null && book.getISBN().toLowerCase().contains(search.toLowerCase())) {
        results.add(book);
      }
    }
    return results;
  }

  public List<Book> searchBookByAuthor(String search) {
    List<Book> results = new ArrayList<>();
    if (search == null) {
      return results;
    }
    int authorId;
    try {
      authorId = Integer.parseInt(search.trim());
    } catch (NumberFormatException exception) {
      return results;
    }
    for (Book book : books) {
      if (book.getAuthorId() == authorId) {
        results.add(book);
      }
    }
    return results;
  }

  public List<Book> searchBooks(String search, BookSearchField bookSearchField) {
    switch (bookSearchField) {
      case ISBN:
        return searchBookByISBN(search);
      case AUTHOR:
        return searchBookByAuthor(search);
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

  public List<Book> recommendBook(int authorId, int genreId, int categoryId) {
    List<Book> recommendations = new ArrayList<>();
    for (Book book : books) {
      boolean authorMatch = authorId <= 0 || book.getAuthorId() == authorId;
      boolean genreMatch = genreId <= 0 || (book.getGenreIds() != null && book.getGenreIds().contains(genreId));
      boolean categoryMatch = categoryId <= 0
          || (book.getCategoryIds() != null && book.getCategoryIds().contains(categoryId));
      if (authorMatch && (genreMatch || categoryMatch)) {
        recommendations.add(book);
      }
    }
    return recommendations;
  }
}
