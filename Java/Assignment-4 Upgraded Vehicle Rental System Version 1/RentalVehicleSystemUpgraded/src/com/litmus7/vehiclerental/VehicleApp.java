package com.litmus7.vehiclerental;

import java.util.List;
import java.util.Scanner;

import com.litmus7.vehiclerental.dto.Vehicle;
import com.litmus7.vehiclerental.dto.Bike;
import com.litmus7.vehiclerental.dto.Car;
import com.litmus7.vehiclerental.service.VehicleService;

/**
 * The main application class that handles the vehicle rental system. Performs
 * input handling and displays the their details.Demonstrates creation and usage
 * of {@link Car} and {@link Bike} objects using both user input and
 * parameterized constructors
 */
public class VehicleApp {

	/*
	 * Displays vehicles from the list.
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

	/**
	 * Main method : Entry point of the program.
	 * 
	 * @param args Command-line arguments (not used).
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		VehicleService service = new VehicleService();

		// Loading data from file
		List<Vehicle> vehicleList = service.loadVehiclesFromFile("vehicles.txt");

		// displaying the loaded data
		displayVehicle(vehicleList);

		// Adding new Car
		Car car = new Car();
		car.inputDetails(scanner);
		boolean vehicle = service.addVehicle(vehicleList,car);
		if(vehicle)
			System.out.println("Vehicle added successfully");

		// Adding new Bike
		Bike bike = new Bike("Kawasaki", "Ninja", 1000.0, true, 300);
		vehicle = service.addVehicle(vehicleList,bike);
		if(vehicle)
			System.out.println("Vehicle added successfully");


		// displaying the updated list
		displayVehicle(vehicleList);

//		// Finding vehicles by brand/model
		Vehicle findVehicle;
		findVehicle=service.searchVehicleByBrandOrModel(vehicleList, "Alto");
		
		if (findVehicle != null) {
		    System.out.println("Vehicle found:");
		    findVehicle.displayDetails();
		} else {
		    System.out.println("No vehicle found" );
		}
		    
		// Get sum of rental price of all vehicles
		System.out.println("\nTotal Rental Price:  " + service.calculateTotalRentalPrice(vehicleList));

		// Rent a vehicle
		boolean rent = service.rentVehicle(vehicleList, "corolla");
		if(rent){
			System.out.println("\nSuccessfully rented the vehicle" );
		}else {
			System.out.println("\nVehicle is not avaialble for rent" );
		}

		// Display available vehicles
		displayAvailableVehicle(vehicleList);

		// Display all vehicles
		displayVehicle(vehicleList);
		
		// Return rented vehicle
		if(service.returnRentedVehicle(vehicleList, "corolla")){
			System.out.println("\nVehicle is returned");
		}else {
			System.out.println("\nVehicle return failed");}

		// Display available vehicles
		displayAvailableVehicle(vehicleList);
	}

}
