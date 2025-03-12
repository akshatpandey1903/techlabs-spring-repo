package com.aurionpro.crud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class CourseRequestDto {
	
	private String courseName;
	private double fees;
	private int duration;
}
