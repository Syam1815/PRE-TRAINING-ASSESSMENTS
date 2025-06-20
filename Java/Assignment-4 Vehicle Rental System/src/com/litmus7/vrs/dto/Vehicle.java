package com.litmus7.vrs.dto;

import java.util.Scanner;

/**
 * This class represent a vehicle available for rent with its brand, model,
 * rental price per day
 */
public class Vehicle {
	/**
	 * Brand of the vehicle.
	 */
	private String brand;
	/**
	 * Model of the vehicle.
	 */
	private String model;
	/**
	 * Price per day for renting the vehicle
	 */
	private double rentalPricePerDay;

	/**
	 * Default constructor for creating vehicle object Constructs a vehicle object
	 * and initializes it with default values.
	 */
	public Vehicle() {
		this.brand = "Vehicle_NULL";
		this.model = "Model_NULL";
		this.rentalPricePerDay = 0.0;
	}

	/**
	 * Parameterized constructor for creating vehicle object. Initializes the object
	 * with arguments passed.
	 * 
	 * @param brand             The brand of the vehicle.
	 * @param model             The model of the vehicle.
	 * @param rentalPricePerDay Price per day for renting the vehicle.
	 */
	public Vehicle(String brand, String model, double rentalPricePerDay) {
		this.brand = brand;
		this.model = model;
		this.rentalPricePerDay = rentalPricePerDay;
	}

	/**
	 * Gets the brand of the vehicle.
	 * 
	 * @return The brand of the vehicle.
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * Sets the brand of the vehicle.
	 * 
	 * @param brand The brand of vehicle to set.
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * Gets the model of vehicle.
	 * 
	 * @return The model of vehicle.
	 */
	public String getModel() {
		return model;
	}

	/**
	 * Sets the model of vehicle.
	 * 
	 * @param model The model of vehicle to set.
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * Gets rental price per day for the vehicle.
	 * 
	 * @return The rental price per day for the vehicle.
	 */
	public double getRentalPricePerDay() {
		return rentalPricePerDay;
	}

	/**
	 * Sets rental price per day for the vehicle.
	 * 
	 * @param rentalPricePerDay The rental price per day for the vehicle to set.
	 */
	public void setRentalPricePerDay(double rentalPricePerDay) {
		this.rentalPricePerDay = rentalPricePerDay;
	}

	/**
	 * Takes input for vehicle details and assigns them to respective fields.
	 * 
	 * @param scanner Scanner object to read vehicle details.
	 */
	public void inputDetails(Scanner scanner) {
		
		System.out.println("----Enter " + this.getClass().getSimpleName() + " Details----");
		scanner.nextLine();
		
		System.out.print("Enter the Brand: ");
		brand=scanner.nextLine();

		System.out.print("Enter the Model: ");
		model = scanner.nextLine();

		System.out.print("Enter the Rental Price/Day: ");
		rentalPricePerDay = scanner.nextInt();

	}

	/**
	 * Display details of vehicle.
	 */
	public void displayDetails() {
		System.out.println("-----Displaying " + this.getClass().getSimpleName() + " Details-----");
		System.out.println("Brand: " + getBrand());
		System.out.println("Model: " + getModel());
		System.out.println("Rental Price/Day: " + getRentalPricePerDay());
	}

}
