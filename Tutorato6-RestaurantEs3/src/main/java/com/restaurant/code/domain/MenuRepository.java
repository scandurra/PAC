package com.restaurant.code.domain;

import java.util.ArrayList;
import java.util.Collection;

public class MenuRepository {
	
	ArrayList<Menu> listaMenu = new ArrayList<Menu>();

	// Aggiunge un nuovo menù. Se nella lista esiste già un menù
	// per lo stesso ristorante, allora, aggiunge ai piatti
	// quelli del menù passato per argomento
	public Menu save(Menu menu) {
		// Un ristorante con lo stesso nome esiste già
		if (this.listaMenu.stream().filter(
				x -> x.restaurant.getName().equals(menu.restaurant.getName())).count() > 0) {
			// Aggiungo al menù già esistente i piatti di quello nuovo
			Menu m = this.listaMenu.stream().filter(x -> x.restaurant.getName().equals(menu.restaurant.getName())).findFirst().orElse(null);
			m.menu.addAll(menu.menu);
		} else {
			// Aggiungo il nuovo menù
			this.listaMenu.add(menu);
		}		
		return menu;
	}

	// Get di tutti i menù
	public Collection<Menu> findAll() {
		return listaMenu;
	}

	// Cerca un menù dal nome del ristorante
	public Menu findByRestaurantName(String name) {
		for (Menu r : listaMenu) {
			if (r.restaurant.getName().equals(name))
				return r;
		}

		return null;
	}

	// Cerca un menù dall'ID del ristorante
	public Menu findByRestaurantId(Long id) {
		for (Menu r : listaMenu) {
			if (r.restaurant.getId().equals(id))
				return r;
		}

		return null;
	}

	// Cerca un menù in base al suo ID
	public Menu findById(Long id) {
		for (Menu r : listaMenu) {
			if (r.id == id)
				return r;
		}

		return null;
	}
}
