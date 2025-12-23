package com.mph.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;

@Entity
public class PG {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pgId;

    private String name;
    private double area;
    private int numberOfRooms;
    private int availableRooms;
    private int popularityCount;
    private String locality;
    private double rentAmount;
    private boolean isAvailable;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @OneToMany(mappedBy = "pg", cascade = CascadeType.ALL)
    @JsonManagedReference   //  prevents infinite recursion
    private List<Tenant> tenants;

	public PG() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PG(Long pgId, String name, double area, int numberOfRooms, int availableRooms, int popularityCount,
			String locality, double rentAmount, boolean isAvailable, Owner owner, City city, List<Tenant> tenants) {
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
		this.owner = owner;
		this.city = city;
		this.tenants = tenants;
	}

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

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public List<Tenant> getTenants() {
		return tenants;
	}

	public void setTenants(List<Tenant> tenants) {
		this.tenants = tenants;
	}

	@Override
	public String toString() {
		return "PG [pgId=" + pgId + ", name=" + name + ", area=" + area + ", numberOfRooms=" + numberOfRooms
				+ ", availableRooms=" + availableRooms + ", popularityCount=" + popularityCount + ", locality="
				+ locality + ", rentAmount=" + rentAmount + ", isAvailable=" + isAvailable + ", owner=" + owner
				+ ", city=" + city + ", tenants=" + tenants + "]";
	}

    
}
