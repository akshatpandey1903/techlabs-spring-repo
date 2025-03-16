package com.aurionpro.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurionpro.app.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer>{

}
