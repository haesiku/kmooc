package com.sk.kmooc.delivery.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.sk.kmooc.delivery.domain.model.Delivery;

@RepositoryRestResource
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {

}
