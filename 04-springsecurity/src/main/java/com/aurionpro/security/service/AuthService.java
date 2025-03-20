package com.aurionpro.security.service;

import com.aurionpro.security.dto.LoginDto;
import com.aurionpro.security.dto.RegisterDto;
import com.aurionpro.security.entity.User;

public interface AuthService {
	User register(RegisterDto registerDto);
	String login(LoginDto loginDto);
}
