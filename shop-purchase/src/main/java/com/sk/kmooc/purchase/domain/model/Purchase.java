package com.sk.kmooc.purchase.domain.model;

import java.io.Serializable;

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
public class Purchase implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)  
	private Long id;

	private String purchaseNumber;
	private PurchaseItem purchaseItem;
	private Long totalCount;
	private Buyer buyer;
	private Receiver receiver;
}
