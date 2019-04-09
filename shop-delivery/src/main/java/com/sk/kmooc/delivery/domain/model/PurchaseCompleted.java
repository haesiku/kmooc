package com.sk.kmooc.delivery.domain.model;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PurchaseCompleted implements Serializable {

	private Long id;
	boolean isDelete = false ;
	  
	private String productName;
	private Long productCount;
	
	private String recevierName;
	private String address;
	private int zipCode;
	
	private Long totalCount;
}
