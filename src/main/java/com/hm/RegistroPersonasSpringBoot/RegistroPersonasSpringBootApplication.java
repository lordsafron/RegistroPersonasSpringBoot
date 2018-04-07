package com.hm.RegistroPersonasSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.hm.RegistroPersonasSpringBoot.repository")
@SpringBootApplication
public class RegistroPersonasSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistroPersonasSpringBootApplication.class, args);
	}
}
