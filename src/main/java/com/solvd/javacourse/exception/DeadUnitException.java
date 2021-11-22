package com.solvd.javacourse.exception;

public class DeadUnitException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "DeadUnitException happened. You can't heal a dead unit!";
	}
}
