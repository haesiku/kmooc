package com.sk.kmooc.product.domain.service;

import java.awt.Color;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sk.kmooc.product.domain.model.ColorType;
import com.sk.kmooc.product.domain.model.Money;
import com.sk.kmooc.product.domain.model.Product;
import com.sk.kmooc.product.domain.model.ProductDescription;
import com.sk.kmooc.product.domain.model.SizeType;
import com.sk.kmooc.product.domain.repository.ProductRepository;

@Service
public class SampleLogic {

	@Autowired
	ProductRepository productRepository;
	
	public void generateSampleData() {

		// Product #1 : 
		Product product = new Product();
		
		product.setName("Pants Set");
		
		Money price = new Money();
		price.setValue(12000);
		product.setPrice(price);
		
		ProductDescription description = new ProductDescription();
		description.setColor(ColorType.NAVY);
		description.setSize(SizeType.M);
		product.setProductDescription(description);

		productRepository.save(product);
	
	}
}

