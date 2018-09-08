package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Car;
import com.repository.CarRepository;
import com.web.dto.CarRegistrationDto;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    public Car findByModel(String model){
        return carRepository.findByModel(model);
    }

    public Car save(CarRegistrationDto registration){
        Car car = new Car();
        car.setEngineType(registration.getEngineType());
        car.setFuelCapacity(registration.getFuelCapacity());
        car.setInterior(registration.getInterior());
        car.setMakeYear(registration.getMakeYear());
        
        car.setManufacturer(registration.getManufacturer());
        car.setModel(registration.getModel());
        car.setTransmission(registration.getTransmission());
        
        
        return carRepository.save(car);
    }

	@Override
	public List<Car> findAllCars() {

		return carRepository.findAll();
	}


}
