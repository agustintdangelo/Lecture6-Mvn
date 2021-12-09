package com.solvd.javacourse.exception;

public class WrongNameException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "WrongNameException happened. The name must include letters, can't be empty neither be only numbers!";
	}

}
