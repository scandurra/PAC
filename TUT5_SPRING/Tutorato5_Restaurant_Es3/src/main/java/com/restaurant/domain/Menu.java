package com.restaurant.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

// TODO: Auto-generated Javadoc
/**
 * The Class Menu.
 */
public class Menu {
	
	/** The n menu. */
	// ID univoco in memoria (non thread-safe, solo per demo)
	private static long N_MENU = 0;

	/** The id. */
	private final Long id;
	
	/** The restaurant. */
	private final Restaurant restaurant;
	
	/** The piatti. */
	private final List<Piatto> piatti;

	/**
	 * Instantiates a new menu.
	 *
	 * @param restaurant the restaurant
	 */
	public Menu(Restaurant restaurant) {
		this.id = N_MENU++;
		this.restaurant = Objects.requireNonNull(restaurant, "restaurant must not be null");
		this.piatti = new ArrayList<>();
	}

	/**
	 * Adds the all.
	 *
	 * @param piatti the piatti
	 * @return the menu
	 */
	// Aggiunge ad un menù una lista di piatti
	public Menu addAll(Collection<Piatto> piatti) {
		if (piatti == null || piatti.isEmpty()) {
			return this;
		}
		this.piatti.addAll(piatti);
		return this;
	}

	/**
	 * Adds the.
	 *
	 * @param piatto the piatto
	 * @return the menu
	 */
	// Aggiunge ad un menù un solo piatto
	public Menu add(Piatto piatto) {
		if (piatto != null) {
			this.piatti.add(piatto);
		}
		return this;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Gets the restaurant.
	 *
	 * @return the restaurant
	 */
	public Restaurant getRestaurant() {
		return restaurant;
	}

	/**
	 * Gets the piatti.
	 *
	 * @return the piatti
	 */
	public List<Piatto> getPiatti() {
		return Collections.unmodifiableList(piatti);
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("**********").append(System.lineSeparator());
		sb.append(restaurant.getName()).append(" - ").append(restaurant.getLocation()).append(System.lineSeparator());
		sb.append("**********").append(System.lineSeparator());
		piatti.forEach(p -> sb.append(p.getNome()).append(" - ").append(p.getPrezzo()).append(System.lineSeparator()));
		return sb.toString();
	}
}