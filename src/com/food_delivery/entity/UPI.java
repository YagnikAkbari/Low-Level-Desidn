package com.food_delivery.entity;

import com.food_delivery.util.IDGenerator;

public class UPI implements Payment {
  private int id;
  private static String name = "UPI";
  private String upi;
  private double amount;

  public UPI(String upi, double amount) {
    this.id = IDGenerator.getNextUPIPaymentId();
    this.amount = amount;
  }

  public void displayPayment(int id) {
    System.out.println("Payment type:-" + name + "Amount:- " + this.amount);
  }

}