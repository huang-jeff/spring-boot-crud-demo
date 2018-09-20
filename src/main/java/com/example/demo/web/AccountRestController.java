package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.Account;
import com.example.demo.db.AccountRepository;

@RestController
@RequestMapping("/api")
public class AccountRestController {
	
	@Autowired
	private final AccountRepository repository;
	
	public AccountRestController(AccountRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/accounts")
	public Iterable<Account> getAccounts() {
		return this.repository.findAll();
	}
}
