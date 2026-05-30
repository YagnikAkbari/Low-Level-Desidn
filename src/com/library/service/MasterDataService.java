package com.library.service;

import java.util.List;

import com.library.entity.Category;
import com.library.entity.Genre;
import com.library.exception.InvalidInputException;
import com.library.repository.MasterDataRepository;
import com.library.validators.LibraryValidators;

public class MasterDataService {
  private MasterDataRepository masterDataRepo;

  public MasterDataService(MasterDataRepository masterDataRepo) {
    this.masterDataRepo = masterDataRepo;
  }

  public int addGenre(Genre genre) {
    validateGenre(genre);
    return masterDataRepo.saveGenre(genre);
  }

  public void updateGenre(Genre genre) {
    validateGenre(genre);
    ensureGenreExists(genre.getId());
    masterDataRepo.updateGenre(genre);
  }

  public List<Genre> listGenre() {
    return masterDataRepo.listGenre();
  }

  public void removeGenre(int genreId) {
    ensureGenreExists(genreId);
    masterDataRepo.deleteGenre(genreId);
  }

  public int addCategory(Category category) {
    validateCategory(category);
    return masterDataRepo.saveCategory(category);
  }

  public void updateCategory(Category category) {
    validateCategory(category);
    ensureCategoryExists(category.getId());
    masterDataRepo.updateCategory(category);
  }

  public void removeCategory(int categoryId) {
    ensureCategoryExists(categoryId);
    masterDataRepo.deleteCategory(categoryId);
  }

  public List<Category> listCategory() {
    return masterDataRepo.listCategory();
  }

  public Genre getGenreById(int genreId) {
    return masterDataRepo.getGenreById(genreId)
        .orElseThrow(() -> new IllegalArgumentException("Genre not found"));
  }

  public Category getCategoryById(int categoryId) {
    return masterDataRepo.getCategoryById(categoryId)
        .orElseThrow(() -> new IllegalArgumentException("Category not found"));
  }

  public boolean genreExists(int genreId) {
    return masterDataRepo.getGenreById(genreId).isPresent();
  }

  public boolean categoryExists(int categoryId) {
    return masterDataRepo.getCategoryById(categoryId).isPresent();
  }

  private void validateGenre(Genre genre) {
    try {
      LibraryValidators.validateGenre(genre);
    } catch (InvalidInputException exception) {
      throw new IllegalArgumentException(exception.getMessage(), exception);
    }
  }

  private void validateCategory(Category category) {
    try {
      LibraryValidators.validateCategory(category);
    } catch (InvalidInputException exception) {
      throw new IllegalArgumentException(exception.getMessage(), exception);
    }
  }

  private void ensureGenreExists(int genreId) {
    if (!genreExists(genreId)) {
      throw new IllegalArgumentException("Genre not found");
    }
  }

  private void ensureCategoryExists(int categoryId) {
    if (!categoryExists(categoryId)) {
      throw new IllegalArgumentException("Category not found");
    }
  }
}
