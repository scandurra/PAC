package com.restaurant.init;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.restaurant.domain.MenuService;
import com.restaurant.domain.Piatto;
import com.restaurant.domain.Restaurant;
import com.restaurant.domain.RestaurantService;

// TODO: Auto-generated Javadoc
/**
 * The Class InitRestaurantDb.
 */
// @Component dice a Spring gestisci questa classe. Il metodo run serve solo se vogliamo eseguire codice all’avvio.
// CommandLineRunner: Interfaccia che Spring chiama automaticamente con run() post-startup
@Component
public class InitRestaurantDb implements CommandLineRunner {

	/** The Constant log. */
	private static final Logger log = LoggerFactory.getLogger(InitRestaurantDb.class);

	/** The service. */
	@Autowired
	private RestaurantService service;

	@Autowired
	private MenuService menuService;

	// Costruttore UNICO = @Autowired implicito
	/*
	 * public InitRestaurantDb(RestaurantService s) { this.service = s; }
	 */

	/**
	 * Run.
	 *
	 * @param args the args
	 * @throws Exception the exception
	 */
	@Override
	public void run(String... args) throws Exception {
		if (service.getAllRestaurants().isEmpty()) {
			log.info("Initializing database with sample data...");

			service.createRestaurant("Hostaria dell'Orso", "Roma");
			service.createRestaurant("Baffetto", "Roma");
			service.createRestaurant("L'Omo", "Roma");
			service.createRestaurant("L'Anonimo", "Dalmine");
			service.createRestaurant("Osteria dell'Oste", "Roma");

			Restaurant restaurant = service.createRestaurant("Seta", "Milano");

			// Per uno dei ristoranti definisco anche un menù
			ArrayList<Piatto> listaPiatti = new ArrayList<>();
			listaPiatti.add(new Piatto("Pasta al sugo", 10));
			listaPiatti.add(new Piatto("Cotoletta alla milanese", 13));
			listaPiatti.add(new Piatto("Acqua 0.5L", 2));
			menuService.createMenu(restaurant, listaPiatti);

			Restaurant r = service.getRestaurant(1);
			log.info("Sample restaurant created: {}", r);
		} else {
			log.info("Database already contains data, skipping init");
		}
	}
}
