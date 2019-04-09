package com.sk.kmooc.purchase.domain.proxy.dto.account;

import com.sk.kmooc.purchase.domain.model.MembershipLevelType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
public class AccountDTO {

	private String name;
	private MemberType memberType;
	private MembershipLevelType membershipLevel;
	private Address address;
	private String email;
}

