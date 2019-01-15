package com.sk.kmooc.purchase.domain.service;

import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sk.kmooc.purchase.application.sp.kafka.KafkaReceiver;
import com.sk.kmooc.purchase.application.sp.kafka.KafkaSender;
import com.sk.kmooc.purchase.domain.model.Buyer;
import com.sk.kmooc.purchase.domain.model.Purchase;
import com.sk.kmooc.purchase.domain.model.PurchaseItem;
import com.sk.kmooc.purchase.domain.model.Receiver;
import com.sk.kmooc.purchase.domain.model.MembershipLevelType;
import com.sk.kmooc.purchase.domain.model.Money;

import com.sk.kmooc.purchase.domain.proxy.AccountProxy;
import com.sk.kmooc.purchase.domain.proxy.ProductProxy;
import com.sk.kmooc.purchase.domain.proxy.dto.account.AccountDTO;
import com.sk.kmooc.purchase.domain.proxy.dto.product.ProductDTO;

@Service
public class OrderLogic implements OrderService {

	@Autowired
	private AccountProxy accountProxy;
	
	@Autowired
	private ProductProxy productProxy;
	
	@Autowired
	private KafkaSender kafkaSender;

	@Autowired
	private KafkaReceiver kafkaReceiver;
	
	@Override
	public Purchase Order(Long id, String purchaseNumber, String buyerName, String productName) {

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
		
		// Purchasse.TotalPrice
		//purchase.setPrice(new Money(item.getPrice().getValue()));

		System.out.println("PURCHASED DATA");
		System.out.println("Buyer name : " + buyer.getBuyerName());
		System.out.println("      membership level : " + buyer.getMembershipLevel().toString());
		System.out.println("Recevier name : " + receiver.getRecevierName() + ")");
		System.out.println("         Address : " + receiver.getAddress());
		System.out.println("         ZipCode : " + receiver.getZipCode());
		
		kafkaSender.send("Hello Spring Kafka!");
		
		try {
			kafkaReceiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
		}
		catch(Exception e) {
			
		}
		return purchase;
	}
}
