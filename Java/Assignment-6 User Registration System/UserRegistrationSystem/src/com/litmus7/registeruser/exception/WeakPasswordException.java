package com.litmus7.registeruser.exception;

import java.util.InputMismatchException;

public class WeakPasswordException extends InputMismatchException{

	/**
	 * @param s
	 */
	public WeakPasswordException(String s) {
		super(s);
		// TODO Auto-generated constructor stub
	}

}
