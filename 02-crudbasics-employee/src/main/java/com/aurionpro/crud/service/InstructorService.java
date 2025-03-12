package com.aurionpro.crud.service;

import com.aurionpro.crud.dto.InstructorRequestDto;
import com.aurionpro.crud.dto.InstructorResponseDto;

public interface InstructorService {
	
	InstructorResponseDto addInstructor(InstructorRequestDto requestDto);
}
