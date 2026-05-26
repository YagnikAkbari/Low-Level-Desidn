package com.food_delivery.service;

import com.food_delivery.entity.Item;
import com.food_delivery.entity.Menu;
import com.food_delivery.enums.MenuTypeEnum;

public class RestaurantService {

  public void createMenu(String name, MenuTypeEnum type) {
    new Menu(name, type);
  }

  public void addMenuItem(int menuId, Item item) throws Exception {
    if (item.getPrice() < 0) {
      throw new Exception("Price Must be positive");
    }
  }
}