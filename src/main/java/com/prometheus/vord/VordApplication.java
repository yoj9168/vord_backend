package com.prometheus.vord;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class VordApplication {
	public static void main(String[] args) {
		SpringApplication.run(VordApplication.class, args);
	}

}
