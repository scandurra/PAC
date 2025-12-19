package com.restaurant.web;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.domain.Menu;
import com.restaurant.domain.MenuService;
import com.restaurant.domain.Piatto;
import com.restaurant.domain.Restaurant;
import com.restaurant.domain.RestaurantService;

// TODO: Auto-generated Javadoc
/**
 * The Class MenuWebController.
 */
@RestController
@RequestMapping("/api/v1/menus")  // 1. Base path + versioning
public class MenuWebController {

	/** The menu service. */
	@Autowired
	private MenuService menuService;
	
	/** The restaurant service. */
	@Autowired
	private RestaurantService restaurantService;

	/**
	 * Gets the menu.
	 *
	 * @param restaurantId the restaurant id
	 * @return the menu
	 */
	/* Trova il menu con restaurantId. */
	@GetMapping("/ID/{restaurantId}")
	public Menu getMenu(@PathVariable Long restaurantId) {
		Menu menu = menuService.getMenuByRestaurantId(restaurantId);
		return menu;
	}

	/**
	 * Gets the menu.
	 *
	 * @param restaurantName the restaurant name
	 * @return the menu
	 */
	/* Trova il menu con restaurantName. */
	@GetMapping("/name/{restaurantName}")
	public Menu getMenu(@PathVariable String restaurantName) {
		Menu menu = menuService.getMenuByRestaurantName(restaurantName);
		return menu;
	}

	/**
	 * Gets the menu by id.
	 *
	 * @param menuID the menu ID
	 * @return the menu by id
	 */
	/* Trova il menu dato il suo ID. */
	@GetMapping("/byid/{menuID}")
	public Menu getMenuById(@PathVariable Long menuID) {
		Menu menu = menuService.getMenu(menuID);
		return menu;
	}

	/**
	 * Adds the piatto by restaurant id.
	 *
	 * @param restaurantId the restaurant id
	 * @param name the name
	 * @param price the price
	 * @return the menu
	 */
	/* Aggiungi piatto al menù di un ristorante. */
	@GetMapping("/addpiatto/{restaurantId}")
	public Menu addPiattoByRestaurantId(@PathVariable Long restaurantId, @RequestParam(defaultValue = "") String name,
			@RequestParam(defaultValue = "") float price) {
		Restaurant restaurant = restaurantService.getRestaurant(restaurantId);
		Piatto piatto = new Piatto(name, price);
		Menu menu = menuService.addSingleItem(restaurant, piatto);
		return menu;
	}

	/**
	 * Sets the menu by id.
	 *
	 * @param restaurantId the restaurant id
	 * @param name the name
	 * @param price the price
	 * @return the menu
	 */
	/* Aggiungi piatti al menù di un ristorante. */
	@GetMapping("/addmenu/{restaurantId}")
	public Menu setMenuById(@PathVariable Long restaurantId, @RequestParam(defaultValue = "") ArrayList<String> name,
			@RequestParam(defaultValue = "") ArrayList<Float> price) {
		Restaurant restaurant = restaurantService.getRestaurant(restaurantId);
		ArrayList<Piatto> piatti = new ArrayList<>();
		// Nome e prezzo devono avere lo stesso numero di elementi
		if (name.size() != price.size())
			return null;
		// Popolo la lista di piatti
		for (int i = 0; i < name.size(); i++) {
			piatti.add(new Piatto(name.get(i), price.get(i)));
		}
		Menu menu = menuService.createMenu(restaurant, piatti);
		return menu;
	}
}
