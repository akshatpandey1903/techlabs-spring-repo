package com.aurionpro.app.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class UserRequestDto {
	
	@NotBlank(message = "Name input is compulsory")
	private String name;
	@Min(value = 18, message = "Minimum age must be 18")
    private int age;
	@NotBlank(message = "Username is required")
    @Size(min = 3, message = "Username must have at least 3 characters")
    private String username;
	@NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must have at least 6 characters")
    private String password;
	@NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;
    private int roleId;
}
