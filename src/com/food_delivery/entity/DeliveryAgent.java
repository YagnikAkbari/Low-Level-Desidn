package com.food_delivery.entity;

import java.util.ArrayList;

public class DeliveryAgent extends Person {
  private ArrayList<Integer> orders;

  public DeliveryAgent(String name) {
    super(name);
  }

  public void assignOrder(int id) {
    this.orders.add(id);
  }

}