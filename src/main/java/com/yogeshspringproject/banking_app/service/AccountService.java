package com.yogeshspringproject.banking_app.service;

import java.util.List;

import com.yogeshspringproject.banking_app.dto.AccountDto;


public interface AccountService {

	AccountDto createAccount(AccountDto accountDto);
	AccountDto getAccountById(Long id);
	AccountDto deposit(Long id,double amount);
	AccountDto withdraw(Long id,double amount);
	List<AccountDto> getAllAccounts();
	void deleteAccount(Long id);
}
