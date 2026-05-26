package com.food_delivery.entity;

import com.food_delivery.enums.ItemEnum;

public class Item {
  private int id;
  private String name;
  private double price;
  private ItemEnum type;

  public Item(String name, double price) {
    this.name = name;
    this.price = price;
  }

  public double getPrice() {
    return this.price;
  }
}