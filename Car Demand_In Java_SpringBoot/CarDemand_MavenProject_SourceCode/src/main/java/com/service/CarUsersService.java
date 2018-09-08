package com.service;

import java.util.List;

import com.model.CarUsers;
import com.web.dto.CarUsersRegistrationDto;

public interface CarUsersService {

    CarUsers findByEmail(String email);

    CarUsers save(CarUsersRegistrationDto registration);
    
    void updateUser(CarUsers user);
    List<CarUsers> findAllUsers();
    
	void deleteUserById(long id);
	
	boolean isUserExist(CarUsers user);

	CarUsers findById(long id);

	void update(CarUsers existing, CarUsersRegistrationDto dto);
	
}
