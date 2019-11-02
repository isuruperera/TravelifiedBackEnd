package com.cyntex.TourismApp.Exception;

public class DataMismatchException extends Exception{

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
	
	public DataMismatchException(String message) {
		this.message = message;
	}
	
	

}
