package com.litmus7.vehiclerentalsystem.exception;

/**
 * The class {@code VehicleDataAccessException} is a form of {@code Exception}
 * that indicates conditions that a reasonable application might want to catch
 * during accessing a file.
 */
public class VehicleDataAccessException extends Exception {

	/**
	 * Constructs a new exception with the specified detail message and the cause.
	 * 
	 * @param message The detail message.
	 * @param cause   The cause.
	 */
	public VehicleDataAccessException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructs a new exception with the specified detail message.
	 * 
	 * @param message The detail message.
	 */
	public VehicleDataAccessException(String message) {
		super(message);
	}

}
