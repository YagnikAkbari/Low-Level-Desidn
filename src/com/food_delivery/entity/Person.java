package com.food_delivery.entity;

import com.food_delivery.util.IDGenerator;

public class Person {
  private int id;
  private String name;

  public Person(String name) {
    this.id = IDGenerator.getNextPersonId();
    this.name = name;
  }

  public String getName() {
    return this.name;
  }
}