package com.aurionpro.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurionpro.app.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>{

}
