package com.aurionpro.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aurionpro.app.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>{
	@Query("SELECT a.accountNo FROM Account a WHERE a.user.id = :userId")
	List<String> findAccountNumbersByUserId(@Param("userId") int userId);
	
	Account findByAccountNo(String accountNo);
}
