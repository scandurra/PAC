package com.restaurant.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.domain.Restaurant;
import com.restaurant.domain.RestaurantService;

@RestController
public class RestaurantWebController {
  @Autowired
  private RestaurantService service;

  @GetMapping("/restaurants/{restaurantId}")
  public Restaurant getRestaurant(@PathVariable long restaurantId) {
    Restaurant r = service.getRestaurant(restaurantId);
    return r;
  }

  @GetMapping("/restaurants")
  public List<Restaurant> getAllRestaurants() {
    return service.getAllRestaurants();
  }

  @PostMapping("/restaurants")
  public Restaurant addRestaurant(@RequestParam(defaultValue="", name="name") String restaurantName, @RequestParam String location) {
    return service.createRestaurant(restaurantName, location);
  }

  @DeleteMapping("/restaurant/{name}")
  public Restaurant deleteRestaurant(@PathVariable String name) {
    Restaurant r = service.deleteRestaurantByName(name);
    return r;
  }
}
