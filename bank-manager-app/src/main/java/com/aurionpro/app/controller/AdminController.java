package com.aurionpro.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.app.dto.AccountRequestDto;
import com.aurionpro.app.dto.AccountResponseDto;
import com.aurionpro.app.dto.PageResponse;
import com.aurionpro.app.dto.TransactionResponseDto;
import com.aurionpro.app.dto.UserRequestDto;
import com.aurionpro.app.dto.UserResponseDto;
import com.aurionpro.app.service.AdminService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/bankapp/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/users")
	public ResponseEntity<UserResponseDto> createUser(@RequestBody @Valid UserRequestDto userRequestDto){
		return ResponseEntity.ok(adminService.createUser(userRequestDto));
	}
	
	 @PostMapping("/accounts/{userId}")
	 public ResponseEntity<AccountResponseDto> addAccountForUser(@PathVariable int userId, @RequestBody @Valid AccountRequestDto accountRequestDto) {
		 return ResponseEntity.ok(adminService.addAccountForUser(userId, accountRequestDto));
	 }
	 
	 @GetMapping("/users")
	 public ResponseEntity<PageResponse<UserResponseDto>> getAllCustomers(@RequestParam int pageNumber,@RequestParam int pageSize){
		 return ResponseEntity.ok(adminService.getAllUsers(pageNumber, pageSize));
	 }
	 
	 @GetMapping("/transactions")
	 public ResponseEntity<PageResponse<TransactionResponseDto>> getAllTransactions(@RequestParam int pageNumber,@RequestParam int pageSize){
		 return ResponseEntity.ok(adminService.getAllTransactions(pageNumber, pageSize));
	 }
}
