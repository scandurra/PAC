package com.restaurant.domain;

import java.util.ArrayList;

public class RestaurantRepository {
  ArrayList<Restaurant> data = new ArrayList<Restaurant>();

  public Restaurant save(Restaurant r) {
    data.add(r);
    return r;
  }

  public ArrayList<Restaurant> getAll() {
    return data;
  }

  public Restaurant deleteRestaurant(String n) {
    System.out.println(data.size());
    for (int i = 0; i < data.size(); i++) {
      if (data.get(i).getName().equals(n)) {
        Restaurant r = data.get(i);
        System.out.println("Deleting restaurant " + r.getName());
        data.remove(i);
        return r;
      }
    }
    return null;
  }

  public Restaurant findByName(String n) {
    for (Restaurant r : data) {
      if (r.getName().equals(n))
        return r;
    }
    return null;
  }

  public Restaurant findById(long id) {
    for (Restaurant r : data) {
      if (r.getId() == id)
        return r;
    }
    return null;
  }
}
