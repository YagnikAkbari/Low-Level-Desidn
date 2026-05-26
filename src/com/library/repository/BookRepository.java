package com.library.repository;

import java.util.List;
import com.library.entity.Book;
import com.library.utils.IDGenerator;

public class BookRepository {

  private static List<Book> books;

  public void save(Book book) {
    int bookId = IDGenerator.nextBookId();
    book.setId(bookId);
    books.add(book);
  }

  public void update(Book book) {
    int bookIdx = books.indexOf(book);
    if (bookIdx >= 0) {
      books.set(bookIdx, book);
    }
  }

  public void delete(int bookId) {
    Book book = this.getBookById(bookId);
    books.remove(book);
  }

  public Book getBookById(int bookId) {
    for (Book book : books) {
      if (book.getId() == bookId) {
        return book;
      }
    }
    return null;
  }

  public List<Book> list() {
    return books;
  }
}
