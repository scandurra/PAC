package com.restaurant.code.domain;

import java.util.Collection;

import org.springframework.stereotype.Service; 

@Service
public class RestaurantService {

	private RestaurantRepository restaurantRepository = new RestaurantRepository();

	// Metodo del servizio per la creazione di un ristorante
 	public Restaurant createRestaurant(String name, String location) {
		Restaurant restaurant = new Restaurant(name, location); 
		restaurant = restaurantRepository.save(restaurant);
		return restaurant;
	}

 	// Metodo del servizio per la ricerca di un ristorante dato il suo ID
 	public Restaurant getRestaurant(Long id) {
		Restaurant restaurant = restaurantRepository.findById(id);
		return restaurant;
	}

 	// Metodo del servizio per la ricerca di un ristorante dato il suo nome
 	public Restaurant getRestaurantByName(String name) {
		Restaurant restaurant = restaurantRepository.findByName(name);
		return restaurant;
	}
	
 	// Metodo del servizio per la ricerca di tutti i ristoranti presenti
	public Collection<Restaurant> getAllRestaurants() {
		Collection<Restaurant> restaurants = restaurantRepository.findAll(); 
		return restaurants;
	}
	
	// Metodo del servizio per la ricerca di tutti i ristoranti di una location
	public Collection<Restaurant> getAllRestaurantsByLocation(String location) {
		Collection<Restaurant> restaurants = 
				restaurantRepository.findAllByLocation(location);
		return restaurants;
	}
	
	// Metodo del servizio per la ricerca di tutti i ristoranti con prefisso uguale
	public Collection<Restaurant> getAllRestaurantsByNameStartingChars(String stChars) {
		Collection<Restaurant> restaurants = 
				restaurantRepository.findAllByStartingChars(stChars);
		return restaurants;
	}
	
	// Metodo del servizio per la cancellazione di un ristorante passato per nome
	public Boolean deleteRestaurantByName(String name) {
		Restaurant restaurantByName = getRestaurantByName(name);
		if (restaurantByName == null)
			return false;
		restaurantRepository.deleteByObject(restaurantByName);
		return true;
	}

}

