package com.sk.kmooc.product.domain.model;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@Data
public class ProductDescription {

	private ColorType colorType;
	private SizeType SizeType;
	
}

