package com.scg.grandmaster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class GrandmasterApplication {

	public static void main(String[] args) {
		SpringApplication.run(GrandmasterApplication.class, args);
	}

}
