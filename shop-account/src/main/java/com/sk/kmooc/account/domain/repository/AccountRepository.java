package com.sk.kmooc.account.domain.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.sk.kmooc.account.domain.model.Account;

@RepositoryRestResource
public interface AccountRepository extends PagingAndSortingRepository<Account, Long> {

//	Optional<Account> findAccountByName(String name);
//	Optional<Account> findByEmailContaining(String email);
	
	Account findByName(@Param("name") String name);
}
