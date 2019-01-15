package com.sk.kmooc.delivery.domain.model;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@Data
public class Recipient {

	private String name;
	private String address;
	private int zipCode;
	private String phoneNumber;
}
