package com.sk.kmooc.delivery.application.sp.config;


import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListenerConfigurer;
import org.springframework.jms.config.JmsListenerEndpointRegistrar;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@EnableJms
@Configuration
public class ActiveMQConfig implements JmsListenerConfigurer {

    public static final String ORDER_QUEUE = "PurchaseTopic";//"order-queue";

    @Override
    public void configureJmsListeners(JmsListenerEndpointRegistrar registrar) {
        registrar.setMessageHandlerMethodFactory(methodFactory());
    }

    @Bean
    public DefaultMessageHandlerMethodFactory methodFactory() {
        DefaultMessageHandlerMethodFactory factory = new DefaultMessageHandlerMethodFactory();
        factory.setValidator(validatorFactory());
        return factory;
    }

    @Bean
    public Validator validatorFactory(){
        LocalValidatorFactoryBean factory = new LocalValidatorFactoryBean();
        factory.setProviderClass(HibernateValidator.class);
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

/*
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
*/