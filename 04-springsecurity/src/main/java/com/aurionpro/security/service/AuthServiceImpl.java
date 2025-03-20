package com.aurionpro.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.aurionpro.security.dto.LoginDto;
import com.aurionpro.security.dto.RegisterDto;
import com.aurionpro.security.entity.Role;
import com.aurionpro.security.entity.User;
import com.aurionpro.security.exception.UserApiException;
import com.aurionpro.security.repository.RoleRepository;
import com.aurionpro.security.repository.UserRepository;
import com.aurionpro.security.security.JwtTokenProvider;

@Service
public class AuthServiceImpl implements AuthService{
	
	@Autowired
	private AuthenticationManager authManager;
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private RoleRepository roleRepo;
	@Autowired
	private JwtTokenProvider tokenProvider;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Override
	
	public User register(RegisterDto registerDto) {
		if(userRepo.existsByUsername(registerDto.getUsername())) {
			throw new UserApiException(HttpStatus.BAD_REQUEST, "username already exists");
		}
		
		User user = new User();
		user.setUsername(registerDto.getUsername());
		user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
		
		List<Role> roles = new ArrayList<>();
		Role userRole = roleRepo.findByRoleName(registerDto.getRole()).get();
		roles.add(userRole);
		user.setRoles(roles);
		return userRepo.save(user);
	}
	
	@Override
	public String login(LoginDto loginDto) {
		try {
			Authentication authentication = authManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
			SecurityContextHolder.getContext().setAuthentication(authentication);
			String token = tokenProvider.generateToken(authentication);
			return token;
		}catch(BadCredentialsException e) {
			throw new UserApiException(HttpStatus.NOT_FOUND, "Username or Password is incorrect");
		}
	}
	
	
}
