package com.sk.kmooc.delivery.domain.model;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@Data
public class OrderedProduct {

	private Long orderNumber;
	private String orderProductName; 
}
