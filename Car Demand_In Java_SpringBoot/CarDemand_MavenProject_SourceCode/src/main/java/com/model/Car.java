package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	private String manufacturer;
    private String model;
    private String engineType;
    private int makeYear;
    private double fuelCapacity;
    private String transmission;
    private String interior;

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

	public int getMakeYear() {
		return makeYear;
	}

	public void setMakeYear(int makeYear) {
		this.makeYear = makeYear;
	}

	public double getFuelCapacity() {
		return fuelCapacity;
	}

	public void setFuelCapacity(double fuelCapacity) {
		this.fuelCapacity = fuelCapacity;
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


    public Car() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public Car(String manufacturer, String model, String engineType, int makeYear, double fuelCapacity,
			String transmission, String interior) {
		super();
		this.manufacturer = manufacturer;
		this.model = model;
		this.engineType = engineType;
		this.makeYear = makeYear;
		this.fuelCapacity = fuelCapacity;
		this.transmission = transmission;
		this.interior = interior;
	}


	@Override
	public String toString() {
		return "Car [id=" + id + ", manufacturer=" + manufacturer + ", model=" + model + ", engineType=" + engineType
				+ ", makeYear=" + makeYear + ", fuelCapacity=" + fuelCapacity 
				+ ", transmission=" + transmission + ", interior=" + interior + "]";
	}

}
