package com.restaurant.code.domain;

import java.util.ArrayList;
import java.util.Collection;

public class RestaurantRepository {

	// ArrayList che rappresenta il database di ristoranti
	ArrayList<Restaurant> listaRistoranti = new ArrayList<Restaurant>();
	
	// Aggiunta di un nuovo ristorante
	public Restaurant save(Restaurant restaurant) {
		this.listaRistoranti.add(restaurant);
		return restaurant;
	}

	// Get di tutti i ristoranti
	public Collection<Restaurant> findAll() {
		return listaRistoranti;
	}

	// Ricerca ristorante per nome
	public Restaurant findByName(String name) {
		for (Restaurant r : listaRistoranti) {
			if (r.getName().equals(name))
				return r;
		}

		return null;
	}

	// Ricerca ristorante per ID
	public Restaurant findById(Long id) {
		for (Restaurant r : listaRistoranti) {
			if (r.getId() == id)
				return r;
		}

		return null;
	}

	// Ricerca tutti i ristoranti della stessa location
	public Collection<Restaurant> findAllByLocation(String location) {
		return this.listaRistoranti.stream().filter(
				x -> x.getLocation().equals(location)).toList();
	}
	
	// Ricerca tutti i ristoranti con prefisso uguale
	public Collection<Restaurant> findAllByStartingChars(String name) {
		return this.listaRistoranti.stream().filter(
				x -> x.getName().startsWith(name)).toList();
	}

	// Cancella dalla lista dei ristoranti quello passato per argomento
	public void deleteByObject(Restaurant restaurantByName) {
		this.listaRistoranti.remove(restaurantByName);		
	}

}
