package com.sk.kmooc.account.application.sp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sk.kmooc.account.domain.model.Account;
import com.sk.kmooc.account.domain.model.Address;
import com.sk.kmooc.account.domain.model.MemberType;
import com.sk.kmooc.account.domain.model.MembershipLevelType;
import com.sk.kmooc.account.domain.service.AccountService;

@RestController
@RepositoryRestController
@RequestMapping("accounts")
public class AccountRepoController {


	@Autowired
	private AccountService accountService;

 	@GetMapping(value="{name}")
	public Account findByName(@PathVariable("name") String name) {
 		
// 		Account account = new Account();
// 		account.setId(1L);
// 		account.setName("Ryu Haesik");
// 		account.setMemberType(MemberType.BUYER);
// 		account.setMembershipLevel(MembershipLevelType.SILVER);
// 		
// 		CreditCard creditCard = new CreditCard();
// 		creditCard.setCardNumber("1234-5677-9012-3456");
// 		creditCard.setValidThru("1120");;
// 		account.setCreditCard(creditCard);
// 		
// 		Address address = new Address();
// 		address.setHomeAddress("Hansung Feel House");
// 		address.setZipCode(13457);
// 		account.setAddress(address);
// 		
// 		account.setEmail("hsryu@sk.com");
// 		return account;
 		
 		
		return accountService.findByName(name);
	}
	
	/*
	@Autowired
	private AccountService accountService;

 	@PutMapping("{id}")
	public ResponseEntity<?> updateBusiness(@PathVariable("id") Long id) {
		businessService.updateBusiness(id);
		return ResponseEntity.ok().build();
	}

	@GetMapping("{id}")
	public ResponseEntity<?> findByName(@PathVariable("id") Long id) {
		System.out.println("TEST");
		return ResponseEntity.ok().build();
	}
*/	
}
