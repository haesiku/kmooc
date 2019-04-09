package com.sk.kmooc.purchase.application.sp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

public class ActiveMQConfig {

	@Bean
	public JmsListenerContainerFactory<?> queueListenerFactory() {
	
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		factory.setMessageConverter(messageConverter());
		
		return factory;
	}

	@Bean
	public MessageConverter messageConverter() {
	
		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		converter.setTargetType(MessageType.TEXT);
		converter.setTypeIdPropertyName("_type");
		
		return converter;
	}
}
