package com.sk.kmooc.product.domain.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.sk.kmooc.product.domain.model.Product;

@RepositoryRestResource
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

	Product findByName(@Param("name") String name);
}
