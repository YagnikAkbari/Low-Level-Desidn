package com.food_delivery.entity;

import java.util.ArrayList;
import java.util.List;

import com.food_delivery.enums.OrderStatusEnum;
import com.food_delivery.util.IDGenerator;

public class Order {
  private int id;
  private OrderStatusEnum status;
  private List<OrderItem> items;
  private List<Payment> payments;

  public Order(ArrayList<OrderItem> items) {
    this.id = IDGenerator.getNextOrderId();
    this.items = items;
    this.status = OrderStatusEnum.PLACED;
    this.payments = new ArrayList<>();
  }

  public void updateOrderStatus(OrderStatusEnum status) {
    this.status = status;
  }

  public void addPayment(Payment payment) {
    this.payments.add(payment);
  }

  public void addMultiplePayment(List<Payment> payments) {
    this.payments.addAll(payments);
  }
}