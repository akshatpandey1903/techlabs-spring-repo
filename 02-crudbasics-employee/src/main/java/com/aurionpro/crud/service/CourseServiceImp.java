package com.aurionpro.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurionpro.crud.dto.CourseRequestDto;
import com.aurionpro.crud.dto.CourseResponseDto;
import com.aurionpro.crud.dto.PageResponse;
import com.aurionpro.crud.entity.Course;
import com.aurionpro.crud.repository.CourseRepository;

@Service
public class CourseServiceImp implements CourseService{

	@Autowired
	private CourseRepository repo;
	
	@Override
	public CourseResponseDto addCourse(CourseRequestDto requestDto) {
		Course dbCourse = repo.save(requestToCourse(requestDto));
		return courseToResponse(dbCourse);
	}
	
	private Course requestToCourse(CourseRequestDto requestDto) {
		Course course = new Course();
		course.setCourseName(requestDto.getCourseName());
		course.setDuration(requestDto.getDuration());
		course.setFees(requestDto.getFees());
		return course;
	}
	
	private CourseResponseDto courseToResponse(Course course) {
		CourseResponseDto responseDto = new CourseResponseDto();
		responseDto.setCourseId(course.getCourseId());
		responseDto.setDuration(course.getDuration());
		responseDto.setFees(course.getFees());
		responseDto.setCourseName(course.getCourseName());
		return responseDto;
	}

	@Override
	public PageResponse<CourseResponseDto> getAllEmployees(int pageSize, int pageNumber) {
		// TODO Auto-generated method stub
		return null;
	}

}
