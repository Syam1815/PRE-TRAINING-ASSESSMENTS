package com.litmus7.vehiclerentalsystem.controller;

import java.io.File;
import java.util.List;

import com.litmus7.vehiclerentalsystem.VehicleApp;
import com.litmus7.vehiclerentalsystem.dto.Response;
import com.litmus7.vehiclerentalsystem.dto.Vehicle;
import com.litmus7.vehiclerentalsystem.exception.VehicleServiceException;
import com.litmus7.vehiclerentalsystem.service.VehicleService;

/**
 * The class interacts with the {@link VehicleApp} facilitate the following
 * functionalities .
 * <ul>
 * <li>Loading vehicles from file.</li>
 * <li>Adding new a new vehicle, restricting duplicate entry.</li>
 * <li>Renting and returning a vehicle.</li>
 * <li>Searching for a vehicle by brand/model.</li>
 * </ul>
 * Status codes are used to represent the status of the methods. Performs
 * validations for all functions. Exceptions thrown from
 * {@link VehicleServiceException} are handled here.
 */
public class VehicleController {
	final static int SUCCESS_STATUS_CODE = 200;
	final static int ERROR_STATUS_CODE = 201;

	final static int ADD_SUCCESS_CODE = 202;
	final static int ADD_FAIL_CODE = 203;

	final static int SEARCH_SUCCESS_CODE = 204;
	final static int SEARCH_FAIL_CODE = 205;

	final static int RENT_SUCCESS_CODE = 206;
	final static int RENT_FAIL_CODE = 207;

	final static int UNRENT_SUCCESS_CODE = 208;
	final static int UNRENT_FAIL_CODE = 209;

	final static int INVALID_DATA = 299;

	private VehicleService vehicleService = new VehicleService();

	/**
	 * Loads the vehicle data from file. The list of vehicles are returned on
	 * successful execution. Otherwise the error message is returned as response.
	 * 
	 * @param vehicles
	 * @param filepath The file name/path where the data is stored.
	 * @return Response to indicate the corresponding status of the the operation.
	 */
	public Response <List<Vehicle>> getAllVehiclesFromFile(List<Vehicle> vehicles, String filepath) {
		Response<List<Vehicle>> response = new Response<List<Vehicle>>();

		// filepath is null or empty
		if (filepath == null || filepath.trim().isEmpty()) {
			response.setStatusCode(INVALID_DATA);
			response.setErrorMessage("File Name cannot be empty");
			return response;
		}

		filepath = filepath.trim(); // to remove trailing spaces if any
		File file = new File(filepath);

		// checking the existence of file
		if (!file.exists()) {
			response.setStatusCode(INVALID_DATA);
			response.setErrorMessage("File doesnt exist");
			return response;
		}
		if (!file.canRead()) {
			response.setStatusCode(INVALID_DATA);
			response.setErrorMessage("File not permissioned to read");
			return response;
		}

		try {
			vehicles = vehicleService.getAllVehiclesFromFile(vehicles, filepath);
			response.setStatusCode(SUCCESS_STATUS_CODE);
			response.setVehicleData(vehicles);
		} catch (VehicleServiceException e) {
			response.setStatusCode(ERROR_STATUS_CODE);
			response.setErrorMessage("Could not load the vehicle information from file");
		}
		return response;
	}

	/**
	 * Appends a vehicle to the list.
	 * 
	 * @param vehicles
	 * @param vehicle  The vehicle to be added.
	 * @return Response to indicate the corresponding status of the the operation.
	 */
	public Response<List<Vehicle>> addVehicle(List<Vehicle> vehicles, Vehicle vehicle) {
		Response<List<Vehicle>> response = new Response<List<Vehicle>>();

		if (vehicle == null) {
			response.setStatusCode(INVALID_DATA);
			response.setErrorMessage("Empty vehicle details");
			return response;
		}

		try {
			String status = vehicleService.addVehicle(vehicles, vehicle);
			response.setStatusCode(ADD_SUCCESS_CODE);
			response.setVehicleData(vehicles);
			response.setStatusMessage(status);
		} catch (VehicleServiceException e) {
			response.setStatusCode(ADD_FAIL_CODE);
			response.setErrorMessage("Duplicate vehicle entry restricted!");
		}
		return response;
	}

	/**
	 * Finds a vehicle by it brand/model. Returns the the vehicle on success.
	 * Otherwise error message.
	 * 
	 * @param vehicleList
	 * @param findVehicle The brand or model of the vehicle to be searched.
	 * @return Response to indicate the corresponding status of the the operation.
	 */
	public Response<Vehicle> searchVehicleByBrandOrModel(List<Vehicle> vehicleList, String findVehicle) {
		Response<Vehicle> response = new Response<Vehicle>();

		if (findVehicle == null || findVehicle.trim().isEmpty()) {
			response.setStatusCode(INVALID_DATA);
			response.setErrorMessage("Brand/Model cannot be empty");
			return response;
		}
		findVehicle = findVehicle.trim();
		try {
			Vehicle vehicle = vehicleService.searchVehicleByBrandOrModel(vehicleList, findVehicle);
			response.setStatusCode(SEARCH_SUCCESS_CODE);
			response.setVehicleData(vehicle);
			response.setStatusMessage("Vehicle found successfully");
		} catch (VehicleServiceException e) {
			response.setStatusCode(SEARCH_FAIL_CODE);
			response.setErrorMessage(e.getMessage());
		}
		return response;

	}

	/**
	 * Rents a vehicle. Otherwise returns the reason for failed renting.
	 * 
	 * @param vehicleList
	 * @param model       The model of the vehicle to be rented.
	 * @return Response to indicate the corresponding status of the the operation.
	 */
	public Response<String> rentVehicle(List<Vehicle> vehicleList, String model) {
		Response<String> response = new Response<String>();

		if (model == null || model.trim().isEmpty()) {
			response.setStatusCode(INVALID_DATA);
			response.setErrorMessage("Model cannot be empty");
			return response;
		}
		model = model.trim();
		try {
			String status = vehicleService.rentVehicle(vehicleList, model);
			response.setStatusCode(RENT_SUCCESS_CODE);
			response.setStatusMessage(status);
		} catch (VehicleServiceException e) {
			response.setStatusCode(RENT_FAIL_CODE);
			response.setErrorMessage(e.getMessage());
		}
		return response;
	}

	/**
	 * Returns a rented vehicle.
	 * 
	 * @param vehicleList
	 * @param model       The model of the vehicle rented that is to be returned.
	 * @return Response to indicate the corresponding status of the the operation.
	 */
	public Response<String> returnRentedVehicle(List<Vehicle> vehicleList, String model) {
		Response<String> response = new Response<String>();
		if (model == null || model.trim().isEmpty()) {
			response.setStatusCode(INVALID_DATA);
			response.setErrorMessage("Model cannot be empty");
			return response;
		}
		model = model.trim();
		try {
			String status = vehicleService.returnRentedVehicle(vehicleList, model);
			response.setStatusCode(UNRENT_SUCCESS_CODE);
			response.setStatusMessage(status);
		} catch (VehicleServiceException e) {
			response.setStatusCode(UNRENT_FAIL_CODE);
			response.setErrorMessage(e.getMessage());
		}
		return response;
	}

}
