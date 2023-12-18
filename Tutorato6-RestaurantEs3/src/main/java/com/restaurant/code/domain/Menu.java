package com.restaurant.code.domain;

import java.util.ArrayList;
import java.util.Collection;

public class Menu {
	
	// Usiamo questo campo statico per dare un ID univoco ai menù
	private static long N_MENU = 0; 
	
	Long id;
	ArrayList<Piatto> menu;
	Restaurant restaurant;
	
	Menu() {
		this.menu = new ArrayList<>();
		this.restaurant = null;
		this.id = N_MENU;
		N_MENU++;
	}
	
	Menu(Restaurant r) {
		this.menu = new ArrayList<>();
		this.restaurant = r;
		this.id = N_MENU;
		N_MENU++;
	}

	// Aggiunge ad un menù una lista di piatti
	public Menu addAll(Collection<Piatto> menu) {
		this.menu.addAll(menu);
		return this;
	}
	
	// Aggiunge ad un menù un solo piatto
	public Menu add(Piatto piatto) {
		this.menu.add(piatto);
		return this;
	}
	
	// Get e Set
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ArrayList<Piatto> getMenu() {
		return menu;
	}

	public void setMenu(ArrayList<Piatto> menu) {
		this.menu = menu;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	
	// Stampa un menù
	public void printMenu() {
		System.out.println("**********");
		System.out.println(this.restaurant.getName() + " - " + this.restaurant.getLocation());
		System.out.println("**********");
		this.menu.forEach(x -> System.out.println(x.getNome() + " - " + x.getPrezzo()));
	}
	
}

