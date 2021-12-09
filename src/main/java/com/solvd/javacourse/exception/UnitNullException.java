package com.solvd.javacourse.exception;

public class UnitNullException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "UnitNullException happened. The Unit parameter is null!";
	}

}
