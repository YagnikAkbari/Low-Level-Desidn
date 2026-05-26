package com.library.entity;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class Book {
  private int id;
  // required
  private final String title;
  private final String ISBN;
  private Year publishedYear;
  private int authorId;
  private List<Integer> genreIds;
  private List<Integer> categoryIds;

  private Book(Builder b) {
    this.title = b.title;
    this.ISBN = b.ISBN;
    this.publishedYear = b.publishedYear;
    this.authorId = b.authorId;
    this.genreIds = b.genreIds;
    this.categoryIds = b.categoryIds;
  }

  @Override
  public String toString() {
    return "-------------Book------------" + "\n" +
        "Title = " + this.title + "\n" +
        "ISBN = " + this.ISBN + "\n" +
        "Published Year = " + this.publishedYear + "\n" +
        "Author = " + this.authorId + "\n" +
        "Genre = " + this.genreIds + "\n" +
        "Category = " + this.categoryIds + "\n";
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public String getISBN() {
    return ISBN;
  }

  public Year getPublishedYear() {
    return publishedYear;
  }

  public void setPublishedYear(Year publishedYear) {
    this.publishedYear = publishedYear;
  }

  public int getAuthorId() {
    return authorId;
  }

  public void setAuthorId(int authorId) {
    this.authorId = authorId;
  }

  public List<Integer> getGenreIds() {
    return genreIds;
  }

  public void setGenreIds(List<Integer> genreIds) {
    this.genreIds = genreIds;
  }

  public List<Integer> getCategoryIds() {
    return categoryIds;
  }

  public void setCategoryIds(List<Integer> categoryIds) {
    this.categoryIds = categoryIds;
  }

  public static class Builder {
    private int id;
    // required
    private final String title;
    private final String ISBN;
    private final int authorId;
    private Year publishedYear;
    private List<Integer> genreIds = new ArrayList<>();
    private List<Integer> categoryIds = new ArrayList<>();

    public Builder(String title, String ISBN, int authorId) {
      this.title = title;
      this.ISBN = ISBN;
      this.authorId = authorId;
    }

    public void setPublishedYear(Year year) {
      this.publishedYear = year;
    }

    public void setGenre(int genreId) {
      this.genreIds.add(genreId);
    }

    public void setCategory(int categoryId) {
      this.categoryIds.add(categoryId);
    }

    public Book build() {
      return new Book(this);
    }
  }

}