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
    for (int i = 0; i < genres.size(); i++) {
      if (genres.get(i).getId() == genre.getId()) {
        genres.set(i, genre);
        return;
      }
    }
  }

  public void deleteGenre(int genreId) {
    for (int i = 0; i < genres.size(); i++) {
      if (genres.get(i).getId() == genreId) {
        genres.remove(i);
        return;
      }
    }
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
      Optional<Genre> genre = this.getGenreById(genreId);
      genre.ifPresent(genreList::add);
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
    for (int i = 0; i < categories.size(); i++) {
      if (categories.get(i).getId() == category.getId()) {
        categories.set(i, category);
        return;
      }
    }
  }

  public void deleteCategory(int categoryId) {
    for (int i = 0; i < categories.size(); i++) {
      if (categories.get(i).getId() == categoryId) {
        categories.remove(i);
        return;
      }
    }
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
