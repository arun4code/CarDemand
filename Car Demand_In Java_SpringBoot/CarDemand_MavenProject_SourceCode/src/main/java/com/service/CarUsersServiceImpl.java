package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.CarUsers;
import com.repository.CarUsersRepository;
import com.web.dto.CarUsersRegistrationDto;

@Service
public class CarUsersServiceImpl implements CarUsersService {

    @Autowired
    private CarUsersRepository userRepository;

    public CarUsers findByEmail(String email){
        return userRepository.findByEmail(email);
    }
    
    public CarUsers findByName(String firstName) {
    	return userRepository.findByFirstName(firstName);
	}

    public CarUsers save(CarUsersRegistrationDto registration){
        CarUsers user = new CarUsers();
        user.setFirstName(registration.getFirstName());
        user.setLastName(registration.getLastName());
        user.setEmail(registration.getEmail());
        user.setCity(registration.getCity());
        
        user.setContact(registration.getContact());
        user.setCountry(registration.getCountry());
        user.setLicense(registration.getLicense());
        user.setZip(registration.getZip());
                
        return userRepository.save(user);
    }

    public List<CarUsers> findAllUsers() {
		return userRepository.findAll();
	}
	
	public void deleteUserById(long id) {
		userRepository.delete(id);
		
	}
	
    public boolean isUserExist(CarUsers user) {
		return findByName(user.getFirstName())!=null;
	}

	@Override
	public void updateUser(CarUsers user) {
		userRepository.save(user);
		
	}

	@Override
	public CarUsers findById(long id) {
		return userRepository.findById(id);
		
	}

	@Override
	public void update(CarUsers user, CarUsersRegistrationDto dto) {
		user.setCity(dto.getCity());
		user.setContact(dto.getContact());
		user.setCountry(dto.getCountry());
		
		user.setId(dto.getId());
		user.setFirstName(dto.getFirstName());
		user.setLastName(dto.getLastName());
		user.setLicense(dto.getLicense());
		
		user.setZip(dto.getZip());
		
		user.setEmail(dto.getEmail());
		
		userRepository.save(user);
		
	}
}
