package com.sk.kmooc.account.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sk.kmooc.account.domain.model.Account;
import com.sk.kmooc.account.domain.model.Address;
import com.sk.kmooc.account.domain.model.MemberType;
import com.sk.kmooc.account.domain.model.MembershipLevelType;
import com.sk.kmooc.account.domain.repository.AccountRepository;

@Service
public class SampleLogic {

	@Autowired
	AccountRepository accountRepository;
	
	public void generateSampleData() {

		// Account #1
		Account account = new Account();
		account.setId(1L);
		account.setName("Ryu Haesik");
		account.setMemberType(MemberType.BUYER);
		account.setMembershipLevel(MembershipLevelType.SILVER);
		
/*		CreditCard creditCard = new CreditCard();
		creditCard.setCardNumber("1234-5677-9012-3456");
		creditCard.setValidThru("1120");;
		account.setCreditCard(creditCard);
*/		
		Address address = new Address();
		address.setHomeAddress("Hansung Feel House");
		address.setZipCode(13457);
		account.setAddress(address);
	
		account.setEmail("hsryu@sk.com");

		accountRepository.save(account);
	
	}
}

