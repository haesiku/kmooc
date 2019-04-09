package com.sk.kmooc.delivery.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Delivery {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Long purchaseNumber;
	private Recipient recipient;
	private OrderedProduct orderedProduct;
	private DeliveryStatusType deliveryStatus;
	

}
