package com.litmus7.vehiclerentalsystem.dto;

import java.util.Objects;

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
	 * Rental availability of vehicle. By default any new vehicle created is
	 * available for rent.
	 */
	private boolean available = true;

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
	 * Reflects the availability of vehicle for rent.
	 * 
	 * @return The rental status of vehicle
	 */
	public boolean isAvailable() {
		return available;
	}

	/**
	 * Set the rental availability status of vehicle.
	 * 
	 * @param isRented The availability of vehicle.
	 */
	public void setAvailable(boolean available) {
		this.available = available;
	}

	@Override
	public String toString() {
		return "Vehicle [brand=" + brand + ", model=" + model + ", rentalPricePerDay=" + rentalPricePerDay
				+ ", available" + isAvailable() + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(brand, model);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		return Objects.equals(brand, other.brand) && Objects.equals(model, other.model);
	}

}
