package com.restaurant.domain;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class RestaurantService {
  private RestaurantRepository repo = new RestaurantRepository();

  public Restaurant createRestaurant(String name, String location) {
    Restaurant r = new Restaurant(name, location);
    return repo.save(r);
  }

  public List<Restaurant> getAllRestaurants() {
    return repo.getAll();
  }

  public Restaurant getRestaurant(long id) {
    Restaurant r = repo.findById(id);
    return r;
  }

  public Restaurant getRestaurantByName(String name) {
    Restaurant r = repo.findByName(name);
    return r;
  }

  public Restaurant deleteRestaurantByName(String name) {
    System.out.println("Deleting restaurant " + name);
    Restaurant r = repo.deleteRestaurant(name);
    System.out.println("done");
    return r;
  }
}
