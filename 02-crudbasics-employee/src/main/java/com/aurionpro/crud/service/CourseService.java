package com.aurionpro.crud.service;

import com.aurionpro.crud.dto.CourseRequestDto;
import com.aurionpro.crud.dto.CourseResponseDto;
import com.aurionpro.crud.dto.PageResponse;

public interface CourseService {
	
	PageResponse<CourseResponseDto> getAllCourses(int pageSize, int pageNumber);
	CourseResponseDto addCourse(CourseRequestDto requestDto);
	CourseResponseDto getCourseById(int id);
}
