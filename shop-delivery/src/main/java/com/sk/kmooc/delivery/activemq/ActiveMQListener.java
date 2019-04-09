package com.sk.kmooc.delivery.activemq;

import javax.jms.JMSException;
//import javax.jms.Message;
import javax.jms.MessageListener;
import javax.validation.Valid;

import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.Resource;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.sk.kmooc.delivery.application.sp.config.ActiveMQConfig;
import com.sk.kmooc.delivery.domain.model.PurchaseCompleted;
import com.sk.kmooc.delivery.domain.service.DeliveryService;

@Component
public class ActiveMQListener { // implements MessageListener {

	@Autowired
	DeliveryService deliveryService;
	
	@Autowired
	ActiveMQConfig activeMQConfig;
	

	@JmsListener(destination = "${jms.PurchaseTopic}")//, subscription = "purchaseListener")
	public void receiveMessage(Object event) throws JMSException {
		
		System.out.println("=================================================================Listener : " + event.toString());

		Object obj = new ActiveMQTextMessage();	
		ActiveMQTextMessage msg = (ActiveMQTextMessage)event;
		System.out.println("=================================================================Listener : " + msg.getText());
		
		PurchaseMessageConverter converter = new PurchaseMessageConverter();
		PurchaseCompleted purchaseCompleted = (PurchaseCompleted)converter.fromMessage(msg);
		System.out.println("=================================================================Listener : " + purchaseCompleted.toString());

		boolean isDelete = purchaseCompleted.isDelete();
		
		if (isDelete) {
			
			deliveryService.deleteDelivery(purchaseCompleted.getId());
			System.out.println("deleted " + purchaseCompleted.getId());
			
		}
		else {
			
			deliveryService.acceptDelivery(purchaseCompleted);		
			
		}
	}

	@Bean // Serialize message content to json using TextMessage
	public MessageConverter jacksonJmsMessageConverter() {
		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		converter.setTargetType(MessageType.BYTES);
		converter.setTypeIdPropertyName("_type");
		return converter;
	}
/*
	@Override
	public void onMessage(Message message) {
		
		System.out.println("onMessage() : " + message.toString());
		//deliveryService.acceptDelivery(message);
	}
*/
}
