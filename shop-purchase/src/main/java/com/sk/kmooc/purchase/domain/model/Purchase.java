package com.sk.kmooc.purchase.domain.model;

import javax.persistence.Column;
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
public class Purchase {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String purchaseNumber;
	//private List<PurchaseItem> orderItems;
	private PurchaseItem purchaseItem;
//	private Money price;

	private Buyer buyer;
	private Receiver receiver;
}
