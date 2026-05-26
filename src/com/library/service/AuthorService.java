package com.library.service;

import com.library.entity.Author;
import com.library.repository.AuthorRepository;

public class AuthorService {
  private AuthorRepository authorRepo;

  public AuthorService(AuthorRepository authorRepo) {
    this.authorRepo = authorRepo;
  }

  public void addAuthor(Author author) {
    authorRepo.save(author);
  }

  public void updateAuthor(Author author) {
    authorRepo.update(author);
  }

  public void removeAuthor(int bookId) {
    authorRepo.delete(bookId);
  }
}