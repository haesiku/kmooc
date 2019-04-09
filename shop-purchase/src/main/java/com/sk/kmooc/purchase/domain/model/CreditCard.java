package com.sk.kmooc.purchase.domain.model;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@Data
public class CreditCard {
	
	private String cardNumber;
	private String validThru;
}
