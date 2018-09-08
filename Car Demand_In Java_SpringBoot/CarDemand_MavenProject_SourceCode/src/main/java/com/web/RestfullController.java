package com.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.model.Car;
import com.model.CarUsers;
import com.model.Demand;
import com.service.CarService;
import com.service.CarUsersService;
import com.service.DemandService;

@RestController
@RequestMapping("/users")
public class RestfullController {
	@Autowired
	CarUsersService userService;
	
	@Autowired
	DemandService demandService;
	
	@Autowired
	CarService carService;
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ResponseEntity<List<CarUsers>> findAllUsers() {
		List<CarUsers> users = userService.findAllUsers();
		if (users.isEmpty()) {
			return new ResponseEntity<List<CarUsers>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<CarUsers>>(users, HttpStatus.OK);
	}


	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateUser(@PathVariable("id") long id, @RequestBody CarUsers user) {

		CarUsers currentUser = userService.findById(id);

		if (currentUser == null) {
			return new ResponseEntity<ErrorType>(new ErrorType("ERROR: Id =" + id + " not found."),
					HttpStatus.NOT_FOUND);
		}

		currentUser.setFirstName(user.getFirstName());
		currentUser.setLastName(user.getLastName());
		currentUser.setCity(user.getCity());
		currentUser.setContact(user.getContact());
		currentUser.setLicense(user.getLicense());
		currentUser.setZip(user.getZip());
		
		
		userService.updateUser(currentUser);
		return new ResponseEntity<CarUsers>(currentUser, HttpStatus.OK);
	}

	
	@RequestMapping(value = "/demands", method = RequestMethod.GET)
	public ResponseEntity<List<Demand>> findAllDemands() {
		List<Demand> demands = demandService.findAllDemands();
		if (demands.isEmpty()) {
			return new ResponseEntity<List<Demand>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Demand>>(demands, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/cars", method = RequestMethod.GET)
	public ResponseEntity<List<Car>> findAllCars() {
		List<Car> users = carService.findAllCars();
		if (users.isEmpty()) {
			return new ResponseEntity<List<Car>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Car>>(users, HttpStatus.OK);
	}
}
