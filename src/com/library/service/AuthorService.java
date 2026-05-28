package com.library.service;

import com.library.entity.Author;
import com.library.repository.AuthorRepository;

public class AuthorService {
  private AuthorRepository authorRepo;

  public AuthorService(AuthorRepository authorRepo) {
    this.authorRepo = authorRepo;
  }

  public int addAuthor(Author author) {
    return authorRepo.save(author);
  }

  public void updateAuthor(Author author) {
    authorRepo.update(author);
  }

  public void removeAuthor(int authorId) {
    authorRepo.delete(authorId);
  }

  public Author getAuthorById(int authorId) {
    return authorRepo.getAuthorById(authorId).get();
  }
}