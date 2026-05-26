package com.library.repository;

import java.util.List;

import com.library.entity.Genre;
import com.library.entity.Category;
import com.library.utils.IDGenerator;

public class MasterDataRpository {
  private static List<Genre> genres;
  private static List<Category> categories;

  public void saveGenre(Genre genre) {
    int genreId = IDGenerator.nextGenreId();
    genre.setId(genreId);
    genres.add(genre);
  }

  public void updateGenre(Genre genre) {
    int bookIdx = genres.indexOf(genre);
    if (bookIdx >= 0) {
      genres.set(bookIdx, genre);
    }
  }

  public void deleteGenre(int genreId) {
    Genre genre = this.getGenreById(genreId);
    genres.remove(genre);
  }

  public Genre getGenreById(int genreId) {
    for (Genre genre : genres) {
      if (genre.getId() == genreId) {
        return genre;
      }
    }
    return null;
  }

  public List<Genre> listGenre() {
    return genres;
  }

  public void saveCategory(Category category) {
    int categoryId = IDGenerator.nextBookId();
    category.setId(categoryId);
    categories.add(category);
  }

  public void updateCategory(Category category) {
    int bookIdx = categories.indexOf(category);
    if (bookIdx >= 0) {
      categories.set(bookIdx, category);
    }
  }

  public void deleteCategory(int categoryId) {
    Category category = this.getCategoryById(categoryId);
    categories.remove(category);
  }

  public Category getCategoryById(int categoryId) {
    for (Category category : categories) {
      if (category.getId() == categoryId) {
        return category;
      }
    }
    return null;
  }

  public List<Category> listCategory() {
    return categories;
  }
}