package com.aurionpro.app.dto;

import com.aurionpro.app.entity.TransactionType;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class TransactionRequestDto {
	@NotBlank(message = "Sender account number is required")
    private String senderAccno;
	
    private String receiverAccno;
    
    @Min(value = 1, message = "Amount must be at least 1")
    private double amount;
    
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;
    
    @NotBlank(message = "Description is required")
    @Size(max = 255, message = "Description cannot exceed 255 characters")
    private String description;
}



