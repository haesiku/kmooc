package com.sk.kmooc.account.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sk.kmooc.account.domain.model.Account;
import com.sk.kmooc.account.domain.repository.AccountRepository;

@Service
public class AccountLogic implements AccountService {

	@Autowired
	AccountRepository accountRepository;
	
	@Override
	public Account findByName(String name) {

		return accountRepository.findByName(name);
	}
}

