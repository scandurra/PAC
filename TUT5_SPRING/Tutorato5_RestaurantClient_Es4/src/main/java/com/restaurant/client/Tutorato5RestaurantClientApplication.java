package com.restaurant.client;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.restaurant.domain.Menu;

@SpringBootApplication
public class Tutorato5RestaurantClientApplication {

    private static final Logger log = LoggerFactory.getLogger(Tutorato5RestaurantClientApplication.class);

    // Base URL del server REST (configurabile da application.properties)
    @Value("${restaurant.api.base-url:http://localhost:8085/api/v1}")
    private String baseUrl;

    public static void main(String[] args) {
        SpringApplication.run(Tutorato5RestaurantClientApplication.class, args);
    }

    @Bean
    RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    CommandLineRunner run(RestTemplate restTemplate) {
        return args -> {
            try (Scanner in = new Scanner(System.in)) {
                System.out.print("Inserisci il nome del ristorante che ti interessa: ");
                String restaurantName = in.nextLine().trim();

                if (restaurantName.isBlank()) {
                    System.out.println("Nome ristorante vuoto, annullo la richiesta.");
                    return;
                }

                String url = baseUrl + "/menus/name/{restaurantName}";
                log.info("Calling {}", url);

                Menu menu = restTemplate.getForObject(url, Menu.class, restaurantName);

                if (menu == null || menu.getPiatti().isEmpty()) {
                    System.out.println("Nessun menù trovato per il ristorante: " + restaurantName);
                    return;
                }

                // Stampa menù
                System.out.println("**********");
                System.out.println(menu.getRestaurant().getName() +
                                   " - " + menu.getRestaurant().getLocation());
                System.out.println("**********");
                menu.getPiatti().forEach(p ->
                        System.out.println(p.getNome() + " - " + p.getPrezzo()));
            } catch (HttpClientErrorException.NotFound e) {
                System.out.println("Ristorante non trovato o nessun menù disponibile.");
                log.warn("Menu not found: {}", e.getMessage());
            } catch (Exception e) {
                System.out.println("Errore durante la chiamata al server.");
                log.error("Error calling restaurant API", e);
            }
        };
    }
}
