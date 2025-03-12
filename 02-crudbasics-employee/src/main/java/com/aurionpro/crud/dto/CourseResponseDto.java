package com.aurionpro.crud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class CourseResponseDto {
	
	private int courseId;
	private String courseName;
	private double fees;
	private int duration;
}
