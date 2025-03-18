package com.aurionpro.app.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aurionpro.app.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer>{
	@Query("SELECT t FROM Transaction t WHERE t.senderAccno IN :accountNumbers OR t.receiverAccno IN :accountNumbers")
	Page<Transaction> findTransactionsByAccountNumbers(@Param("accountNumbers") List<String> accountNumbers, Pageable pageable);
}
