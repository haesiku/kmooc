package com.sk.kmooc.product.domain.model;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@Data
public class ProductDescription {

	@Enumerated(EnumType.STRING)
	private ColorType colorType;
	
	@Enumerated(EnumType.STRING)
	private SizeType SizeType;
	
}

