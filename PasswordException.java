package com.blz.junitlearning;

public class PasswordException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PasswordException(String check) {
		super(check);
	}
}