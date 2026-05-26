package com.food_delivery.util;

public class IDGenerator {
  private static int personId = 0;
  private static int restaurantId = 0;
  private static int orderId = 0;
  private static int cardPaymentId = 0;
  private static int upiPaymentId = 0;

  public static int getNextPersonId() {
    return ++personId;
  }

  public static int getNextRestaurantId() {
    return ++restaurantId;
  }

  public static int getNextOrderId() {
    return ++orderId;
  }

  public static int getNextCardPaymentId() {
    return ++cardPaymentId;
  }

  public static int getNextUPIPaymentId() {
    return ++upiPaymentId;
  }
}
