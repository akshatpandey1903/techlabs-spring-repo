package com.aurionpro.app.service;

import com.aurionpro.app.dto.CustomerRequestDto;
import com.aurionpro.app.dto.PageResponse;
import com.aurionpro.app.dto.TransactionRequestDto;
import com.aurionpro.app.dto.TransactionResponseDto;
import com.aurionpro.app.dto.UserResponseDto;

public interface CustomerService {
	UserResponseDto updateCustomerProfile(int customerId, CustomerRequestDto userRequestDto);
	PageResponse<TransactionResponseDto> getTransactions(int id, int pageNumber, int pageSize);
	TransactionResponseDto createTransaction(TransactionRequestDto transactionRequestDto);
}
