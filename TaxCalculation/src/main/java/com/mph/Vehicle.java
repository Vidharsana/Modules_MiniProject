package com.mph;

public class Vehicle implements Taxable{

	private String registration;
	private String brand;
	private double cost;
	private int velocity;
	private int capacity;
	private int type;
	public Vehicle(String registration, String brand, double cost, int velocity, int capacity, int type) {
		super();
		this.registration = registration;
		this.brand = brand;
		this.cost = cost;
		this.velocity = velocity;
		this.capacity = capacity;
		this.type = type;
	}
	
	
	
	public Vehicle() {
		super();
		
	}



	public String getRegistration() {
		return registration;
	}



	public void setRegistration(String registration) {
		this.registration = registration;
	}



	public String getBrand() {
		return brand;
	}



	public void setBrand(String brand) {
		this.brand = brand;
	}



	public double getCost() {
		return cost;
	}



	public void setCost(double cost) {
		this.cost = cost;
	}



	public int getVelocity() {
		return velocity;
	}



	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}



	public int getCapacity() {
		return capacity;
	}



	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}



	public int getType() {
		return type;
	}



	public void setType(int type) {
		this.type = type;
	}



	@Override
	public String toString() {
		return "Vehicle [registration=" + registration + ", brand=" + brand + ", cost=" + cost + ", velocity="
				+ velocity + ", capacity=" + capacity + ", type=" + type + "]";
	}


	

	@Override
	public double calculateTax() {
	double percent = (type == 1) ? 0.10 : (type == 2) ? 0.11 : 0.12;
	return velocity + capacity + (percent * cost);
	}
	
}
