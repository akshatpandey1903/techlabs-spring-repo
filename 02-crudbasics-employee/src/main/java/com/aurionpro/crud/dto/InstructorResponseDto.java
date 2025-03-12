package com.aurionpro.crud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class InstructorResponseDto {
	
	private int instructorId;
	private String name;

	private String qualification;

	private int experience;
}
