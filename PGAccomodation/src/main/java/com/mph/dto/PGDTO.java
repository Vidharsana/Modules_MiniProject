package com.mph.dto;

import com.mph.model.PG;

public class PGDTO
{
    private Long pgId;
    private String name;
    private double area;
    private int numberOfRooms;
    private int availableRooms;
    private int popularityCount;
    private String locality;
    private double rentAmount;
    private boolean isAvailable;
    private Long ownerId;
    private Long cityId;
    
    
	public Long getPgId() {
		return pgId;
	}

	public void setPgId(Long pgId) {
		this.pgId = pgId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getArea() {
		return area;
	}


	public void setArea(double area) {
		this.area = area;
	}


	public int getNumberOfRooms() {
		return numberOfRooms;
	}


	public void setNumberOfRooms(int numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}


	public int getAvailableRooms() {
		return availableRooms;
	}


	public void setAvailableRooms(int availableRooms) {
		this.availableRooms = availableRooms;
	}


	public int getPopularityCount() {
		return popularityCount;
	}


	public void setPopularityCount(int popularityCount) {
		this.popularityCount = popularityCount;
	}


	public String getLocality() {
		return locality;
	}


	public void setLocality(String locality) {
		this.locality = locality;
	}


	public double getRentAmount() {
		return rentAmount;
	}


	public void setRentAmount(double rentAmount) {
		this.rentAmount = rentAmount;
	}


	public boolean isAvailable() {
		return isAvailable;
	}


	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}


	public Long getOwnerId() {
		return ownerId;
	}


	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}


	public Long getCityId() {
		return cityId;
	}


	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public PGDTO(Long pgId, String name, double area, int numberOfRooms, int availableRooms, int popularityCount,
			String locality, double rentAmount, boolean isAvailable, Long ownerId, Long cityId) {
		super();
		this.pgId = pgId;
		this.name = name;
		this.area = area;
		this.numberOfRooms = numberOfRooms;
		this.availableRooms = availableRooms;
		this.popularityCount = popularityCount;
		this.locality = locality;
		this.rentAmount = rentAmount;
		this.isAvailable = isAvailable;
		this.ownerId = ownerId;
		this.cityId = cityId;
	}

}