package com.aurionpro.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class UserRequestDto {
	
	private String name;
    private int age;
    private String username;
    private String password;
    private String email;
    private int roleId;
}
