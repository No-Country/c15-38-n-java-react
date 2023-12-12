package com.c1538njavareact.serviLink;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ServiLink {

	public static void main(String[] args) {
		SpringApplication.run(ServiLink.class, args);
	}

}
