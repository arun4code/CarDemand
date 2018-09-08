package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Car;
import com.model.CarUsers;
import com.model.Demand;
import com.model.DemandDetails;
import com.repository.CarRepository;
import com.repository.CarUsersRepository;
import com.repository.DemandRepository;
import com.web.dto.DemandRegistrationDto;

@Service
public class DemandServiceImpl implements DemandService {

    @Autowired
    private DemandRepository demandRepository;

    @Autowired
    private CarUsersRepository userRepository;

    @Autowired
    private CarRepository carRepo;
    
    public Demand findByModel(String model){
        return demandRepository.findByModel(model);
    }

    public Demand save(DemandRegistrationDto dto){
    	Demand demand = new Demand();
    	demand.setDropoff_location(dto.getDropoff_location());
    	demand.setDropoff_time(dto.getDropoff_time());
    	demand.setEngineType(dto.getEngineType());
    	demand.setFuelCapacity(dto.getFuelCapacity());
    	demand.setInterior(dto.getInterior());
    	demand.setManufacturer(dto.getManufacturer());
    	demand.setModel(dto.getModel());
    	demand.setPickup_location(dto.getPickup_location());
    	demand.setPickup_time(dto.getPickup_time());
    	demand.setTransmission(dto.getTransmission());
    	
    	CarUsers user = userRepository.findById(dto.getUserId());
    	Car car = carRepo.findById(dto.getCarId());
    	
    	DemandDetails dds = new DemandDetails();
    	if (user != null) {    	
	    	dds.setDemand(demand);
	    	dds.setUser_id(dto.getUserId());
	    	
    	}    	  
    	if(car != null) {
    		dds.setCar_id(dto.getCarId());
    	}
    	
    	demand.setDemandDetails(dds);
        return demandRepository.save(demand);
    }

    public List<Demand> findAllDemands() {
		return demandRepository.findAll();
	}

	@Override
	public Demand findById(Long id) {
		return demandRepository.findById(id);
	}

	@Override
	public void deleteDemandById(Long id) {
		demandRepository.delete(id);
		
	}
	

	@Override
	public void update(Demand demand, DemandRegistrationDto dto) {
		
		demand.setDropoff_location(dto.getDropoff_location());
		demand.setDropoff_time(dto.getDropoff_time());
		demand.setEngineType(dto.getEngineType());
		demand.setFuelCapacity(dto.getFuelCapacity());
		
		demand.setId(dto.getId());
		demand.setInterior(dto.getInterior());
		demand.setManufacturer(dto.getManufacturer());
		demand.setModel(dto.getModel());
		
		demand.setPickup_location(dto.getPickup_location());
		demand.setPickup_time(dto.getPickup_time());
		demand.setTransmission(dto.getTransmission());
		
		
		//CarUsers user = userRepository.findById(dto.getUserId());
		
		DemandDetails dds = demand.getDemandDetails();
		if(dds != null) {    	
	    	dds.setDemand(demand);
	    	dds.setUser_id(dto.getUserId());	    	
    	}    	 
		else {    	
			dds = new DemandDetails();
	    	dds.setDemand(demand);
	    	dds.setUser_id(dto.getUserId());	    		    	
    	}
		
		if (carRepo != null) {
			Car car = carRepo.findById(dto.getCarId());
			if(car != null) {
	    		dds.setCar_id(dto.getCarId());
	    	}
		}
		
		demand.setDemandDetails(dds);
		demandRepository.save(demand);
		
	}

}
