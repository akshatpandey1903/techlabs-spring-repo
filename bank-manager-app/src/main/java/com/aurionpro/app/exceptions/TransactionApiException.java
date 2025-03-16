package com.aurionpro.app.exceptions;

public class TransactionApiException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;

	public TransactionApiException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
