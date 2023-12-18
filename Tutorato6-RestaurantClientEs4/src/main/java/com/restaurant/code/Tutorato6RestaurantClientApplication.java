package com.restaurant.code;

import java.util.ArrayList;
import java.util.Scanner;

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
    		// Richiedo il nome del ristorante
    		System.out.println("Inserisci il nome del ristorante: ");
    		Scanner in = new Scanner(System.in);
    		String restaurantName = in.nextLine();
    		
    		Menu menu = restTemplate.getForObject(
    				"http://localhost:8080/menus/name/" + restaurantName, Menu.class);
    		menu.printMenu();
    	};
    }

}
