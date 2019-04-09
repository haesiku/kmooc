package com.sk.kmooc.purchase.domain.service;

import java.util.Optional;

import javax.jms.JMSException;

import com.sk.kmooc.purchase.domain.model.Purchase;

public interface OrderService {
	
	public Purchase Order(Long id, String purchaseNumber, String buyerName, String productName) throws JMSException;
}
