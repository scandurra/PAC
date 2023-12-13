package com.restaurant.domain;

import org.springframework.stereotype.Service;

@Service
public class RestaurantService {
  private RestaurantRepository repo = new RestaurantRepository();

  public Restaurant createRestaurant(String name, String location) {
    // TODO: unimplemented
  }

  public Restaurant getRestaurant(long id) {
    // TODO: unimplemented
  }

  public Restaurant getRestaurantByName(String name) {
    // TODO: Unimplemented
  }
}
