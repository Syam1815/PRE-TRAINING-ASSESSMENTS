package com.litmus7.vehiclerental;

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

	private List<Vehicle> vehicleList = new ArrayList<>();

	/**
	 * Loads vehicle data from the file into list.
	 * 
	 * @param filePath The path of file containing vehicle information.
	 */
	public void loadVehiclesFromFile(String filePath) {
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
	}

	/**
	 * Displays vehicles from the list.
	 */
	public void displayVehicle() {
		System.out.println("----- Vehicle List------");
		for (Vehicle vehicle : vehicleList) {
			System.out.println(vehicle);

		}
		System.out.println("");
	}

	/**
	 * Adds a new vehicle to the list.
	 * 
	 * @param vehicle The vehicle to be added.
	 */
	public void addVehicle(Vehicle vehicle) {
		vehicleList.add(vehicle);
		System.out.println("Vehicle added successfully");

	}

	/**
	 * Search for a vehicle by model or brand.
	 * 
	 * @param findVehicle model/brand of the vehicle to be searched.
	 */
	public void searchVehicleByBrandOrModel(String findVehicle) {
		boolean success = false; // flag
		for (Vehicle vehicle : vehicleList) {
			if (vehicle.getBrand().equalsIgnoreCase(findVehicle) || vehicle.getModel().equalsIgnoreCase(findVehicle)) {
				success = true; // vehicle found
				System.out.println("Vehicle Successfully found....");
				vehicle.displayDetails();
				;
			}
		}
		if (!success) { // vehicle not found
			System.out.println("Vehicle Not Found !");
		}

	}

	/**
	 * 
	 * Calculates total rental price per day of all the vehicles.
	 * 
	 * @return Total rental price of all the vehicles.
	 */
	public double calculateTotalRentalPrice() {
		double total = 0;
		for (Vehicle vehicle : vehicleList) {
			total += vehicle.getRentalPricePerDay();
		}
		return total;
	}

	/**
	 * Rents a vehicle and update its availability status.
	 * 
	 * @param model The model of the vehicle to be rented.
	 */
	public void rentVehicle(String model) {
		for (Vehicle vehicle : vehicleList) {
			if (vehicle.getModel().equalsIgnoreCase(model)) {
				if (vehicle.isAvailable()) {
					System.out.println("\nVehicle is available for rent \n Renting vehicle....");
					vehicle.setAvailable(false);
					System.out.println("Successfully rented vehicle\n");
					break;
				} else {
					System.out.println("\nVehicle is  not available for rent!\n");
				}
			}
		}

	}

	/**
	 * Returning rented vehicle and updating its availability status.
	 * 
	 * @param model The model of the vehicle returned.
	 */
	public void returnRentedVehicle(String model) {
		for (Vehicle vehicle : vehicleList) {
			if (vehicle.getModel().equalsIgnoreCase(model)) {
				System.out.println("Vehicle is returned....\n");
				vehicle.setAvailable(true);

			}
		}
	}

	/**
	 * Displays vehicles available for rent.
	 */
	public void displayAvailableVehicle() {
		System.out.println("----- Available Vehicles------");
		for (Vehicle vehicle : vehicleList) {
			if (vehicle.isAvailable())
				System.out.println(vehicle);
		}
		System.out.println("");
	}
}