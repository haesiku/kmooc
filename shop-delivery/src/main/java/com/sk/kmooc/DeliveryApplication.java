package com.sk.kmooc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;

@Import(SpringDataRestConfiguration.class)
@SpringBootApplication
@EnableJpaAuditing
public class DeliveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeliveryApplication.class, args);
	}
}
