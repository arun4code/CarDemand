package com.web.dto;

import org.hibernate.validator.constraints.NotEmpty;


public class DemandRegistrationDto {

	
	private String manufacturer;
	
	@NotEmpty
    private String pickup_location;
	
	@NotEmpty
    private String dropoff_location;
    
	@NotEmpty
	private String pickup_time;
	
	@NotEmpty
    private String dropoff_time;
	
    private String model;
    private String engineType;
    private String transmission;
    private String interior;
    private double fuelCapacity;
    private long id;
    
    private Long userId = 0L;
    private Long carId = 0L;
    
    
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
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
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getCarId() {
		return carId;
	}
	public void setCarId(Long carId) {
		this.carId = carId;
	}
        
}
