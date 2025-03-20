package com.aurionpro.security.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class RegisterDto {
	private String username;
	private String password;
	private String role;
}
