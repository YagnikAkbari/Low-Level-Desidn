package com.library.entity;

public class Branch {
  private int id;
  private String name;
  private String location;
  private int libraryId;

  public Branch(String name, String location, int libraryId) {
    this.name = name;
    this.location = location;
    this.libraryId = libraryId;
  }

  public Branch(String name, int libraryId) {
    this.name = name;
    this.libraryId = libraryId;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getLibraryId() {
    return libraryId;
  }

  public void setLibraryId(int libraryId) {
    this.libraryId = libraryId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }
}
