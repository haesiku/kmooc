package com.sk.kmooc.purchase.application.sp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.auth.BasicAuthRequestInterceptor;

//@Configuration
public class FeignClientConfig {
	
	/*@Value("${feign.client.id}")
	private String id;
	
	@Value("${feign.client.pw}")
	private String pw;

	@Bean
	public BasicAuthRequestInterceptor basicAuthRequestIntercepter() {
		return new BasicAuthRequestInterceptor(id, pw);
	}
*/
}
