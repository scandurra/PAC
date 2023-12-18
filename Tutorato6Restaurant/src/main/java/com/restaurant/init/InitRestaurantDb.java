package com.restaurant.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.restaurant.domain.Restaurant;
import com.restaurant.domain.RestaurantService;

@Component
public class InitRestaurantDb implements CommandLineRunner {
  @Autowired
  private RestaurantService service;
  
	@Override
	public void run(String... args) throws Exception {
		service.createRestaurant("L'Anonimo", "Dalmine");
		service.createRestaurant("Osteria dell'Oste", "Roma");

		Restaurant r = service.getRestaurant(1);
		System.out.println(r);
	}
}
