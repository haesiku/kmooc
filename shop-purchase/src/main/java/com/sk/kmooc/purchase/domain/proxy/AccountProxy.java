package com.sk.kmooc.purchase.domain.proxy;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.feign.FeignClientProperties.FeignClientConfiguration;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.sk.kmooc.purchase.domain.proxy.dto.account.AccountDTO;

@Service
public class AccountProxy {

	@Autowired
	AccountDTOClient accountDTOClient;
	
	public AccountDTO findAccountDTO(Long id) {
		return accountDTOClient.findAccount(id).getContent();
	}

	public Collection<AccountDTO> findAllAccountDTOs() {
		return accountDTOClient.findAllAccounts().getContent();
	}
	
	public Collection<AccountDTO> findAllAccountDTOs(int size) {
		return accountDTOClient.findAllAccounts(size).getContent();
	}
	
	public AccountDTO findAccounByName(String name) {
		return accountDTOClient.findAccount(name);
	}

	@FeignClient(name="accounts", url="${service-urls.shop-account}", configuration=FeignClientConfiguration.class)
	interface AccountDTOClient {
		
		@GetMapping("accounts/{id}")
		Resource<AccountDTO> findAccount(@PathVariable("id") Long id);
		
		@GetMapping("accounts")
		Resources<AccountDTO> findAllAccounts();
		
		@GetMapping("accounts")
		Resources<AccountDTO> findAllAccounts(@RequestParam("size") int size);
		
		@GetMapping("accounts/search/findByName")
		AccountDTO findAccount(@RequestParam(value="name", required=true) String name);
	}
}
