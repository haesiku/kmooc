package com.sk.kmooc.purchase.application.sp.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

public class KafkaSender {
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	public void send(String payload) {
		
		kafkaTemplate.send("helloworld.t", payload);
		System.out.println("KafkaSender.send() : " + payload);
	}
}
