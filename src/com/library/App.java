package com.library;

import com.library.entity.Book;
import com.library.repository.BookRepository;
import com.library.service.BookService;

public class App {
  public static void run() {
    BookRepository bookRepo = new BookRepository();
    BookService bookService = new BookService(bookRepo);

    Book.Builder book = new Book.Builder("Python for beginner.", "ISDN001", 1);
    book.setGenre(0);
  }

  public static void main(String[] args) {
    run();
  }
}