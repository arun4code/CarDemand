package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Demand;

@Repository
public interface DemandRepository extends JpaRepository<Demand, Long> {

	Demand findByModel(String model);

	Demand findById(Long id);
	
}
