package com.restaurant.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

// TODO: Auto-generated Javadoc
/**
 * The Class MenuService.
 */
@Service
public class MenuService {

	/** The Constant log. */
	private static final Logger log = LoggerFactory.getLogger(MenuService.class);

	/** The menu repository. */
	private final MenuRepository menuRepository;

	/**
	 * Instantiates a new menu service.
	 *
	 * @param menuRepository the menu repository
	 */
	// Costruttore injection (meglio di new)
	public MenuService(MenuRepository menuRepository) {
		this.menuRepository = menuRepository;
	}

	/**
	 * Creates the menu.
	 *
	 * @param restaurant the restaurant
	 * @param piatti     the piatti
	 * @return the menu
	 */
	// Creazione di un nuovo menù
	public Menu createMenu(Restaurant restaurant, List<Piatto> piatti) {
		Objects.requireNonNull(restaurant, "restaurant must not be null");
		if (piatti == null) {
			piatti = new ArrayList<>();
		}

		log.info("Creating menu for restaurantId={} ({}) with {} dish(es)", restaurant.getId(), restaurant.getName(),
				piatti.size());

		Menu newMenu = new Menu(restaurant).addAll(piatti);
		Menu saved = menuRepository.save(newMenu);

		log.debug("Menu created with id={} for restaurantId={}", saved.getId(), restaurant.getId());
		return saved;
	}

	/**
	 * Adds the single item.
	 *
	 * @param restaurant the restaurant
	 * @param piatto     the piatto
	 * @return the menu
	 */
	// Aggiunta di un singolo piatto ad un menù esistente
	public Menu addSingleItem(Restaurant restaurant, Piatto piatto) {
		Objects.requireNonNull(restaurant, "restaurant must not be null");
		Objects.requireNonNull(piatto, "piatto must not be null");

		log.info("Adding dish '{}' to menu of restaurantId={} ({})", piatto.getNome(), restaurant.getId(),
				restaurant.getName());

		Menu menu = menuRepository.findByRestaurantId(restaurant.getId());
		if (menu == null) {
			log.warn("No menu found for restaurantId={}, cannot add dish", restaurant.getId());
			return null;
		}

		menu.add(piatto);
		log.debug("Dish '{}' added to menuId={}", piatto.getNome(), menu.getId());
		return menu;
	}

	/**
	 * Gets the menu.
	 *
	 * @param id the id
	 * @return the menu
	 */
	// Ritorna un menù dato il suo id
	public Menu getMenu(Long id) {
		if (id == null) {
			log.warn("getMenu called with null id");
			return null;
		}
		log.debug("Retrieving menu by id={}", id);
		Menu menu = menuRepository.findById(id);
		log.info("Menu {} for id={}", menu != null ? "found" : "not found", id);
		return menu;
	}

	/**
	 * Gets the menu by restaurant id.
	 *
	 * @param id the id
	 * @return the menu by restaurant id
	 */
	// Ritorna un menù dato l'id del ristorante
	public Menu getMenuByRestaurantId(Long id) {
		if (id == null) {
			log.warn("getMenuByRestaurantId called with null id");
			return null;
		}
		log.debug("Retrieving menu by restaurantId={}", id);
		Menu menu = menuRepository.findByRestaurantId(id);
		log.info("Menu {} for restaurantId={}", menu != null ? "found" : "not found", id);
		return menu;
	}

	/**
	 * Gets the menu by restaurant name.
	 *
	 * @param name the name
	 * @return the menu by restaurant name
	 */
	// Ritorna un menù dato il nome del ristorante
	public Menu getMenuByRestaurantName(String name) {
		if (name == null || name.isBlank()) {
			log.warn("getMenuByRestaurantName called with null/blank name");
			return null;
		}
		log.debug("Retrieving menu by restaurant name='{}'", name);
		Menu menu = menuRepository.findByRestaurantName(name);
		log.info("Menu {} for restaurant name='{}'", menu != null ? "found" : "not found", name);
		return menu;
	}
}
