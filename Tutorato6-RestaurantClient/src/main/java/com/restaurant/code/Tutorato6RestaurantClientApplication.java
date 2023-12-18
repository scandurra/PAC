package com.restaurant.code;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

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
    		// Chiamata REST dell'API che ritorna la lista di tutti i ristoranti 
			ArrayList<Restaurant> list = restTemplate.getForObject(
    				"http://localhost:8080/restaurants", ArrayList.class);
    		System.out.println(list);
    	};
    }

}
