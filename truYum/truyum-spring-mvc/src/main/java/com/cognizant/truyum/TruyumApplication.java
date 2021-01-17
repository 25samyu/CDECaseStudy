package com.cognizant.truyum;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.cognizant.truyum")
@ConfigurationPropertiesScan("application.properties")

public class TruyumApplication {

	public static void main(String[] args) {
		SpringApplication.run(TruyumApplication.class, args);
	}

}
