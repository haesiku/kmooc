package com.sk.kmooc.delivery.activemq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sk.kmooc.delivery.domain.model.PurchaseCompleted;

public class PurchaseMessageConverter implements MessageConverter {

	ObjectMapper mapper;

	public PurchaseMessageConverter() {
		
		mapper = new ObjectMapper();
	}

	
	@Override
	public Object fromMessage(Message message) throws JMSException, MessageConversionException {

		TextMessage textMessage = (TextMessage) message;
	    String payload = textMessage.getText();
//	    LOGGER.info("inbound json='{}'", payload);

	    PurchaseCompleted purchase = null;
	    try {
	    	purchase = mapper.readValue(payload, PurchaseCompleted.class);
	    } catch (Exception e) {
//	      LOGGER.error("error converting to person", e);
	    }

	    return purchase;
	}

	@Override
	public Message toMessage(Object arg0, Session arg1) throws JMSException, MessageConversionException {
		// TODO Auto-generated method stub
		return null;
	}

}
