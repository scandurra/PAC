package com.restaurant.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MenuRepository {

	private static final Logger log = LoggerFactory.getLogger(MenuRepository.class);

	private final List<Menu> listaMenu = new ArrayList<>();

	/**
	 * Salva un menu. Se esiste già un menu per lo stesso ristorante (per id),
	 * aggiunge i piatti del nuovo menu a quello esistente.
	 */
	public Menu save(Menu menu) {
		Objects.requireNonNull(menu, "menu must not be null");
		Objects.requireNonNull(menu.getRestaurant(), "menu.restaurant must not be null");

		Long restaurantId = menu.getRestaurant().getId();
		log.debug("Saving menu for restaurantId={}", restaurantId);

		Optional<Menu> existing = listaMenu.stream().filter(m -> m.getRestaurant().getId() == restaurantId)
				.findFirst();

		if (existing.isPresent()) {
			Menu current = existing.get();
			int before = current.getPiatti().size();
			current.addAll(menu.getPiatti());
			int after = current.getPiatti().size();
			log.info("Merged menu for restaurantId={} (dishes: {} -> {})", restaurantId, before, after);
		} else {
			listaMenu.add(menu);
			log.info("Added new menu with id={} for restaurantId={}", menu.getId(), restaurantId);
		}

		return menu;
	}

	/**
	 * Restituisce tutti i menu.
	 */
	public Collection<Menu> findAll() {
		log.debug("Retrieving all menus, count={}", listaMenu.size());
		return List.copyOf(listaMenu);
	}

	/**
	 * Cerca un menu dal nome del ristorante.
	 */
	public Menu findByRestaurantName(String name) {
		if (name == null || name.isBlank()) {
			log.warn("findByRestaurantName called with null/blank name");
			return null;
		}

		log.debug("Searching menu by restaurant name='{}'", name);
		Menu result = listaMenu.stream().filter(m -> name.equals(m.getRestaurant().getName())).findFirst().orElse(null);

		if (result != null) {
			log.info("Menu found for restaurant name='{}' (menuId={})", name, result.getId());
		} else {
			log.info("No menu found for restaurant name='{}'", name);
		}
		return result;
	}

	/**
	 * Cerca un menu dall'id del ristorante.
	 */
	public Menu findByRestaurantId(Long restaurantId) {
		if (restaurantId == null) {
			log.warn("findByRestaurantId called with null id");
			return null;
		}

		log.debug("Searching menu by restaurantId={}", restaurantId);
		Menu result = listaMenu.stream().filter(m -> restaurantId.equals(m.getRestaurant().getId())).findFirst()
				.orElse(null);

		if (result != null) {
			log.info("Menu found for restaurantId={} (menuId={})", restaurantId, result.getId());
		} else {
			log.info("No menu found for restaurantId={}", restaurantId);
		}
		return result;
	}

	/**
	 * Cerca un menu in base al suo id.
	 */
	public Menu findById(Long id) {
		if (id == null) {
			log.warn("findById called with null id");
			return null;
		}

		log.debug("Searching menu by menuId={}", id);
		Menu result = listaMenu.stream().filter(m -> id.equals(m.getId())).findFirst().orElse(null);

		if (result != null) {
			log.info("Menu found with id={}", id);
		} else {
			log.info("No menu found with id={}", id);
		}
		return result;
	}
}
