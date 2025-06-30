package com.litmus7.vehiclerentalsystem.dto;

import java.util.List;

/**
 * The {@link Response} handles the various forms of responses in
 * {@link VehicleController} served from {@link VehicleService}. The responses
 * received from {@link VehicleController} supports the execution of the
 * {@link VehicleApp}.
 */
public class Response {
	private int statusCode;
	private String errorMessage;
	private String statusMessage;
	private boolean canRent;
	private Vehicle vehicle;
	private List<Vehicle> vehicles;

	/**
	 * @return the statusCode
	 */
	public int getStatusCode() {
		return statusCode;
	}

	/**
	 * @param statusCode the statusCode to set
	 */
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * @return the statusMessage
	 */
	public String getStatusMessage() {
		return statusMessage;
	}

	/**
	 * @param statusMessage the statusMessage to set
	 */
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	/**
	 * @return the canRent
	 */
	public boolean isCanRent() {
		return canRent;
	}

	/**
	 * @param canRent the canRent to set
	 */
	public void setCanRent(boolean canRent) {
		this.canRent = canRent;
	}

	/**
	 * @return the vehicle
	 */
	public Vehicle getVehicle() {
		return vehicle;
	}

	/**
	 * @param vehicle the vehicle to set
	 */
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	/**
	 * @return the vehicles
	 */
	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	/**
	 * @param vehicles the vehicles to set
	 */
	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

}