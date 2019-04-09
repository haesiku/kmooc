package com.sk.kmooc.purchase.domain.service;

import javax.jms.JMSException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sk.kmooc.purchase.activemq.ActiveMQSender;
//import com.sk.kmooc.purchase.activemq.Consumer;
//import com.sk.kmooc.purchase.activemq.Producer;
import com.sk.kmooc.purchase.domain.model.Buyer;
import com.sk.kmooc.purchase.domain.model.Purchase;
import com.sk.kmooc.purchase.domain.model.PurchaseCompleted;
import com.sk.kmooc.purchase.domain.model.PurchaseItem;
import com.sk.kmooc.purchase.domain.model.Receiver;
import com.sk.kmooc.purchase.domain.model.Money;

import com.sk.kmooc.purchase.domain.proxy.AccountProxy;
import com.sk.kmooc.purchase.domain.proxy.ProductProxy;
import com.sk.kmooc.purchase.domain.proxy.dto.account.AccountDTO;
import com.sk.kmooc.purchase.domain.proxy.dto.product.ProductDTO;
import com.sk.kmooc.purchase.domain.repository.PurchaseRepository;

@Service
public class OrderLogic implements OrderService {

	@Autowired
	private AccountProxy accountProxy;
	
	@Autowired
	private ProductProxy productProxy;
	
	@Autowired
	private PurchaseRepository purchaseRepository;
	
	@Autowired
	private ActiveMQSender activeMQSender;
	
	
	//private static Producer producer;
	//private static Consumer consumer;

	
	@Override
	public Purchase Order(Long id, String purchaseNumber, String buyerName, String productName) throws JMSException {

		
		// Account
		System.out.println("RECEIVED DATA");
		AccountDTO accountDTO = accountProxy.findAccounByName(buyerName);
		System.out.println("Account : " + accountDTO.toString());
		 
		// Product
		ProductDTO productDTO = productProxy.findProductByName(productName);
		System.out.println("Product : " + productDTO.toString());

		// Purchase
		Purchase purchase = new Purchase();
		 
		// Purchasse.PurchaseNumber
		purchase.setId(id);
		purchase.setPurchaseNumber(purchaseNumber);
		 
		// Purchasse.PurchaseItem
		PurchaseItem item = new PurchaseItem();
		item.setProductName(productDTO.getName());
		item.setCount(1L);
		item.setPrice(new Money(productDTO.getPrice().getValue()));
		purchase.setPurchaseItem(item);
		 
		// Purchasse.Buyer
		Buyer buyer = new Buyer();
		buyer.setBuyerName(accountDTO.getName());
		buyer.setMembershipLevel(accountDTO.getMembershipLevel());
		purchase.setBuyer(buyer);
		 
		// Purchasse.Receiver
		Receiver receiver = new Receiver();
		receiver.setRecevierName(accountDTO.getName());
		receiver.setAddress(accountDTO.getAddress().getHomeAddress());
		receiver.setZipCode(accountDTO.getAddress().getZipCode());
		purchase.setReceiver(receiver);
		
		purchase.setTotalCount(1L);
		
		System.out.println("PURCHASED DATA");
		System.out.println("Buyer name : " + buyer.getBuyerName());
		System.out.println("      membership level : " + buyer.getMembershipLevel().toString());
		System.out.println("Recevier name : " + receiver.getRecevierName() + ")");
		System.out.println("         Address : " + receiver.getAddress());
		System.out.println("         ZipCode : " + receiver.getZipCode());
			 
		//구매 저장 
		purchaseRepository.save(purchase);
 
		//구매완료됨 이벤트 생성 
		PurchaseCompleted event = new PurchaseCompleted();
		event.setId(purchase.getId());  
		event.setProductName(purchase.getPurchaseItem().getProductName());
		event.setProductCount(purchase.getTotalCount());
		event.setRecevierName(purchase.getReceiver().getRecevierName());
		event.setAddress(purchase.getReceiver().getAddress());
		event.setZipCode(purchase.getReceiver().getZipCode());
		event.setTotalCount(purchase.getTotalCount());

		event.setDelete(false);

		//이벤트 보내기 
		activeMQSender.sendEvent(event, false);

		/* Producer & Comsumer test
		producer = new Producer();
		producer.create("hello.q");
		
		consumer = new Consumer();
		consumer.create("hello.q");

		producer.sendName("HS", "Ryu");
		String greeting = consumer.getGreeting(1000);
		System.out.println("Consumer : " + greeting);
		
		producer.close();
		consumer.close();
		*/
		return purchase;
	}

}

