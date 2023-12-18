package com.restaurant.code;

import java.util.ArrayList;

import org.apache.catalina.util.RequestUtil;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.restaurant.code.domain.Menu;
import com.restaurant.code.domain.Restaurant;

@SpringBootApplication
public class Tutorato6RestaurantClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(Tutorato6RestaurantClientApplication.class, args);
	}

    @Bean
    RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

	@Bean
    CommandLineRunner run(RestTemplate restTemplate) {
    	return args -> {
    		// Chiamata delle API che ritornano la lista dei ristoranti
    		ArrayList<Restaurant> list = restTemplate.getForObject(
    				"http://localhost:8080/restaurants", ArrayList.class);
    		System.out.println(list);
    		
    		// Chiamata delle API che ritorna il ristorante con ID = 1
    		Restaurant rest = restTemplate.getForObject(
    				"http://localhost:8080/restaurants/1", Restaurant.class);
    		System.out.println(rest.getName());
    		
    		// Costruzione dell'header per la richiesta POST per l'aggiunta di un
    		// ristorante dato il suo nome e la sua location
    		HttpHeaders headers = new HttpHeaders();
    		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

    		MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
    		map.add("name", "Prova");
    		map.add("location", "Bergamo");

    		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
    		
    		// Chiamata delle API per l'inserimento del ristorante
    		Restaurant newRest = restTemplate.postForObject(
    				"http://localhost:8080/restaurants/",
    				request, Restaurant.class);
    		System.out.println(newRest.getName());
    		
    		// Chiamata delle API per la ricerca di un ristorante dato il suo prefisso
    		list = restTemplate.getForObject(
    				"http://localhost:8080/restaurants/prefix/da", ArrayList.class);
    		System.out.println(list);
    		
    		// Chiamata delle API per la cancellazione di un ristorante
    		Boolean deleted = restTemplate.getForObject(
    				"http://localhost:8080/restaurants/delete/Prova", Boolean.class);
    		System.out.println(deleted);
    		
    		// Vediamo il menù del ristorante "Seta" (inserito in fase di inizializzazione)
    		Menu menu = restTemplate.getForObject(
    				"http://localhost:8080/menus/name/Seta", Menu.class);
    		menu.printMenu();
    		
    		// Vediamo il menù del ristorante "Seta" con ID 3
    		menu = restTemplate.getForObject(
    				"http://localhost:8080/menus/ID/3", Menu.class);
    		menu.printMenu();
    		
    		// Vediamo il menù con ID 0
    		menu = restTemplate.getForObject(
    				"http://localhost:8080/menus/byid/0", Menu.class);
    		menu.printMenu();
    	};
    }

}
