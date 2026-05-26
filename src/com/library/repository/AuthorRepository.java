package com.library.repository;

import java.util.List;

import com.library.entity.Author;
import com.library.utils.IDGenerator;

public class AuthorRepository {
  private static List<Author> authors;

  public void save(Author author) {
    int authorId = IDGenerator.nextAuthorId();
    author.setId(authorId);
    authors.add(author);
  }

  public void update(Author author) {
    int authorIdx = authors.indexOf(author);
    if (authorIdx >= 0) {
      authors.set(authorIdx, author);
    }
  }

  public void delete(int authorId) {
    Author author = this.getAuthorById(authorId);
    authors.remove(author);
  }

  public Author getAuthorById(int authorId) {
    for (Author author : authors) {
      if (author.getId() == authorId) {
        return author;
      }
    }
    return null;
  }

  public List<Author> list() {
    return authors;
  }
}
