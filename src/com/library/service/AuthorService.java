package com.library.service;

import com.library.entity.Author;
import com.library.exception.InvalidInputException;
import com.library.repository.AuthorRepository;
import com.library.validators.LibraryValidators;

public class AuthorService {
  private AuthorRepository authorRepo;

  public AuthorService() {
    this(new AuthorRepository());
  }

  public AuthorService(AuthorRepository authorRepo) {
    this.authorRepo = authorRepo;
  }

  public int addAuthor(Author author) {
    validateAuthor(author);
    return authorRepo.save(author);
  }

  public void updateAuthor(Author author) {
    validateAuthor(author);
    ensureAuthorExists(author.getId());
    authorRepo.update(author);
  }

  public void removeAuthor(int authorId) {
    ensureAuthorExists(authorId);
    authorRepo.delete(authorId);
  }

  public Author getAuthorById(int authorId) {
    return authorRepo.getAuthorById(authorId)
        .orElseThrow(() -> new IllegalArgumentException("Author not found"));
  }

  public java.util.List<Author> listAuthor() {
    return authorRepo.list();
  }

  public boolean authorExists(int authorId) {
    return authorRepo.getAuthorById(authorId).isPresent();
  }

  private void validateAuthor(Author author) {
    try {
      LibraryValidators.validateAuthor(author);
    } catch (InvalidInputException exception) {
      throw new IllegalArgumentException(exception.getMessage(), exception);
    }
  }

  private void ensureAuthorExists(int authorId) {
    if (!authorExists(authorId)) {
      throw new IllegalArgumentException("Author not found");
    }
  }
}
