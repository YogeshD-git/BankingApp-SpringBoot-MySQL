package com.yogeshspringproject.banking_app.service.Impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yogeshspringproject.banking_app.dto.AccountDto;
import com.yogeshspringproject.banking_app.entity.Account;
import com.yogeshspringproject.banking_app.mapper.AccountMapper;
import com.yogeshspringproject.banking_app.repository.AccountRepository;
import com.yogeshspringproject.banking_app.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{

	private AccountRepository accountRepository;
	
	@Autowired
	public AccountServiceImpl(AccountRepository accountRepository) {		
		this.accountRepository = accountRepository;
	}


	@Override
	public AccountDto createAccount(AccountDto accountDto) {
		Account account = AccountMapper.mapToAccount(accountDto);
		Account savedAccount = accountRepository.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}


	@Override
	public AccountDto getAccountById(Long id) {
		Account account = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account does not exist!"));
		return AccountMapper.mapToAccountDto(account);
	}


	@Override
	public AccountDto deposit(Long id, double amount) {
		Account account = accountRepository
				.findById(id)
				.orElseThrow(()-> new RuntimeException("Account does not exist!"));
			double total = account.getBalance() + amount;
			account.setBalance(total);
			Account savedAccount = accountRepository.save(account);
			return AccountMapper.mapToAccountDto(savedAccount);		
	}


	@Override
	public AccountDto withdraw(Long id, double amount) {
		Account account = accountRepository
				.findById(id)
				.orElseThrow(()-> new RuntimeException("Account does not exist!"));
		if(account.getBalance() < amount)
		{
			throw new RuntimeException("Insufficient Ammount");
		}
	
		double	total = account.getBalance() - amount;
		account.setBalance(total);
		Account savedAccount = accountRepository.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}


	@Override
	public List<AccountDto> getAllAccounts() {
		List<Account> accounts = accountRepository.findAll();
		return accounts.stream().map((account) -> AccountMapper.mapToAccountDto(account)).collect(Collectors.toList());
	}


	@Override
	public void deleteAccount(Long id) {
		Account account = accountRepository
				.findById(id)
				.orElseThrow(()-> new RuntimeException("Account does not exist!"));
		if(account!=null)
			accountRepository.deleteById(id);;
	}
	

}
