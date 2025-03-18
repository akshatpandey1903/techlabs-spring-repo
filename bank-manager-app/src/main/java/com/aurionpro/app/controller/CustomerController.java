package com.aurionpro.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.app.dto.CustomerRequestDto;
import com.aurionpro.app.dto.PageResponse;
import com.aurionpro.app.dto.TransactionRequestDto;
import com.aurionpro.app.dto.TransactionResponseDto;
import com.aurionpro.app.dto.UserResponseDto;
import com.aurionpro.app.service.CustomerService;

import jakarta.validation.Valid;


@RequestMapping("/bankapp/customer")
@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/{customerId}/transactions")
    public ResponseEntity<PageResponse<TransactionResponseDto>> getCustomerTransactions(
            @PathVariable int customerId,
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "2") int pageSize) {
        
        PageResponse<TransactionResponseDto> transactions = customerService.getTransactions(customerId, pageNumber, pageSize);
        return ResponseEntity.ok(transactions);
    }

	@PostMapping("/{customerId}/transactions")
    public ResponseEntity<TransactionResponseDto> createTransaction(
            @PathVariable int customerId,
            @RequestBody @Valid TransactionRequestDto transactionRequest) {
        
        TransactionResponseDto transactionResponse = customerService.createTransaction(transactionRequest);
        return ResponseEntity.ok(transactionResponse);
    }
	
	@PutMapping("/{customerId}")
    public ResponseEntity<UserResponseDto> updateCustomerProfile(
            @PathVariable int customerId,
            @RequestBody @Valid CustomerRequestDto customerRequest) {
        
        UserResponseDto updatedCustomer = customerService.updateCustomerProfile(customerId, customerRequest);
        return ResponseEntity.ok(updatedCustomer);
    }

}
