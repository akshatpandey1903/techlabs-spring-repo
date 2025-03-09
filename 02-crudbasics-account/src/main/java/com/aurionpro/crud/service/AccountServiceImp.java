package com.aurionpro.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurionpro.crud.entity.Account;
import com.aurionpro.crud.repository.AccountRepository;

@Service
public class AccountServiceImp implements AccountService{
	
	@Autowired
	private AccountRepository accountRepo;
	
	@Override
	public List<Account> getAllAccounts() {
		// TODO Auto-generated method stub
		List<Account> accounts = accountRepo.findAll();
		return accounts;
	}

}
