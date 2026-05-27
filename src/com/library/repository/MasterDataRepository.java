package com.library.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.library.entity.Genre;
import com.library.entity.Category;
import com.library.utils.IDGenerator;

public class MasterDataRepository {
  private static List<Genre> genres = new ArrayList<>();
  private static List<Category> categories = new ArrayList<>();

  public int saveGenre(Genre genre) {
    int genreId = IDGenerator.nextGenreId();
    genre.setId(genreId);
    genres.add(genre);
    return genreId;
  }

  public void updateGenre(Genre genre) {
    int genreIdx = genres.indexOf(genre);
    if (genreIdx >= 0) {
      genres.set(genreIdx, genre);
    }
  }

  public void deleteGenre(int genreId) {
    Genre genre = this.getGenreById(genreId).get();
    if (genre == null) {
      return;
    }
    genres.remove(genre);
  }

  public Optional<Genre> getGenreById(int genreId) {
    for (Genre genre : genres) {
      if (genre.getId() == genreId) {
        return Optional.ofNullable(genre);
      }
    }
    return Optional.empty();
  }

  public List<Genre> listGenre() {
    return genres;
  }

  public List<Genre> listGenre(int[] genreIds) {
    List<Genre> genreList = new ArrayList<>();
    for (int genreId : genreIds) {
      genreList.add(this.getGenreById(genreId).get());
    }
    return genreList;
  }

  public int saveCategory(Category category) {
    int categoryId = IDGenerator.nextCategoryId();
    category.setId(categoryId);
    categories.add(category);
    return categoryId;
  }

  public void updateCategory(Category category) {
    int cateogyIdx = categories.indexOf(category);
    if (cateogyIdx >= 0) {
      categories.set(cateogyIdx, category);
    }
  }

  public void deleteCategory(int categoryId) {
    Category category = this.getCategoryById(categoryId).get();
    if (category == null) {
      return;
    }
    categories.remove(category);
  }

  public Optional<Category> getCategoryById(int categoryId) {
    for (Category category : categories) {
      if (category.getId() == categoryId) {
        return Optional.ofNullable(category);
      }
    }
    return Optional.empty();
  }

  public List<Category> listCategory() {
    return categories;
  }
}