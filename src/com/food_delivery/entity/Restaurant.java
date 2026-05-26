package com.food_delivery.entity;

import java.util.ArrayList;
import java.util.List;

import com.food_delivery.util.IDGenerator;

public class Restaurant {
  private int id;
  private String name;
  private List<Menu> menu;
  private List<Order> orders;

  public Restaurant(String name) {
    this.id = IDGenerator.getNextRestaurantId();
    this.name = name;
  }

  public Restaurant(String name, ArrayList<Menu> menu) {
    this.name = name;
    this.menu = menu;
  }

}