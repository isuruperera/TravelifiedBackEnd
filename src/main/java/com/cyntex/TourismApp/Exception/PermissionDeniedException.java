package com.cyntex.TourismApp.Exception;

public class PermissionDeniedException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public PermissionDeniedException(String message) {
		;
		this.message = message;
	}
	
	

}
