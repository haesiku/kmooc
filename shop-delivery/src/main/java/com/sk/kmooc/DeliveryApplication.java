package com.sk.kmooc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.hateoas.config.EnableHypermediaSupport;

import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;

//@Import(SpringDataRestConfiguration.class)
//@SpringBootApplication
//@EnableJpaAuditing
@Import(SpringDataRestConfiguration.class)
@SpringBootApplication
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
@EnableJpaAuditing
@ComponentScan({"com.sk.kmooc", "springfox"}) // ??
public class DeliveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeliveryApplication.class, args);
		
	}
}
