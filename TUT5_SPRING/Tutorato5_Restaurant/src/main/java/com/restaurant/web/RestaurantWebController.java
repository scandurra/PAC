package com.restaurant.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.domain.Restaurant;
import com.restaurant.domain.RestaurantService;
import com.restaurant.init.InitRestaurantDb;

// TODO: Auto-generated Javadoc
/**
 * The Class RestaurantWebController.
 */
@RestController
@RequestMapping("/api/v1/restaurants")  // 1. Base path + versioning
public class RestaurantWebController {
	/** The Constant log. */
	private static final Logger log = LoggerFactory.getLogger(RestaurantWebController.class);
	
	/** The service. */
	@Autowired
	private RestaurantService service;

	/**
	 * Gets the restaurant.
	 *
	 * @param restaurantId the restaurant id
	 * @return the restaurant
	 */
	// NOTA: @PathVariable deve avere lo stesso nome presente in GetMapping
    @GetMapping("/{id}")
	public ResponseEntity<Restaurant> getRestaurant(@PathVariable("id") long restaurantId) {
        log.debug("GET /restaurants/" + restaurantId);
		Restaurant r = service.getRestaurant(restaurantId);
        return r != null ? ResponseEntity.ok(r) : ResponseEntity.notFound().build();
	}

	/**
	 * Gets the all restaurants.
	 *
	 * @return the all restaurants
	 */
    @GetMapping
	public ResponseEntity<List<Restaurant>> getAllRestaurants() {
        log.debug("GET /restaurants");
        List<Restaurant> list = service.getAllRestaurants();
        return ResponseEntity.ok(list);             // 200 OK
	}

	/**
	 * Adds the restaurant.
	 *
	 * @param restaurantName the restaurant name
	 * @param location       the location
	 * @return the restaurant
	 */
    @PostMapping
    public ResponseEntity<Restaurant> addRestaurant(
            @RequestParam(defaultValue = "", name = "name") String restaurantName,
            @RequestParam String location) {
        Restaurant created = service.createRestaurant(restaurantName, location);
        return ResponseEntity
                .status(201)                        // 201 CREATED
                .body(created);
    }

    /**
     * Delete restaurant by id.
     *
     * @param id the id
     * @return the response entity
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRestaurant(@PathVariable long id) {
        Restaurant deleted = service.deleteRestaurantById(id);
        return deleted != null
                ? ResponseEntity.noContent().build() // 204 NO CONTENT
                : ResponseEntity.notFound().build(); // 404 NOT FOUND
    }
}
