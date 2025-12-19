package com.restaurant.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

// TODO: Auto-generated Javadoc
/**
 * The Class RestaurantRepository.
 */
@Component
public class RestaurantRepository {
	/** The Constant log. */
	private static final Logger log = LoggerFactory.getLogger(RestaurantRepository.class);

	/** The data. */
	private ArrayList<Restaurant> data = new ArrayList<Restaurant>();

	/**
	 * Save.
	 *
	 * @param r the r
	 * @return the restaurant
	 */
	public Restaurant save(Restaurant r) {
		log.debug("Saving restaurant: {}", r.getName());
		data.add(r);
		log.info("Restaurant saved successfully. Total: {}", data.size());
		return r;
	}

	/**
	 * Gets the all.
	 *
	 * @return the all
	 */
	public ArrayList<Restaurant> getAll() {
		log.debug("Retrieving all restaurants. Count: {}", data.size());
		return data;
	}

	/**
	 * Delete restaurant by name.
	 *
	 * @param n the n
	 * @return the restaurant
	 */
	public Restaurant deleteRestaurant(String n) {
		log.info("Attempting to delete restaurant with name: {}", n);
		for (int i = 0; i < data.size(); i++) {
			if (data.get(i).getName().equals(n)) {
				Restaurant r = data.get(i);

				log.warn("Deleting restaurant: {} (ID: {})", r.getName(), r.getId());

				data.remove(i);

				log.info("Restaurant deleted successfully. Remaining: {}", data.size());
				return r;
			}
		}
		return null;
	}

	/**
	 * Delete restaurant by id.
	 *
	 * @param id the id
	 * @return the restaurant
	 */
	public Restaurant deleteRestaurant(long id) {
		log.info("Attempting to delete restaurant with ID: {}", id);
		for (int i = 0; i < data.size(); i++) {
			if (data.get(i).getId() == id) {
				Restaurant r = data.get(i);

				log.warn("Deleting restaurant: {} (ID: {})", r.getName(), r.getId());

				data.remove(i);

				log.info("Restaurant deleted successfully. Remaining: {}", data.size());
				return r;
			}
		}
		return null;
	}

	/**
	 * Find by name.
	 *
	 * @param n the n
	 * @return the restaurant
	 */
	public Restaurant findByName(String n) {
		log.debug("Searching restaurant by name: {}", n);

		for (Restaurant r : data) {
			if (r.getName().equals(n))
				log.debug("Restaurant found: {} (ID: {})", n, r.getId());
			return r;
		}

		log.debug("Restaurant not found: {}", n);
		return null;
	}

	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the restaurant
	 */
	public Restaurant findById(long id) {
		log.debug("Searching restaurant by ID: {}", id);

		for (Restaurant r : data) {
			if (r.getId() == id) {

				log.debug("Restaurant found: {} (ID: {})", r.getName(), id);
				return r;
			}
		}

		log.debug("Restaurant not found by ID: {}", id);
		return null;
	}

	// ========================== ESERCIZIO 2

	/**
	 * Find all by location.
	 *
	 * @param location the location
	 * @return the collection
	 */
	public Collection<Restaurant> findAllByLocation(String location) {
		if (location == null || location.isBlank()) {
			log.warn("findAllByLocation called with null/blank location");
			return List.of();
		}

		log.debug("Searching restaurants by location: {}", location);
		List<Restaurant> result = data.stream().filter(r -> location.equals(r.getLocation())).toList();

		log.info("Found {} restaurant(s) for location '{}'", result.size(), location);
		return result;
	}

	/**
	 * Find all by starting chars.
	 *
	 * @param name the name prefix
	 * @return the collection
	 */
	public Collection<Restaurant> findAllByStartingChars(String name) {
		if (name == null || name.isBlank()) {
			log.warn("findAllByStartingChars called with null/blank prefix");
			return List.of();
		}

		log.debug("Searching restaurants by name prefix: {}", name);
		List<Restaurant> result = data.stream().filter(r -> r.getName() != null && r.getName().startsWith(name))
				.toList();

		log.info("Found {} restaurant(s) with name starting with '{}'", result.size(), name);
		return result;
	}

	/**
	 * Delete by object.
	 *
	 * @param restaurant the restaurant to delete
	 * @return true if removed, false if not found
	 */
	public boolean deleteByObject(Restaurant restaurant) {
		if (restaurant == null) {
			log.warn("deleteByObject called with null restaurant");
			return false;
		}

		log.debug("Attempting to delete restaurant: {}", restaurant);
		boolean removed = data.remove(restaurant);

		if (removed) {
			log.info("Restaurant deleted: {}", restaurant);
		} else {
			log.warn("Restaurant not found, nothing deleted: {}", restaurant);
		}
		return removed;
	}

	// ======================================

	// ========================== ESERCIZIO 3

	// ======================================
}
