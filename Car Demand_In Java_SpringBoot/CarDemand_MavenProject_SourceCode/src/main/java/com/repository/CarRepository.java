package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    Car findByModel(String model);

	Car findById(Long carId);

}
