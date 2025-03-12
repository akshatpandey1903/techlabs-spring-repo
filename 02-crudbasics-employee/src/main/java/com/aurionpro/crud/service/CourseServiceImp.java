package com.aurionpro.crud.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aurionpro.crud.dto.CourseRequestDto;
import com.aurionpro.crud.dto.CourseResponseDto;
import com.aurionpro.crud.dto.PageResponse;
import com.aurionpro.crud.entity.Course;
import com.aurionpro.crud.exceptions.CourseApiException;
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
	public PageResponse<CourseResponseDto> getAllCourses(int pageSize, int pageNumber) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		Page<Course> courses = null;
		
		courses = repo.findAll(pageable);
		
		List<Course> coursesList = courses.getContent();
		List<CourseResponseDto> courseDto = new ArrayList<>();
		for(Course course : coursesList) {
			courseDto.add(courseToResponse(course));
		}
		
		PageResponse<CourseResponseDto> pageResponse = new PageResponse<>();
		pageResponse.setContent(courseDto);
		pageResponse.setLast(courses.isLast());
		pageResponse.setPageSize(courses.getSize());
		pageResponse.setTotalPages(courses.getTotalPages());
		pageResponse.setTotalElements(courses.getTotalElements());
		return pageResponse;
	}

	@Override
	public CourseResponseDto getCourseById(int id) {
		Optional<Course> courseDb = repo.findById(id);
		
		if(courseDb.isEmpty()) {
			throw new CourseApiException("Course by this id does not exist");
		}
		
		CourseResponseDto responseDto = courseToResponse(courseDb.get());
		return responseDto;
	}

}
