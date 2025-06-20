/**
 * 
 */
package com.litmus7.vrs;

import com.litmus7.vrs.dto.*;
import java.util.Scanner;

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

		// By reading the values
		Car car = new Car();
		car.inputDetails(scanner);
		car.displayDetails();

		// By using the parameterized constructor
		Car car_p = new Car("Toyota", "Corolla", 1200, 4, true);
		car_p.displayDetails();

		// By reading the values
		Bike bike = new Bike();
		bike.inputDetails(scanner);
		bike.displayDetails();

		// By using the parameterized constructor
		Bike bike_p = new Bike("Yamaha", "FZ", 800, true, 150);
		bike_p.displayDetails();
	}

}
