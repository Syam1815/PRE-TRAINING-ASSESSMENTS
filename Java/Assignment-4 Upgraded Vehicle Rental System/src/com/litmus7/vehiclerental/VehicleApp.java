package com.litmus7.vehiclerental;

import java.util.Scanner;

import com.litmus7.vehiclerental.dto.Bike;
import com.litmus7.vehiclerental.dto.Car;

/**
 * The main application class that handles the vehicle rental system. Performs
 * input handling and displays the their details.Demonstrates creation and usage
 * of {@link Car} and {@link Bike} objects using both user input and
 * parameterized constructors
 */
public class VehicleApp {

	/**
	 * Main method : Entry point of the program.
	 * 
	 * @param args Command-line arguments (not used).
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		VehicleService service = new VehicleService();

		// Loading data from file
		service.loadVehiclesFromFile("vehicles.txt");

		// displaying the loaded data
		service.displayVehicle();

		// Adding new Car
		Car car = new Car();
		car.inputDetails(scanner);
		service.addVehicle(car);

		// Adding new Bike
		Bike bike = new Bike("Kawasaki", "Ninja", 1000.0, true, 300);
		service.addVehicle(bike);

		// displaying the updated list
		service.displayVehicle();

		// Finding vehicles by brand/model
		service.searchVehicleByBrandOrModel("Alto");
		service.searchVehicleByBrandOrModel("TVS");

		// Get sum of rental price of all vehicles
		System.out.println("\nTotal Rental Price:  " + service.calculateTotalRentalPrice());

		// Rent a vehicle
		service.rentVehicle("corolla");
		
		// Rent an unavailable vehicle
		service.rentVehicle("corolla");

		// Display available vehicles
		service.displayAvailableVehicle();

		// Display all vehicles
		service.displayVehicle();
		// Return rented vehicle
		service.returnRentedVehicle("corolla");

		// Display available vehicles
		service.displayAvailableVehicle();
	}

}
