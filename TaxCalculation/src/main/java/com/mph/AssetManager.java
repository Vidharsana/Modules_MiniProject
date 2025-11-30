package com.mph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class AssetManager {

	private List<Property> properties = new ArrayList<>();
	private List<Vehicle> vehicles = new ArrayList<>();


	public void addProperty(Property p) { 
		properties.add(p); 
		}
	public void addVehicle(Vehicle v) { 
		vehicles.add(v);
		}
	public List<Property> getProperties() {
		return properties; 
		}
	public List<Vehicle> getVehicles() {
		return vehicles; 
		}


	public double totalPropertyTax() {
	double sum=0; 
	for(Property p: properties) sum += p.getBaseValue();
	return sum;
	}
	public double totalVehicleTax() {
	double sum=0; 
	for(Vehicle v: vehicles) sum += v.calculateTax(); 
	return sum;
	}


	public void sortPropertiesById() {
	properties.sort(Comparator.comparing(p -> Integer.parseInt(p.getId())));
	}
	public void sortVehiclesByReg() {
	vehicles.sort(Comparator.comparing(Vehicle::getRegistration));
	}


	public Optional<Vehicle> findVehicleByReg(String reg) {
	return vehicles.stream().filter(v -> v.getRegistration().equals(reg)).findFirst();
	}


	public Optional<Property> findPropertyById(String id) {
	return properties.stream().filter(p -> p.getId().equals(id)).findFirst();
	}
}
