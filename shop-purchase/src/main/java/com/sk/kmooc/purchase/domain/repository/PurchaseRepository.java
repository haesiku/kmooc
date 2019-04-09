package com.sk.kmooc.purchase.domain.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.sk.kmooc.purchase.domain.model.Purchase;

@RepositoryRestResource
public interface PurchaseRepository extends PagingAndSortingRepository<Purchase, Long> {

	/*
	void order(
			@Param("id") Long id,
			@Param("purchaseNumber") String purchaseNumber,
			@Param("buyerName") String buyerName,
			@Param("productName") String productName);
	*/
}
