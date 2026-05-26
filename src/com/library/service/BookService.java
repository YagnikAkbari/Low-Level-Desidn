package com.library.service;

import com.library.entity.Book;
import com.library.repository.BookRepository;

public class BookService {
  private BookRepository bookRepo;

  public BookService(BookRepository bookRepo) {
    this.bookRepo = bookRepo;
  }

  public void addBook(Book book) {
    bookRepo.save(book);
  }

  public void updateBook(Book book) {
    bookRepo.update(book);
  }

  public void removeBook(int bookId) {
    bookRepo.delete(bookId);
  }
}