package com.sk.kmooc.purchase.activemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.stereotype.Component;

import com.sk.kmooc.purchase.domain.model.PurchaseCompleted;


@Component
public class ActiveMQSender {

	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Value("${jms.PurchaseTopic}")
	private String puchaseTopic;

	
	@Bean
	public MessageConverter jacksonJmsMessageConverter() {
		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		converter.setTargetType(MessageType.TEXT);
		converter.setTypeIdPropertyName("_type");
		return converter;
	}

	public void sendEvent(PurchaseCompleted event, boolean isDelete) {
	
		jmsTemplate.convertAndSend(puchaseTopic, event); 
		//template.convertAndSend("jms.purchase", event); 
	} 

}
