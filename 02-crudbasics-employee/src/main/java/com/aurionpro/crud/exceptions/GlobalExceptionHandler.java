package com.aurionpro.crud.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.aurionpro.crud.error.EmployeeResponseError;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<EmployeeResponseError> handleApiException(EmployeeApiException e){
		EmployeeResponseError errorResponse = new EmployeeResponseError();
		errorResponse.setMessage(e.getMessage());
		errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		errorResponse.setTime(System.currentTimeMillis());
		
		return new ResponseEntity<EmployeeResponseError>(errorResponse, null, HttpStatus.NOT_FOUND.value());
	}
	
	@ExceptionHandler
	public ResponseEntity<?> validationExceptionHandler(MethodArgumentNotValidException e){
		
		Map<String, String> errors = new HashMap<>();
		e.getBindingResult().getFieldErrors().forEach((error) -> {
			errors.put(error.getField(), error.getDefaultMessage());
		});
		
		return new ResponseEntity<>(errors, null, HttpStatus.NOT_FOUND);
	}
}
