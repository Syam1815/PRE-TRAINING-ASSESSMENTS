package com.litmus7.vehiclerentalsystem.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.litmus7.vehiclerentalsystem.dto.Bike;
import com.litmus7.vehiclerentalsystem.dto.Car;
import com.litmus7.vehiclerentalsystem.dto.Vehicle;
import com.litmus7.vehiclerentalsystem.exception.VehicleDataAccessException;

public class VehicleFileDao {
	/**
	 * Loads vehicle data from the file into list. Creates {@link Car} objects and
	 * {@link Bike} objects for respective data and add it to the list.
	 * 
	 * @param filePath The path of file containing vehicle information.
	 * 
	 * @return The list of vehicles.
	 * @throws VehicleDataAccessException
	 */
	public List<Vehicle> loadVehiclesFromFile(String filePath) throws VehicleDataAccessException {
		List<Vehicle> vehicles = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] parts = line.split(",");
				if (parts.length == 6) {
					if (parts[0].equals("Car")) {
						Car car = new Car(parts[1].trim(), parts[2].trim(), Double.parseDouble(parts[3].trim()),
								Integer.parseInt(parts[4].trim()), Boolean.parseBoolean(parts[5].trim()));

						vehicles.add(car);
					}
					if (parts[0].equals("Bike")) {
						Bike bike = new Bike(parts[1].trim(), parts[2].trim(), Double.parseDouble(parts[3].trim()),
								Boolean.parseBoolean(parts[4].trim()), Integer.parseInt(parts[5].trim()));

						vehicles.add(bike);
					}
				}
			}
		} catch (FileNotFoundException e) {
			throw new VehicleDataAccessException(e.getMessage(), e);
			
		} catch (IOException e) {
			throw new VehicleDataAccessException(e.getMessage(), e);
			
		} catch (NumberFormatException e) {
			throw new VehicleDataAccessException(e.getMessage(), e);
		}
		return vehicles;
	}
}
