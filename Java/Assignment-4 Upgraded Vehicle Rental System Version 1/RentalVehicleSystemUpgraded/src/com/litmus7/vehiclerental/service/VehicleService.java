package com.litmus7.vehiclerental.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.litmus7.vehiclerental.dto.Bike;
import com.litmus7.vehiclerental.dto.Car;
import com.litmus7.vehiclerental.dto.Vehicle;

/**
 * Manages the collection of vehicles and provides various functionalities to be
 * performed on them. They include
 * <ul>
 * <li>Loading vehicles from file</li>
 * <li>Displaying list of all vehicles and currently available vehicles</li>
 * <li>Renting and returning a vehicle</li>
 * <li>Searching for a vehicle by brand/model</li>
 * <li>Calculating the sum of rent of all vehicles</li>
 * </ul>
 */
public class VehicleService {

	/**
	 * Loads vehicle data from the file into list.
	 * 
	 * @param filePath The path of file containing vehicle information.
	 * 
	 * @return The list of vehicles.
	 */
	public List<Vehicle> loadVehiclesFromFile(String filePath) {
		List<Vehicle> vehicleList = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] parts = line.split(",");
				if (parts.length == 6) {
					if (parts[0].equals("Car")) {
						Car car = new Car(parts[1].trim(), parts[2].trim(), Double.parseDouble(parts[3].trim()),
								Integer.parseInt(parts[4].trim()), Boolean.parseBoolean(parts[5].trim()));

						vehicleList.add(car);
					} else {
						Bike bike = new Bike(parts[1].trim(), parts[2].trim(), Double.parseDouble(parts[3].trim()),
								Boolean.parseBoolean(parts[4].trim()), Integer.parseInt(parts[5].trim()));

						vehicleList.add(bike);
					}
				}
			}
		} catch (IOException e) {
			System.out.println("Error reading course file: " + e.getMessage());
		}
		return vehicleList;
	}

	/**
	 * Adds a new vehicle to the list.
	 * 
	 * @param vehicleList The list of vehicles.
	 * @param vehicle     The vehicle to be added.
	 * 
	 * @return True on successful entry of vehicle.
	 */
	public boolean addVehicle(List<Vehicle> vehicleList, Vehicle vehicle) {
		return vehicleList.add(vehicle);

	}

	/**
	 * Search for a vehicle by model or brand.
	 * 
	 * @param vehicleList The list of vehicles.
	 * @param findVehicle model/brand of the vehicle to be searched.
	 * 
	 * @return The vehicle searched.
	 */

	public Vehicle searchVehicleByBrandOrModel(List<Vehicle> vehicleList, String findVehicle) {
		for (Vehicle vehicle : vehicleList) {
			if (vehicle.getBrand().equalsIgnoreCase(findVehicle) || vehicle.getModel().equalsIgnoreCase(findVehicle)) {
				return vehicle;
			}
		}
		return null;
	}

	/**
	 * 
	 * Calculates total rental price per day of all the vehicles.
	 * 
	 * @param vehicleList The list of vehicles.
	 * 
	 * @return Total rental price of all the vehicles.
	 */
	public double calculateTotalRentalPrice(List<Vehicle> vehicleList) {
		double total = 0;
		for (Vehicle vehicle : vehicleList) {
			total += vehicle.getRentalPricePerDay();
		}
		return total;
	}

	/**
	 * Rents a vehicle and update its availability status.
	 * 
	 * @param vehicleList The list of vehicles.
	 * @param model       The model of the vehicle to be rented.
	 * 
	 * @return True on renting a vehicle.
	 */
	public boolean rentVehicle(List<Vehicle> vehicleList, String model) {
		for (Vehicle vehicle : vehicleList) {
			if (vehicle.getModel().equalsIgnoreCase(model)) {
				if (vehicle.isAvailable()) {
					vehicle.setAvailable(false);
					return true;
				}
			}
		}
		return false;

	}

	/**
	 * Returning rented vehicle and updating its availability status.
	 * 
	 * @param vehicleList The list of vehicles.
	 * @param model       The model of the vehicle returned.
	 * 
	 * @return True on returning a vehicle.
	 */
	public boolean returnRentedVehicle(List<Vehicle> vehicleList, String model) {
		for (Vehicle vehicle : vehicleList) {
			if (vehicle.getModel().equalsIgnoreCase(model)) {
				vehicle.setAvailable(true);
				return true;
			}
		}
		return false;
	}

}