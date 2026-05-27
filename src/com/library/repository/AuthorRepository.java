package com.library.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.library.entity.Author;
import com.library.utils.IDGenerator;

public class AuthorRepository {
  private static List<Author> authors = new ArrayList<>();

  public int save(Author author) {
    int authorId = IDGenerator.nextAuthorId();
    author.setId(authorId);
    authors.add(author);
    return authorId;
  }

  public void update(Author author) {
    int authorIdx = authors.indexOf(author);
    if (authorIdx >= 0) {
      authors.set(authorIdx, author);
    }
  }

  public void delete(int authorId) {
    Author author = this.getAuthorById(authorId).get();
    if (author == null) {
      return;
    }
    authors.remove(author);
  }

  public Optional<Author> getAuthorById(int authorId) {
    for (Author author : authors) {
      if (author.getId() == authorId) {
        return Optional.ofNullable(author);
      }
    }
    return Optional.empty();
  }

  public List<Author> list() {
    return authors;
  }
}
