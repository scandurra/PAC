package com.restaurant.code.web;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.code.domain.Menu;
import com.restaurant.code.domain.MenuService;
import com.restaurant.code.domain.Piatto;
import com.restaurant.code.domain.Restaurant;
import com.restaurant.code.domain.RestaurantService;

@RestController
@RequestMapping("/menus")
public class MenuWebController {

	@Autowired 
	private MenuService menuService; 
	@Autowired 
	private RestaurantService restaurantService; 

	/* Trova il menu con restaurantId. */ 
	@GetMapping("/ID/{restaurantId}")
	public Menu getMenu(@PathVariable Long restaurantId) {
		Menu menu = menuService.getMenuByRestaurantId(restaurantId);
		return menu;
	}
	
	/* Trova il menu con restaurantName. */ 
	@GetMapping("/name/{restaurantName}")
	public Menu getMenu(@PathVariable String restaurantName) {
		Menu menu = menuService.getMenuByRestaurantName(restaurantName);
		return menu;
	}
	
	/* Trova il menu dato il suo ID. */ 
	@GetMapping("/byid/{menuID}")
	public Menu getMenuById(@PathVariable Long menuID) {
		Menu menu = menuService.getMenu(menuID);
		return menu;
	}
	
	/* Aggiungi piatto al menù di un ristorante. */ 
	@GetMapping("/addpiatto/{restaurantId}")
	public Menu addPiattoByRestaurantId(@PathVariable Long restaurantId, 
			@RequestParam(defaultValue = "") String name, 
			@RequestParam(defaultValue = "") float price) {
		Restaurant restaurant = restaurantService.getRestaurant(restaurantId);
		Piatto piatto = new Piatto(name, price);
		Menu menu = menuService.addSingleItem(restaurant, piatto);
		return menu;
	}

	/* Aggiungi piatti al menù di un ristorante. */ 
	@GetMapping("/addmenu/{restaurantId}")
	public Menu setMenuById(@PathVariable Long restaurantId, 
			@RequestParam(defaultValue = "") ArrayList<String> name, 
			@RequestParam(defaultValue = "") ArrayList<Float> price) {
		Restaurant restaurant = restaurantService.getRestaurant(restaurantId);
		ArrayList<Piatto> piatti = new ArrayList<>();
		// Nome e prezzo devono avere lo stesso numero di elementi
		if (name.size() != price.size())
			return null;
		// Popolo la lista di piatti
		for (int i=0; i<name.size(); i++) {
			piatti.add(new Piatto(name.get(i), price.get(i)));
		}
		Menu menu = menuService.createMenu(restaurant, piatti);
		return menu;
	}
	

}
