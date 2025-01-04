package com.yogeshspringproject.banking_app.mapper;

import com.yogeshspringproject.banking_app.dto.AccountDto;
import com.yogeshspringproject.banking_app.entity.Account;

public class AccountMapper {
public static Account mapToAccount(AccountDto accountDto) {
	Account account = new Account(
			accountDto.getId(),
			accountDto.getAccountHolderName(),
			accountDto.getBalance()
			);
	return account;

}
public static AccountDto mapToAccountDto(Account account)
{
	AccountDto accountDto = new AccountDto(
			account.getId(),
			account.getAccountHolderName(),
			account.getBalance()
			);
	return accountDto;
}
}
