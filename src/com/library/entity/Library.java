package com.library.entity;

public class Library {
  private int id;
  private String name;

  public Library(String name, String location) {
    this.name = name;
  }

  public Library(String name) {
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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
