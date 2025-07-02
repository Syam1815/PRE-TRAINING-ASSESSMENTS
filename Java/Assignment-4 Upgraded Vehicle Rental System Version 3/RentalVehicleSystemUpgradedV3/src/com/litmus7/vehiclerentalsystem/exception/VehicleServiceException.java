package com.litmus7.vehiclerentalsystem.exception;

/**
 * The class {@code VehicleServiceException} is a form of {@code Exception} that
 * indicates conditions that a reasonable application might want to catch during
 * the execution of vehicle service functionalities.
 */
public class VehicleServiceException extends Exception {

	/**
	 * Constructs a new exception with the specified detail message and the cause.
	 * 
	 * @param message The detail message.
	 * @param cause   The cause.
	 */
	public VehicleServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructs a new exception with the specified detail message.
	 * 
	 * @param message The detail message.
	 */
	public VehicleServiceException(String message) {
		super(message);
	}

}
