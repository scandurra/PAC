package com.restaurant.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

// TODO: Auto-generated Javadoc
/**
 * The Class Restaurant.
 */
public class Restaurant {

	/**
	 * The n restaurant. Utiliziamo questo campo statico per dare un ID univoco ad
	 * ogni ristorante
	 */
	private static long N_RESTAURANT = 0;

	/** The id. */
	@JsonProperty("ID_R")
	private long id;

	/** The name. */
	@JsonProperty("NOME_R")
	private String name;

	/** The location. */
	@JsonProperty("POSIZIONE_R")
	private String location;

	/**
	 * Instantiates a new restaurant.
	 *
	 * @param name     the name
	 * @param location the location
	 */
	public Restaurant(String name, String location) {
		this.id = N_RESTAURANT++;
		this.name = name;
		this.location = location;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public long getId() {
		return this.id;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Gets the location.
	 *
	 * @return the location
	 */
	public String getLocation() {
		return this.location;
	}
}
