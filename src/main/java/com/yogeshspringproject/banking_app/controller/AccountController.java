package com.yogeshspringproject.banking_app.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yogeshspringproject.banking_app.dto.AccountDto;
import com.yogeshspringproject.banking_app.service.AccountService;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

	private AccountService accountService;

	@Autowired
	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}
	
	//Add Account REST API
	@PostMapping
	public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto)
	{
		return new ResponseEntity<>(accountService.createAccount(accountDto),HttpStatus.CREATED);
	}
	
	//get Account REST API
	@GetMapping("/{id}")
	public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id)
	{
		AccountDto accountDto = accountService.getAccountById(id);
		return ResponseEntity.ok(accountDto);
	} 
	
	//Deposit REST API
	@PutMapping("{id}/deposit")
		public ResponseEntity<AccountDto> deposit(@PathVariable Long id,
			@RequestBody Map<String, Double> request)
		{
			Double amount = request.get("amount");
			AccountDto accountDto = accountService.deposit(id, amount);
			return ResponseEntity.ok(accountDto);
		}
	
	//Withdrawl Rest API
	@PutMapping("{id}/withdraw")
	public ResponseEntity<AccountDto> withdraw(@PathVariable Long id,
			@RequestBody Map<String,Double> request)
	{
		double amount = request.get("amount");
		AccountDto accountDto = accountService.withdraw(id, amount);
		return ResponseEntity.ok(accountDto);
	}
	
	//Get all accounts Rest API
	@GetMapping
	public ResponseEntity<List<AccountDto>> getAllAccounts()
	{
		List<AccountDto> accounts= accountService.getAllAccounts();
		return ResponseEntity.ok(accounts);
	}
	
	//delete accounts by id Rest API
	@DeleteMapping("{id}/delete")
	public ResponseEntity<String> deleteAccount(@PathVariable Long id)
	{
		accountService.deleteAccount(id);
		return ResponseEntity.ok("Deleted!");
	}
}

