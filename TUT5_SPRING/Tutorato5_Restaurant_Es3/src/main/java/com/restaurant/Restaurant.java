package com.restaurant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class Restaurant.
 *
 * @SpringBootApplication annotation is used to mark the main class of a Spring
 *                        Boot application. It
 *                        encapsulates @SpringBootConfiguration, @EnableAutoConfiguration
 *                        and @ComponentScan annotations with their default
 *                        attributes.
 */
@SpringBootApplication
public class Restaurant {

	/** The Constant log. */
	private static final Logger log = LoggerFactory.getLogger(Restaurant.class);

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		log.info("Start Restaurant application");
		SpringApplication.run(Restaurant.class, args);
	}
}