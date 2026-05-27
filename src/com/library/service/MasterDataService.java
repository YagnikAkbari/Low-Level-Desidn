package com.library.service;

import com.library.entity.Category;
import com.library.entity.Genre;
import com.library.repository.MasterDataRepository;

public class MasterDataService {
  private MasterDataRepository masterDataRepo;

  public MasterDataService(MasterDataRepository masterDataRepo) {
    this.masterDataRepo = masterDataRepo;
  }

  public int addGenre(Genre genre) {
    return masterDataRepo.saveGenre(genre);
  }

  public void updateGenre(Genre genre) {
    masterDataRepo.updateGenre(genre);
  }

  public void removeGenre(int genreId) {
    masterDataRepo.deleteGenre(genreId);
  }

  public int addCategory(Category category) {
    return masterDataRepo.saveCategory(category);
  }

  public void updateCategory(Category category) {
    masterDataRepo.updateCategory(category);
  }

  public void removeCategory(int categoryId) {
    masterDataRepo.deleteCategory(categoryId);
  }
}