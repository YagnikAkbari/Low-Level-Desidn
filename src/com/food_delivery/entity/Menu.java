package com.food_delivery.entity;

import java.util.ArrayList;
import java.util.List;

import com.food_delivery.enums.MenuTypeEnum;

public class Menu {
  private int id;
  private String name;
  private MenuTypeEnum type;
  private List<Item> items;

  public Menu(String name, MenuTypeEnum type) {
    this.name = name;
    this.type = type;
  }

  public Menu(String name, MenuTypeEnum type, ArrayList<Item> items) {
    this.name = name;
    this.type = type;
    this.items = items;
  }

}