package com.library.entity;

public class Library {
  private int id;
  private String name;
  private String location;

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

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public Library(String name, String location) {
    this.name = name;
    this.location = location;
  }

  public Library(String name) {
    this.name = name;
  }

  public static class Patron {
    private int id;
    private String name;
    private String email;
    private String mobile_no;

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

    public String getEmail() {
      return email;
    }

    public void setEmail(String email) {
      this.email = email;
    }

    public String getMobile_no() {
      return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
      this.mobile_no = mobile_no;
    }
  }
}
