package com.library;

import com.library.entity.Author;
import com.library.entity.Book;
import com.library.entity.Genre;
import com.library.repository.AuthorRepository;
import com.library.repository.BookRepository;
import com.library.repository.MasterDataRepository;
import com.library.service.AuthorService;
import com.library.service.BookService;
import com.library.service.MasterDataService;

public class App {
  public static void run() {
    AuthorRepository authorRepo = new AuthorRepository();
    AuthorService authorService = new AuthorService(authorRepo);
    MasterDataRepository masterDataRepo = new MasterDataRepository();
    MasterDataService masterDataService = new MasterDataService(masterDataRepo);
    BookRepository bookRepo = new BookRepository();
    BookService bookService = new BookService(bookRepo);

    Author author = new Author("Yagnik Akbari");
    int authorId = authorService.addAuthor(author);
    Genre genre = new Genre("Sci-fi");
    int genreId = masterDataService.addGenre(genre);
    Book.Builder bookBuilder = new Book.Builder("Python for beginner.", "ISDN001", authorId);
    bookBuilder.setGenre(genreId);
    Book book = bookBuilder.build();
    bookService.addBook(book);
    for (Book boook : bookService.listBook()) {
      System.out.println(boook);
    }
  }

  public static void main(String[] args) {
    run();
  }
}