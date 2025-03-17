package com.aurionpro.app.exceptions;

public class AccountApiException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;

	public AccountApiException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
