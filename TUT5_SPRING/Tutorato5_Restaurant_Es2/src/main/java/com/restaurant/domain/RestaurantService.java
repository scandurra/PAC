package com.restaurant.domain;

import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// TODO: Auto-generated Javadoc
/**
 * The Class RestaurantService.
 */
@Service
public class RestaurantService {
	/** The Constant log. */
	private static final Logger log = LoggerFactory.getLogger(RestaurantRepository.class);

	/** The repo. */
	// !!!!!!! - meglio usare DI
	// Creato così direttamente non consente envetuali unit test su questa parte
	// private RestaurantRepository repo = new RestaurantRepository();

	@Autowired
	private RestaurantRepository repo;

	/**
	 * Creates the restaurant.
	 *
	 * @param name     the name
	 * @param location the location
	 * @return the restaurant
	 */
	public Restaurant createRestaurant(String name, String location) {
		log.info("Creating restaurant: {} in {}", name, location);
		Restaurant r = new Restaurant(name, location);
		return repo.save(r);
	}

	/**
	 * Gets the all restaurants.
	 *
	 * @return the all restaurants
	 */
	public List<Restaurant> getAllRestaurants() {
		log.debug("Fetching all restaurants");
		return repo.getAll();
	}

	/**
	 * Gets the restaurant.
	 *
	 * @param id the id
	 * @return the restaurant
	 */
	public Restaurant getRestaurant(long id) {
		log.debug("Fetching restaurant by ID: {}", id);
		Restaurant r = repo.findById(id);
		return r;
	}

	/**
	 * Gets the restaurant by name.
	 *
	 * @param name the name
	 * @return the restaurant by name
	 */
	public Restaurant getRestaurantByName(String name) {
		Restaurant r = repo.findByName(name);
		return r;
	}

	/**
	 * Delete restaurant by name.
	 *
	 * @param name the name
	 * @return the restaurant
	 */
	public Restaurant deleteRestaurantByName(String name) {
		log.info("Deleting restaurant by name: {}", name);
		Restaurant r = repo.deleteRestaurant(name);

		if (r != null) {
			log.info("Restaurant deleted successfully: {}", name);
		} else {
			log.warn("Restaurant not found for deletion: {}", name);
		}

		return r;
	}

	/**
	 * Delete restaurant by id.
	 *
	 * @param id the id
	 * @return the restaurant
	 */
	public Restaurant deleteRestaurantById(long id) {
		log.info("Deleting restaurant by id: {}", id);
		Restaurant r = repo.deleteRestaurant(id);

		if (r != null) {
			log.info("Restaurant deleted successfully: {}", id);
		} else {
			log.warn("Restaurant not found for deletion: {}", id);
		}

		return r;
	}

	// ========================== ESERCIZIO 2

	/**
	 * Gets the all restaurants by location.
	 *
	 * @param location the location
	 * @return the all restaurants by location
	 */
	// Metodo del servizio per la ricerca di tutti i ristoranti di una location
	public Collection<Restaurant> getAllRestaurantsByLocation(String location) {
		if (location == null || location.isBlank()) {
			log.warn("getAllRestaurantsByLocation called with null/blank location");
			return List.of();
		}

		log.debug("Searching restaurants by location: {}", location);
		Collection<Restaurant> restaurants = repo.findAllByLocation(location);
		log.info("Found {} restaurant(s) for location '{}'", restaurants.size(), location);
		return restaurants;
	}

	/**
	 * Gets the all restaurants by name starting chars.
	 *
	 * @param prefix the prefix
	 * @return the all restaurants by name starting chars
	 */
	// Metodo del servizio per la ricerca di tutti i ristoranti con prefisso uguale
	public Collection<Restaurant> getAllRestaurantsByNameStartingChars(String prefix) {
		if (prefix == null || prefix.isBlank()) {
			log.warn("getAllRestaurantsByNameStartingChars called with null/blank prefix");
			return List.of();
		}

		log.debug("Searching restaurants by name prefix: {}", prefix);
		Collection<Restaurant> restaurants = repo.findAllByStartingChars(prefix);
		log.info("Found {} restaurant(s) with name starting with '{}'", restaurants.size(), prefix);
		return restaurants;
	}

	// ======================================
}
