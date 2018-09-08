package com.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class Demand {
	
	public Demand() {
		
	}
	public Demand(String pickup_location, String dropoff_location, String pickup_time, String dropoff_time,
			String manufacturer, String model, String engineType, String transmission, String interior,
			double fuelCapacity, Long carId, Long userId) {
		super();
		this.pickup_location = pickup_location;
		this.dropoff_location = dropoff_location;
		this.pickup_time = pickup_time;
		this.dropoff_time = dropoff_time;
		this.manufacturer = manufacturer;
		this.model = model;
		this.engineType = engineType;
		this.transmission = transmission;
		this.interior = interior;
		this.fuelCapacity = fuelCapacity;
		this.carId = carId;
		this.userId = userId;
	}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String pickup_location;
    private String dropoff_location;
    private String pickup_time;
    private String dropoff_time;
	private String manufacturer;
    private String model;
    private String engineType;
    private String transmission;
    private String interior;
    private double fuelCapacity;
    private Long userId = 0L;
    private Long carId = 0L;
    
    @OneToOne(fetch = FetchType.EAGER,
            cascade =  CascadeType.ALL,
            mappedBy = "demand")
    private DemandDetails demandDetails;
    
    
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPickup_location() {
		return pickup_location;
	}
	public void setPickup_location(String pickup_location) {
		this.pickup_location = pickup_location;
	}
	public String getDropoff_location() {
		return dropoff_location;
	}
	public void setDropoff_location(String dropoff_location) {
		this.dropoff_location = dropoff_location;
	}
	public String getPickup_time() {
		return pickup_time;
	}
	public void setPickup_time(String pickup_time) {
		this.pickup_time = pickup_time;
	}
	public String getDropoff_time() {
		return dropoff_time;
	}
	public void setDropoff_time(String dropoff_time) {
		this.dropoff_time = dropoff_time;
	}
	
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getEngineType() {
		return engineType;
	}
	public void setEngineType(String engineType) {
		this.engineType = engineType;
	}
	public String getTransmission() {
		return transmission;
	}
	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}
	public String getInterior() {
		return interior;
	}
	public void setInterior(String interior) {
		this.interior = interior;
	}
	public double getFuelCapacity() {
		return fuelCapacity;
	}
	public void setFuelCapacity(double fuelCapacity) {
		this.fuelCapacity = fuelCapacity;
	}
	
	
	
	@Override
	public String toString() {
		return "Demand [id=" + id + ", pickup_location=" + pickup_location + ", dropoff_location=" + dropoff_location
				+ ", pickup_time=" + pickup_time + ", dropoff_time=" + dropoff_time + ", manufacturer=" + manufacturer
				+ ", model=" + model + ", engineType=" + engineType + ", transmission=" + transmission + ", interior="
				+ interior + ", fuelCapacity=" + fuelCapacity + "]";
	}
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public DemandDetails getDemandDetails() {
		return demandDetails;
	}
	public void setDemandDetails(DemandDetails demandDetails) {
		this.demandDetails = demandDetails;
	}
	public Long getCarId() {
		return carId;
	}
	public void setCarId(Long carId) {
		this.carId = carId;
	}
	
}
