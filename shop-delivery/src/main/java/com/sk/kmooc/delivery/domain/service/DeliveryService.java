package com.sk.kmooc.delivery.domain.service;

import com.sk.kmooc.delivery.domain.model.Delivery;
import com.sk.kmooc.delivery.domain.model.PurchaseCompleted;

public interface DeliveryService {

	public Delivery findDelivery();
	public void acceptDelivery(PurchaseCompleted event);
	public void addDelivery(Delivery delivery);
	public void deleteDelivery(Long deliveryId);

}


