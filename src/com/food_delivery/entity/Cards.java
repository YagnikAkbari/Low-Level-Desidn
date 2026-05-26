package com.food_delivery.entity;

import com.food_delivery.util.IDGenerator;

public class Cards {
  private int id;
  private static String name = "CARDS";
  private String number;
  private String date;
  private int cvv;
  private double amount;

  public Cards(String number, String date, int cvv, double amount) {
    this.id = IDGenerator.getNextCardPaymentId();
    this.number = number;
    this.date = date;
    this.cvv = cvv;
    this.amount = amount;
  }

  public void displayPayment(int id) {
    System.out.println("Payment type:-" + name + "Amount:- " + this.amount);
  }

}