package com.accenture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class MainEntry {

	public static void main(String[] args) {
		SpringApplication.run(MainEntry.class, args);
	}
}
