package com.sk.kmooc.delivery.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sk.kmooc.delivery.domain.model.Delivery;
import com.sk.kmooc.delivery.domain.model.DeliveryStatusType;
import com.sk.kmooc.delivery.domain.model.OrderedProduct;
import com.sk.kmooc.delivery.domain.model.PurchaseCompleted;
import com.sk.kmooc.delivery.domain.model.Recipient;
import com.sk.kmooc.delivery.domain.repository.DeliveryRepository;

@Service
public class DeliveryLogic implements DeliveryService{

	@Autowired	
	private DeliveryRepository deliveryRepositroy;
	
	@Override
	public Delivery findDelivery() {
		return (Delivery) deliveryRepositroy.findAll();
	}

	@Override
	public void acceptDelivery(PurchaseCompleted event) {
		
		Delivery delivery = new Delivery();
		delivery.setDeliveryStatus(DeliveryStatusType.PREPARING);
		Long num = (event.getTotalCount());
		delivery.setPurchaseNumber(num);
		OrderedProduct product = new OrderedProduct();
		
		product.setOrderNumber(event.getProductCount());
		product.setOrderProductName(event.getProductName());
		delivery.setOrderedProduct(product);
		
		Recipient recipient = new Recipient();
		recipient.setAddress(event.getAddress());
		recipient.setName(event.getRecevierName());
		recipient.setZipCode(event.getZipCode());
		delivery.setRecipient(recipient);
		
		addDelivery(delivery);
		
		System.out.println("Added " + event.getId());		
	}

	@Override
	public void addDelivery(Delivery delivery) {
		deliveryRepositroy.save(delivery);
		
	}

	@Override
	public void deleteDelivery(Long deliveryId) {
			
	}

}

