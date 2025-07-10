package com.litmus7.retail.exception;

public class ProductServiceException extends  Exception {

	/**
	 * @param message
	 * @param cause
	 */
	public ProductServiceException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public ProductServiceException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
