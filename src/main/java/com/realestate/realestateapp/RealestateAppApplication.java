package com.realestate.realestateapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

@ComponentScan(basePackages = "com.realestate")
public class RealestateAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(RealestateAppApplication.class, args);
	}

}
