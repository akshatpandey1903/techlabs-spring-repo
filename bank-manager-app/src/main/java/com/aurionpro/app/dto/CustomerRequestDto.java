package com.aurionpro.app.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class CustomerRequestDto {
	@Email(message = "Invalid email format")
    private String email;
	@Size(min = 3, message = "Username must have at least 3 characters")
    private String username;
	@Size(min = 6, message = "Password must have at least 6 characters")
    private String password;
}
