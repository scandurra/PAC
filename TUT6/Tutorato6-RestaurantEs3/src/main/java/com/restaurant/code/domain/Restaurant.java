package com.restaurant.code.domain;

public class Restaurant {

	// Utiliziamo questo campo statico per dare un ID univoco
	// ad ogni ristorante
	private static long N_RESTAURANT = 0; 
	
	private Long id; 
	private String name; 
	private String location; 
	
	public Restaurant(String name, String location) {
		this.id = N_RESTAURANT;
		this.name = name; 
		this.location = location; 
		N_RESTAURANT++;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getLocation() {
		return this.location;
	}

	public Long getId() {
		return this.id;
	}
	
}

