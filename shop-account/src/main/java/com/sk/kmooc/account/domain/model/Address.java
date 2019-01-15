package com.sk.kmooc.account.domain.model;

import javax.persistence.Embeddable; // ? value object

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@Data
public class Address {

	private String homeAddress;
	private int zipCode;
}
