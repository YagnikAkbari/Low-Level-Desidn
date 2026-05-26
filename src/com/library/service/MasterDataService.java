package com.library.service;

import com.library.entity.Category;
import com.library.entity.Genre;
import com.library.repository.MasterDataRpository;

public class MasterDataService {
  private MasterDataRpository masterDataRepo;

  public MasterDataService(MasterDataRpository masterDataRepo) {
    this.masterDataRepo = masterDataRepo;
  }

  public void addGenre(Genre genre) {
    masterDataRepo.saveGenre(genre);
  }

  public void updateGenre(Genre genre) {
    masterDataRepo.updateGenre(genre);
  }

  public void removeGenre(int genreId) {
    masterDataRepo.deleteGenre(genreId);
  }

  public void addCategory(Category category) {
    masterDataRepo.saveCategory(category);
  }

  public void updateCategory(Category category) {
    masterDataRepo.updateCategory(category);
  }

  public void removeCategory(int categoryId) {
    masterDataRepo.deleteCategory(categoryId);
  }
}