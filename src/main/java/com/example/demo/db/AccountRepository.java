package com.example.demo.db;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.bean.Account;

public interface AccountRepository extends CrudRepository<Account, Long>{
	public Account findByName(String name);
	
	public Optional<Account> findById(Long id);
	
	public Account findByBalance(double balance);
}
