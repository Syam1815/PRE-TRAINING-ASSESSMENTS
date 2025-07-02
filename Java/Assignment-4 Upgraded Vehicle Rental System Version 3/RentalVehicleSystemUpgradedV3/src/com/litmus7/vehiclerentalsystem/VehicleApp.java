package com.litmus7.vehiclerentalsystem;

import java.util.List;

import com.litmus7.vehiclerentalsystem.controller.VehicleController;
import com.litmus7.vehiclerentalsystem.dto.Car;
import com.litmus7.vehiclerentalsystem.dto.Response;
import com.litmus7.vehiclerentalsystem.dto.Vehicle;

/**
 * The main application class that interacts with the user and handles the
 * vehicle rental system. Invokes {@link VehicleController} to manage the
 * following functionalities along with validation:
 * <ul>
 * <li>Loading vehicles from file.</li>
 * <li>Adding new a new vehicle, restricting duplicate entry.</li>
 * <li>Renting and returning a vehicle.</li>
 * <li>Searching for a vehicle by brand/model.</li>
 * 
 * </ul>
 * Also calls static methods for displaying all vehicles as well as vehicles
 * available for rent.
 * 
 * @version 3.0
 */
public class VehicleApp {

	/**
	 * Main method : Entry point of the program.
	 * 
	 * @param args Command-line arguments (not used).
	 */

	public static void main(String[] args) {
		VehicleController vehicleController = new VehicleController();

		// Loading data from file
		List<Vehicle> vehicles = null;
		System.out.println("Loading vehicle data......");

		Response<List<Vehicle>> loadVehicleResponse = vehicleController.getAllVehiclesFromFile(vehicles, "vehicles.txt");

		if (loadVehicleResponse.getStatusCode() == 200) {
			vehicles = loadVehicleResponse.getVehicleData();
			displayVehicle(vehicles);
		} else {
			System.out.println(loadVehicleResponse.getErrorMessage());
			return;
		}
		System.out.println("");

		// Adding a vehicle
		Car car = new Car("Maruti Suzuki", "Alto", 55.5, 4, true);
		Response<List<Vehicle>> addResponse = vehicleController.addVehicle(vehicles, car);

		if (addResponse.getStatusCode() == 202) {
			System.out.println(addResponse.getStatusMessage());
			displayVehicle(vehicles);
		} else {
			System.out.println(addResponse.getErrorMessage());
		}
		System.out.println("");

		// Adding a duplicate entry for vehicle
		Car car_duplicate = new Car("Maruti Suzuki", "Alto", 55.5, 4, true);
		addResponse = vehicleController.addVehicle(vehicles, car_duplicate);
		
		if (addResponse.getStatusCode() == 202) {
			System.out.println(addResponse.getStatusMessage());
			displayVehicle(vehicles);
		} else {
			System.out.println(addResponse.getErrorMessage());
		}
		System.out.println("");

		// Finding vehicle by brand/model
		Response<Vehicle> searchResponse = vehicleController.searchVehicleByBrandOrModel(vehicles, "Corolla");
		if (searchResponse.getStatusCode() == 204) {
			System.out.println(searchResponse.getStatusMessage());
			System.out.println(searchResponse.getVehicleData());

		} else {
			System.out.println(searchResponse.getErrorMessage());
		}
		System.out.println("");

		// Finding vehicle by brand/model that do not exist.
		searchResponse = vehicleController.searchVehicleByBrandOrModel(vehicles, "TVS");
		if (searchResponse.getStatusCode() == 204) {
			System.out.println(searchResponse.getStatusMessage());
			System.out.println(searchResponse.getVehicleData());

		} else {
			System.out.println(searchResponse.getErrorMessage());
		}
		System.out.println("");

		// Renting a vehicle
		Response<String> rentResponse = vehicleController.rentVehicle(vehicles, "R15");
		if (rentResponse.getStatusCode() == 206) {
			System.out.println(rentResponse.getStatusMessage() + "\n Renting vehicle....");

		} else {
			System.out.println(rentResponse.getErrorMessage());
		}
		System.out.println("");

		// Renting a already rented vehicle
		rentResponse = vehicleController.rentVehicle(vehicles, "R15");
		if (rentResponse.getStatusCode() == 206) {
			System.out.println(rentResponse.getStatusMessage() + "\n Renting vehicle....");

		} else {
			System.out.println(rentResponse.getErrorMessage());
		}
		System.out.println("");

		// Displaying available vehicles
		displayAvailableVehicle(vehicles);

		// Displaying all vehicles
		displayVehicle(vehicles);

		System.out.println("");

		// Returning a rented vehicle
		Response<String> rentReturnResponse = vehicleController.returnRentedVehicle(vehicles, "R15");
		if (rentReturnResponse.getStatusCode() == 208) {
			System.out.println("Returning vehicle....\n" + rentReturnResponse.getStatusMessage());

		} else {
			System.out.println(rentReturnResponse.getErrorMessage());
		}

		// Displaying all vehicles
		displayVehicle(vehicles);

	}

	/**
	 * Displays all the vehicles from list.
	 */
	public static void displayVehicle(List<Vehicle> vehicleList) {
		System.out.println("----- Vehicle List------");
		for (Vehicle vehicle : vehicleList) {
			System.out.println(vehicle);

		}
		System.out.println("");
	}

	/**
	 * Displays vehicles available for rent.
	 */
	public static void displayAvailableVehicle(List<Vehicle> vehicleList) {
		System.out.println("----- Available Vehicles------");
		for (Vehicle vehicle : vehicleList) {
			if (vehicle.isAvailable())
				System.out.println(vehicle);
		}
		System.out.println("");
	}

}
