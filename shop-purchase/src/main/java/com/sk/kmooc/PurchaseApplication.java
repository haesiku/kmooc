package com.sk.kmooc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.hateoas.config.EnableHypermediaSupport;

import com.sk.kmooc.purchase.domain.service.OrderLogic;

import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;

@Import(SpringDataRestConfiguration.class)
@SpringBootApplication
@EnableFeignClients
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
@EnableJpaAuditing
@ComponentScan({"com.sk.kmooc", "springfox"}) // ??
public class PurchaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(PurchaseApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner order(OrderLogic orderLogic) {
		
		return (args) -> {
			
			orderLogic.Order(1L, "11001", "Ryu Haesik", "Pants Set");
		};
	}
}
