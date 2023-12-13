package com.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestaurantWebController {
  @Autowired
  private RestaurantService service;

  // TODO: Implement GET /restaurants/{id} using @GetMapping and @PathVariable

  // TODO: Implement POST /restaurants to add a Restaurant using @PostMapping and @RequestParam with default value
}
