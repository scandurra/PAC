package com.restaurant.client;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import com.restaurant.domain.Restaurant;

// TODO: Auto-generated Javadoc
/**
 * The Class Tutorato5RestaurantClientApplication.
 */
@SpringBootApplication
public class Tutorato5RestaurantClientApplication {
	/** The Constant log. */
	private static final Logger log = LoggerFactory.getLogger(Tutorato5RestaurantClientApplication.class);
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(Tutorato5RestaurantClientApplication.class, args);
	}

	/**
	 * Rest template.
	 *
	 * @param builder the builder
	 * @return the rest template
	 */
	@Bean
	RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	/**
	 * Run.
	 *
	 * @param restTemplate the rest template
	 * @return the command line runner
	 */
	@Bean
	CommandLineRunner run(RestTemplate restTemplate) {
	    return args -> {
	    	try {
		        // 1) GET: tutti i ristoranti
		        ArrayList<?> all = restTemplate.getForObject(
		                "http://localhost:8080/api/v1/restaurants",
		                ArrayList.class);
		        log.info("GET /api/v1/restaurants -> {}", all);

		        // 2) POST: crea un nuovo ristorante
		        String name = "Trattoria Client";
		        String location = "Milano";
		        Restaurant created = restTemplate.postForObject(
		                "http://localhost:8080/api/v1/restaurants?name={name}&location={loc}",
		                null,
		                Restaurant.class,
		                name,
		                location);
		        log.info("POST /api/v1/restaurants -> {}", created);

		        // 3) GET: ristorante per id (es. 1)
		        Restaurant byId = restTemplate.getForObject(
		                "http://localhost:8080/api/v1/restaurants/{id}",
		                Restaurant.class,
		                1L);
		        log.info("GET /api/v1/restaurants/1 -> {}", byId);

		        // 4) DELETE: cancella per nome
		        var id = byId.getId();
		        restTemplate.delete(
		                "http://localhost:8080/api/v1/restaurants/{id}",
		                id);
		        log.info("DELETE /api/v1/restaurants/{} eseguita", id);
	        } catch (HttpClientErrorException.NotFound e) {
	            log.warn("Risorsa non trovata: {}", e.getMessage());
	        } catch (RestClientException e) {
	            log.error("Errore chiamando le API del ristorante", e);
	        }
	    };
	}
}
