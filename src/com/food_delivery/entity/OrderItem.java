package com.food_delivery.entity;

public class OrderItem {
  private int id;
  private int menu_item_id;
  private int quantity;

  public OrderItem(int menu_item_id, int quantity) {
    this.menu_item_id = menu_item_id;
    this.quantity = quantity;
  }
}
