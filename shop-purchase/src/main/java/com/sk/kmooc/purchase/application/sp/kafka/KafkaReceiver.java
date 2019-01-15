package com.sk.kmooc.purchase.application.sp.kafka;

import java.util.concurrent.CountDownLatch;

import org.springframework.kafka.annotation.KafkaListener;

public class KafkaReceiver {

	private CountDownLatch latch = new CountDownLatch(1);

	public CountDownLatch getLatch() {
		return latch;
	}
	
	@KafkaListener(topics = "helloworld.t")
	public void receive(String payload) {
		
		System.out.println("KAFKA RECEIVED DATA --> " + payload);
		latch.countDown();
	}
}
