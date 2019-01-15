package com.sk.kmooc.purchase.domain.proxy.dto.product;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@Data
public class ProductDescription {

	private ColorType color;
	private SizeType Size;
	
}
