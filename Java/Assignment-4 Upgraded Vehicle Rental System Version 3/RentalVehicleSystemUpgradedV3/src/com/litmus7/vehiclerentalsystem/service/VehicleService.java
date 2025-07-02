package com.litmus7.vehiclerentalsystem.service;

import java.util.List;

import com.litmus7.vehiclerentalsystem.dao.VehicleFileDao;
import com.litmus7.vehiclerentalsystem.dto.Vehicle;
import com.litmus7.vehiclerentalsystem.exception.VehicleDataAccessException;
import com.litmus7.vehiclerentalsystem.exception.VehicleServiceException;

/**
 * Interacts with {@link com.litmus7.vehiclerentalsystem.controller.VehicleController} to provides core functionalities to
 * be performed on them. They include
 * <ul>
 * <li>Loading vehicles from file by invoking {@link VehicleFileDao} and handles
 * the {@link VehicleDataAccessException}</li>
 * <li>Adding new a new vehicle, restricting duplicate entry.</li>
 * <li>Renting and returning a vehicle</li>
 * <li>Searching for a vehicle by brand/model</li>
 * </ul>
 * Throws {@link VehicleServiceException} on encountering any issues.
 */
public class VehicleService {
	private VehicleFileDao vehicleFileDao = new VehicleFileDao();

	/**
	 * Loads the data from file.
	 * 
	 * @param vehicles
	 * @param filepath
	 * @return The list of vehicles.
	 * @throws VehicleServiceException
	 */
	public List<Vehicle> getAllVehiclesFromFile(List<Vehicle> vehicles, String filepath)
			throws VehicleServiceException {
		try {
			vehicles = vehicleFileDao.loadVehiclesFromFile(filepath);
		} catch (VehicleDataAccessException e) {
			throw new VehicleServiceException(e.getMessage(), e);
		}
		return vehicles;
	}

	/**
	 * Adds a new vehicle.
	 * 
	 * @param vehicles
	 * @param vehicle
	 * @return The status of execution
	 * @throws VehicleServiceException
	 */
	public String addVehicle(List<Vehicle> vehicles, Vehicle vehicle) throws VehicleServiceException {
		if (!vehicles.contains(vehicle)) {
			vehicles.add(vehicle);
			return "Vehicle added successfully";

		}
		throw new VehicleServiceException("Duplicate entry not allowed");

	}

	/**
	 * Search for a vehicle by model or brand.
	 * 
	 * @param vehicleList The list of vehicles.
	 * @param findVehicle model/brand of the vehicle to be searched.
	 * 
	 * @return The vehicle searched.
	 * @throws VehicleServiceException
	 */

	public Vehicle searchVehicleByBrandOrModel(List<Vehicle> vehicleList, String findVehicle)
			throws VehicleServiceException {
		for (Vehicle vehicle : vehicleList) {
			if (vehicle.getBrand().equalsIgnoreCase(findVehicle) || vehicle.getModel().equalsIgnoreCase(findVehicle)) {
				return vehicle;
			}
		}
		throw new VehicleServiceException("Vehicle not found...");
	}

	/**
	 * Rents a vehicle and sets its availability to {@code false}. Calls
	 * {@link #searchVehicleByBrandOrModel( List, String ) } to check if the vehicle
	 * exists.
	 * 
	 * @param vehicles The list of vehicles.
	 * @param model    The model of the vehicle to be rented.
	 * 
	 * @return Status of the operation.
	 * @throws VehicleServiceException
	 */
	public String rentVehicle(List<Vehicle> vehicles, String model) throws VehicleServiceException {
		Vehicle vehicle = searchVehicleByBrandOrModel(vehicles, model);
		if (vehicle != null) {

			if (vehicle.isAvailable()) {
				vehicle.setAvailable(false);
				return (model + " is available for rent");
			}
		}

		throw new VehicleServiceException("Vehicle is currently rented out.It is not available");

	}

	/**
	 * Returning rented vehicle and set its availability to {@code true}.
	 * 
	 * @param vehicleList The list of vehicles.
	 * @param model       The model of the vehicle returned.
	 * 
	 * @return True on returning a vehicle.
	 * @throws VehicleServiceException
	 */
	public String returnRentedVehicle(List<Vehicle> vehicleList, String model) throws VehicleServiceException {
		Vehicle vehicle = searchVehicleByBrandOrModel(vehicleList, model);
		if (vehicle != null && !vehicle.isAvailable()) {
			vehicle.setAvailable(true);
			return (model + " returned back successfully");
		}

		throw new VehicleServiceException("Vehicle already returned back");
	}

}