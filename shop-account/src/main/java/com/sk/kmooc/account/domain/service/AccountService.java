package com.sk.kmooc.account.domain.service;

import com.sk.kmooc.account.domain.model.Account;

public interface AccountService {

	Account findByName(String name);

}

