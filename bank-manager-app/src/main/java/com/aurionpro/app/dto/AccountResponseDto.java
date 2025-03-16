package com.aurionpro.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class AccountResponseDto {
	
	private int id;
	private int userId;
	private double balance;
	private String accountNo;
}
