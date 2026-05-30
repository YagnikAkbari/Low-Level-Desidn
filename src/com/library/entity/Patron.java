package com.library.entity;

public class Patron {
  private int id;
  private String name;
  private String email;
  private String mobile_no;

  public Patron(String name, String mobile_no, String email) {
    this.name = name;
    this.mobile_no = mobile_no;
    this.email = email;
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

  @Override
  public String toString() {
    return "{Id=" + this.id + "; Name=" + this.name + "; Email=" + this.email + "; Mobile=" + this.mobile_no + ";}";
  }
}
