package com.restaurant.code.init;

import com.restaurant.code.domain.*; 

import org.springframework.stereotype.Component;
import org.springframework.boot.CommandLineRunner;

import org.springframework.beans.factory.annotation.Autowired;

@Component
public class InitRestaurantDb implements CommandLineRunner {

	@Autowired 
	private RestaurantService restaurantService; 

	public void run(String[] args) {
		// All'avvio dell'applicazione aggiungo 4 ristoranti di prova
		restaurantService.createRestaurant( "Hostaria dell'Orso", "Roma" );	
		restaurantService.createRestaurant( "Baffetto", "Roma" );	
		restaurantService.createRestaurant( "L'Omo", "Roma" );	
		restaurantService.createRestaurant( "Seta", "Milano" );	
	}
	
}
