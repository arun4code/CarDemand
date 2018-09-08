package com.service;

import java.util.List;

import com.model.Demand;
import com.web.dto.DemandRegistrationDto;

public interface DemandService {

	Demand findByModel(String model);

	Demand save(DemandRegistrationDto demand);
	
	List<Demand> findAllDemands();

	Demand findById(Long id);

	void deleteDemandById(Long id);

	void update(Demand existing, DemandRegistrationDto demandDto);
}
