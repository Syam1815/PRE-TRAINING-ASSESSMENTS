package com.litmus7.vehiclerentalsystem.dto;

import com.litmus7.vehiclerentalsystem.VehicleApp;
import com.litmus7.vehiclerentalsystem.controller.VehicleController;
import com.litmus7.vehiclerentalsystem.service.VehicleService;

/**
 * The {@link Response} handles the various forms of responses in
 * {@link VehicleController} served from {@link VehicleService}. The responses
 * received from {@link VehicleController} supports the execution of the
 * {@link VehicleApp}.
 */
public class Response <Type> {
	private int statusCode;
	private String errorMessage;
	private String statusMessage;

	private Type vehicleData;

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
	 * @return the vehicleData
	 */
	public Type getVehicleData() {
		return vehicleData;
	}

	/**
	 * @param vehicles the vehicleData to set
	 */
	public void setVehicleData(Type vehicleData) {
		this.vehicleData = vehicleData;
	}

	


}