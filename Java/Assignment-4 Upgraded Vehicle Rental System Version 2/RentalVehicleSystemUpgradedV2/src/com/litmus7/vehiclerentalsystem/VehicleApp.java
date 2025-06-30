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
 */
public class VehicleApp {

	/**
	 * Main method : Entry point of the program.
	 * 
	 * @param args Command-line arguments (not used).
	 */

	public static void main(String[] args) {
		VehicleController vehicleController = new VehicleController();

		// To handle the responses
		Response requestResponse = new Response();

		List<Vehicle> vehicles = null;

		// Loading data from file
		System.out.println("Loading vehicle data......");
		requestResponse = vehicleController.getAllVehiclesFromFile(vehicles, "vehicles.txt");
		if (requestResponse.getStatusCode() == 200) {
			vehicles = requestResponse.getVehicles();
			displayVehicle(vehicles);
		} else {
			System.out.println(requestResponse.getErrorMessage());
			return;
		}
		System.out.println("");
		// Adding a vehicle
		Car car = new Car("Maruti Suzuki", "Alto", 55.5, 4, true);
		requestResponse = vehicleController.addVehicle(vehicles, car);
		if (requestResponse.getStatusCode() == 202) {
			System.out.println(requestResponse.getStatusMessage());
			displayVehicle(vehicles);
		} else {
			System.out.println(requestResponse.getErrorMessage());
		}
		System.out.println("");

		// Adding a duplicate entry for vehicle
		Car car_duplicate = new Car("Maruti Suzuki", "Alto", 55.5, 4, true);
		requestResponse = vehicleController.addVehicle(vehicles, car_duplicate);
		if (requestResponse.getStatusCode() == 202) {
			System.out.println(requestResponse.getStatusMessage());
			displayVehicle(vehicles);
		} else {
			System.out.println(requestResponse.getErrorMessage());
		}
		System.out.println("");

		// Finding vehicle by brand/model
		requestResponse = vehicleController.searchVehicleByBrandOrModel(vehicles, "TVS");
		if (requestResponse.getStatusCode() == 204) {
			System.out.println(requestResponse.getStatusMessage());
			System.out.println(requestResponse.getVehicle());

		} else {
			System.out.println(requestResponse.getErrorMessage());
		}
		System.out.println("");

		// Finding vehicle by brand/model that do not exist.
		requestResponse = vehicleController.searchVehicleByBrandOrModel(vehicles, "Corolla");
		if (requestResponse.getStatusCode() == 204) {
			System.out.println(requestResponse.getStatusMessage());
			System.out.println(requestResponse.getVehicle());

		} else {
			System.out.println(requestResponse.getErrorMessage());
		}
		System.out.println("");

		// Renting a vehicle
		requestResponse = vehicleController.rentVehicle(vehicles, "R15");
		if (requestResponse.getStatusCode() == 206) {
			System.out.println(requestResponse.getStatusMessage() + "\n Renting vehicle....");

		} else {
			System.out.println(requestResponse.getErrorMessage());
		}
		System.out.println("");

		// Renting a already rented vehicle
		requestResponse = vehicleController.rentVehicle(vehicles, "R15");
		if (requestResponse.getStatusCode() == 206) {
			System.out.println(requestResponse.getStatusMessage() + "\n Renting vehicle....");

		} else {
			System.out.println(requestResponse.getErrorMessage());
		}
		System.out.println("");

		// Displaying available vehicles
		displayAvailableVehicle(vehicles);

		// Displaying all vehicles
		displayVehicle(vehicles);

		System.out.println("");

		// Returning a rented vehicle
		requestResponse = vehicleController.returnRentedVehicle(vehicles, "R15");
		if (requestResponse.getStatusCode() == 208) {
			System.out.println("Returning vehicle....\n" + requestResponse.getStatusMessage());

		} else {
			System.out.println(requestResponse.getErrorMessage());
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
