package com.aurionpro.crud.service;

import com.aurionpro.crud.dto.InstructorRequestDto;
import com.aurionpro.crud.dto.InstructorResponseDto;
import com.aurionpro.crud.dto.PageResponse;

public interface InstructorService {
	
	PageResponse<InstructorResponseDto> getAllInstructors(int pageSize, int pageNumber);
	InstructorResponseDto addInstructor(InstructorRequestDto requestDto);
	InstructorResponseDto getInstructorById(int id);
}
