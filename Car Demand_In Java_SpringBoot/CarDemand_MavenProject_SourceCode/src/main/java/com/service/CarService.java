package com.service;

import java.util.List;

import com.model.Car;
import com.web.dto.CarRegistrationDto;

public interface CarService {

    Car findByModel(String model);

    Car save(CarRegistrationDto registration);

	List<Car> findAllCars();
}
