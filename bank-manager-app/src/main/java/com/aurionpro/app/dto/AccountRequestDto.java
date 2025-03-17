package com.aurionpro.app.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class AccountRequestDto {
	
	@NotNull(message = "Balance is required")
	@Min(value = 500, message = "Minimum balance of 500 is needed")
	private double balance;
}
