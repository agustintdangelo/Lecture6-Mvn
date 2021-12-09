package com.solvd.javacourse.exception;

public class HealthNegativeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "HealthNegativeException happened. The parameter that you entered must be positive!";
	}

}
