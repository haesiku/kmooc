package com.sk.kmooc.product.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sk.kmooc.product.domain.model.Product;
import com.sk.kmooc.product.domain.repository.ProductRepository;

@Service
public class ProductLogic implements ProductService {

	@Autowired
	ProductRepository productRepository;
	
	@Override
	public Product findByName(String name) {
		
		return productRepository.findByName(name);
	}
}


