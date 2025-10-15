package com.restaurant.code.init;

import com.restaurant.code.domain.*; 

import org.springframework.stereotype.Component;
import org.springframework.boot.CommandLineRunner;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

@Component
public class InitRestaurantDb implements CommandLineRunner {

	@Autowired 
	private RestaurantService restaurantService; 
	@Autowired
	private MenuService menuService; 

	public void run(String[] args) {
		// All'avvio dell'applicazione aggiungo 4 ristoranti di prova
		restaurantService.createRestaurant( "Hostaria dell'Orso", "Roma" );	
		restaurantService.createRestaurant( "Baffetto", "Roma" );	
		restaurantService.createRestaurant( "L'Omo", "Roma" );	
		Restaurant restaurant = restaurantService.createRestaurant( "Seta", "Milano" );	
		// Per uno dei ristoranti definisco anche un menù
		ArrayList<Piatto> listaPiatti = new ArrayList<>();
		listaPiatti.add(new Piatto("Pasta al sugo", 10));
		listaPiatti.add(new Piatto("Cotoletta alla milanese", 13));
		listaPiatti.add(new Piatto("Acqua 0.5L", 2));
		menuService.createMenu(restaurant, listaPiatti);
	}
	
}
