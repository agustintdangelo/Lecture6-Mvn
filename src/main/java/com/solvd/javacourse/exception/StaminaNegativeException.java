package com.solvd.javacourse.exception;

public class StaminaNegativeException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage() {
		return "StaminaNegativeException happened. The parameter that you entered must be positive!";
	}

}
