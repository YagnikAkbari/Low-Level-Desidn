package com.library.entity;

public class Author {
  private int id;
  private String name;

  public Author(String name) {
    this.name = name;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "{Id=" + this.id + "; Name=" + this.name + ";}";
  }
}
