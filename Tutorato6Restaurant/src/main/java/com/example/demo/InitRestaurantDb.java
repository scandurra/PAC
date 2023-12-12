package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitRestaurantDb implements CommandLineRunner {
  @Autowired
  private RestaurantService restaurantService;
  
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	}
}
