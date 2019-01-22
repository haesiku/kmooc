package com.sk.kmooc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.hateoas.config.EnableHypermediaSupport;

import com.sk.kmooc.account.domain.model.Account;
import com.sk.kmooc.account.domain.model.Address;
import com.sk.kmooc.account.domain.model.MemberType;
import com.sk.kmooc.account.domain.model.MembershipLevelType;
import com.sk.kmooc.account.domain.service.SampleLogic;

import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;

@Import(SpringDataRestConfiguration.class)
@SpringBootApplication
@EnableJpaAuditing
public class AccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner generateSampleData(SampleLogic sampleLogic) {
		
		return (args) -> {
			
			sampleLogic.generateSampleData();
		};
	}
}
