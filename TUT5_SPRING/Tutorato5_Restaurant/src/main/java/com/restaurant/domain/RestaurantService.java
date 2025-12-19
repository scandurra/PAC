package com.restaurant.domain;

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
	 * @param name the name
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
}
