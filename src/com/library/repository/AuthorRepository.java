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
    for (int i = 0; i < authors.size(); i++) {
      if (authors.get(i).getId() == author.getId()) {
        authors.set(i, author);
        return;
      }
    }
  }

  public void delete(int authorId) {
    for (int i = 0; i < authors.size(); i++) {
      if (authors.get(i).getId() == authorId) {
        authors.remove(i);
        return;
      }
    }
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
