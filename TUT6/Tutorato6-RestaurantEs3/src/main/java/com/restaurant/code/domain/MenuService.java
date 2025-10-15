package com.restaurant.code.domain;

import java.util.ArrayList;

import org.springframework.stereotype.Service; 

@Service
public class MenuService {

	private MenuRepository menuRepository = new MenuRepository();

	// Creazione di un nuovo menù
 	public Menu createMenu(Restaurant restaurant, ArrayList<Piatto> menu) {
 		Menu newMenu = new Menu(restaurant);
 		newMenu.addAll(menu); 
 		newMenu = menuRepository.save(newMenu);
		return newMenu;
	}
 	
 	// Aggiunta di un singolo piatto ad un menù esistente
 	public Menu addSingleItem(Restaurant restaurant, Piatto piatto) {
 		Menu m = menuRepository.findByRestaurantId(restaurant.getId()).add(piatto);
 		return m;
	}

 	// Ritorna un menù dato il suo id
 	public Menu getMenu(Long id) {
		Menu menu = menuRepository.findById(id);
		return menu;
	}
 	
 	// Ritorna un menù dato l'id del ristorante
 	public Menu getMenuByRestaurantId(Long id) {
 		Menu menu = menuRepository.findByRestaurantId(id);
		return menu;
	}

 	// Ritorna un menù dato il nome del ristorante
 	public Menu getMenuByRestaurantName(String name) {
 		Menu menu = menuRepository.findByRestaurantName(name);
		return menu;
	}

}

