package com.aurionpro.crud.exceptions;

public class InstructorApiException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;

	public InstructorApiException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
