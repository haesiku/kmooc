package com.sk.kmooc.product.domain.service;

import com.sk.kmooc.product.domain.model.Product;

public interface ProductService {

	Product findByName(String name);
}

