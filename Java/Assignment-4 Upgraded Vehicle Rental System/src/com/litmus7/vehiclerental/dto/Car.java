package com.litmus7.vehiclerental.dto;

import java.util.Scanner;

/**
 * This represents the a car available for rent. Inherits {@link Vehicle} and
 * includes features such as number of doors and whether its automatic or not.
 */
public class Car extends Vehicle {
	/**
	 * Number of doors in the car
	 */
	private int noOfDoors;
	/**
	 * Car is automatic or not.
	 */
	private boolean isAutomatic;

	/**
	 * Default constructor initialization .
	 */
	public Car() {
		super();
		this.noOfDoors = 4;
		this.isAutomatic = false;
	}

	/**
	 * Parameterized constructor.
	 * 
	 * @param brand             The brand of the car.
	 * @param model             The model of the car.
	 * @param rentalPricePerDay The price per day for renting the car.
	 * @param noOfDoors         The number of doors of the car.
	 * @param isAutomatic       Whether car is automatic or not.
	 */
	public Car(String brand, String model, double rentalPricePerDay, int noOfDoors, boolean isAutomatic) {
		super(brand, model, rentalPricePerDay);
		this.noOfDoors = noOfDoors;
		this.isAutomatic = isAutomatic;
	}

	/**
	 * Gets the number of doors of car.
	 * 
	 * @return the noOfDoors The number of doors of the car.
	 */
	public int getNoOfDoors() {
		return noOfDoors;
	}

	/**
	 * Sets the number of doors of car.
	 * 
	 * @param noOfDoors The number of doors to set.
	 */
	public void setNoOfDoors(int noOfDoors) {
		this.noOfDoors = noOfDoors;
	}

	/**
	 * Is true if car is automatic else false.
	 * 
	 * @return Whether the car is automatic or not(true/false).
	 */
	public boolean isAutomatic() {
		return isAutomatic;
	}

	/**
	 * To set status accordingly, whether car is automatic or not.
	 * 
	 * @param isAutomatic The isAutomatic to set.
	 */
	public void setAutomatic(boolean isAutomatic) {
		this.isAutomatic = isAutomatic;
	}

	/**
	 * Reads the car specific details.
	 * 
	 * @param scanner Scanner object to read car details. Overrides the method in
	 *                {@link Vehicle}
	 */

	@Override
	public String toString() {
		return "Car [brand=" + getBrand() + ", model=" + getModel() + ", rental price=" + getRentalPricePerDay()
				+ ", doors=" + noOfDoors + ", automatic=" + isAutomatic + ", available="+ isAvailable() +"]";
	}

	@Override
	public void inputDetails(Scanner scanner) {
		super.inputDetails(scanner);

		System.out.print("Enter the Number of Doors: ");
		noOfDoors = Integer.parseInt(scanner.nextLine());

		System.out.print("Is it automatic(true/false): ");
		isAutomatic = scanner.nextBoolean();

		System.out.println("");

	}

	/**
	 * Displays detailed information specific to the car. Overrides the method in
	 * {@link Vehicle}
	 */
	@Override
	public void displayDetails() {

		super.displayDetails();
		System.out.println("Number of Doors: " + getNoOfDoors());
		System.out.println("Automatic: " + isAutomatic());
		System.out.println("");
	}

}
