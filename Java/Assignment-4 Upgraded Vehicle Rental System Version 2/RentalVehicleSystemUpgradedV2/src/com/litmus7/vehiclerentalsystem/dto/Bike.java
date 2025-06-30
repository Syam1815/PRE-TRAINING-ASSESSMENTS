package com.litmus7.vehiclerentalsystem.dto;

/**
 * This represents the a bike available for rent. Inherits {@link Vehicle} and
 * includes features such as engine capacity and whether its gear or gear-less.
 */
public class Bike extends Vehicle {
	/**
	 * Bike has gear or not.
	 */
	private boolean hasGear;
	/**
	 * Engine capacity of bike.
	 */
	private int engineCapacity;

	/**
	 * Default constructor initialization .
	 */
	public Bike() {
		super();
		this.hasGear = true;
		this.engineCapacity = 125;
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param brand             The brand of the bike.
	 * @param model             The model of the bike.
	 * @param rentalPricePerDay The price per day for renting the bike.
	 * @param hasGear           Whether the bike has gear or not.
	 * @param engineCapacity    Engine capacity of bike
	 */
	public Bike(String brand, String model, double rentalPricePerDay, boolean hasGear, int engineCapacity) {
		super(brand, model, rentalPricePerDay);
		this.hasGear = hasGear;
		this.engineCapacity = engineCapacity;
	}

	/**
	 * Gets status of bike for gear or gear-less.
	 * 
	 * @return the hasGear Gear(true) or gear-less(false)
	 */
	public boolean isHasGear() {
		return hasGear;
	}

	/**
	 * Sets status of bike for gear or gear-less.
	 * 
	 * @param hasGear the hasGear to set.
	 */
	public void setHasGear(boolean hasGear) {
		this.hasGear = hasGear;
	}

	/**
	 * Gets the engine capacity of bike.
	 * 
	 * @return engineCapacity The engine capacity of bike.
	 * 
	 */
	public int getEngineCapacity() {
		return engineCapacity;
	}

	/**
	 * Sets the engine capacity of bike.
	 * 
	 * @param engineCapacity The engine capacity to set.
	 */
	public void setEngineCapacity(int engineCapacity) {
		this.engineCapacity = engineCapacity;
	}

	@Override
	public String toString() {
		return "Bike [brand=" + getBrand() + ", model=" + getModel() + ", rental price=" + getRentalPricePerDay()
				+ ", gear=" + hasGear + ", engineCapacity=" + engineCapacity + ", available=" + isAvailable() + "]";
	}

}
