package com.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.Car;
import com.model.CarUsers;
import com.model.Demand;
import com.model.DemandDetails;
import com.service.CarService;
import com.service.CarUsersService;
import com.service.DemandService;
import com.web.dto.DemandRegistrationDto;

@Controller
@RequestMapping("/demand")
public class DemandRegistrationController {

	//private Map<Long, String> users = new HashMap<>();
	//private Map<Long, String> cars = new HashMap<>();
	
    @Autowired
    private DemandService demandService;
    
    @Autowired
    private CarUsersService userService;
    
    @Autowired
    private CarService carService;

    @ModelAttribute("demand")
    public DemandRegistrationDto demandRegistrationDto() {
    	//this.users = initUsers();
    	//this.cars = initCars();
    	
        return new DemandRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm(Model model) {    	
    
    	model.addAttribute("times", initTimeList());        
        
        model.addAttribute("fuelType", initFuelType());
        model.addAttribute("hiddenField", true);
        
        model.addAttribute("userMap", initUsers());
        model.addAttribute("carMap" , initCars());
        
        return "demand";
    }

    private Map<Long, String> initUsers() {

    	System.out.println(userService.findAllUsers());
    	Iterator<CarUsers> itr = userService.findAllUsers().iterator();
    	
    	Map<Long, String> userMap = new HashMap<>();
    	userMap.put(new Long(0), "");
    	
    	while (itr.hasNext()) {
    		CarUsers user = itr.next();
    		userMap.put(user.getId(), user.getEmail());
    		
    	}
        
		return userMap;
	}

    private Map<Long, String> initCars() {
    	Map<Long, String> carMap = new HashMap<>();
    	carMap.put(new Long(0), "");
    	
    	Set<Long> carIdSet = new HashSet<>();
    	Iterator<Demand> demandItr = demandService.findAllDemands().iterator();
    	while (demandItr.hasNext()) {
    		Demand demand = demandItr.next();
    		if(demand.getDemandDetails() != null) {
    			carIdSet.add(demand.getDemandDetails().getCar_id());
    		}
    	}
    	
    	Iterator<Car> itr = carService.findAllCars().iterator();    	
    	
    	while (itr.hasNext()) {
    		Car car = itr.next();
    		if(!carIdSet.contains(car.getId())) {
	    		String modelStr = (car.getManufacturer() != null ? car.getManufacturer() : "" )
	    				+ (car.getModel() != null ? "_" + car.getModel() : "" ) 
	    		+ (car.getEngineType() != null ? "_" + car.getEngineType() : "" );
	    		
	    		System.out.println("----------"  + modelStr);
	    		carMap.put(car.getId(), modelStr);
    		}
    	}
        
		return carMap;
	}
	private List<String> initFuelType() {
    	List<String> fuelType = new ArrayList<>();
    	fuelType.add("Diesel");
        fuelType.add("Petrol");
        fuelType.add("Gas");
        
		return fuelType;
	}

	private List<String> initTimeList() {
    	List<String> list = new ArrayList<String>();
        list.add("00:00");
        list.add("00:30");
        list.add("01:00");
        list.add("01:30");
        
        list.add("02:00");
        list.add("02:30");
        list.add("03:00");
        list.add("03:30");
        
        list.add("04:00");
        list.add("04:30");
        list.add("05:00");
        list.add("05:30");
        list.add("06:00");
        list.add("06:30");
        list.add("07:00");
        list.add("07:30");
        
        list.add("08:00");
        list.add("08:30");
        list.add("09:00");
        list.add("09:30");
        list.add("10:00");
        list.add("10:30");
        list.add("11:00");
        list.add("11:30");
        list.add("12:00");
        list.add("12:30");
        
        list.add("13:00");
        list.add("13:30");
        list.add("14:00");
        list.add("14:30");
        list.add("15:00");
        list.add("15:30");
        
        
        list.add("16:00");
        list.add("16:30");
        list.add("17:00");
        list.add("17:30");
        list.add("18:00");
        list.add("18:30");
        
        
        list.add("19:00");
        list.add("19:30");
        list.add("20:00");
        list.add("20:30");
        list.add("21:00");
        list.add("21:30");
        
        list.add("22:00");
        list.add("22:30");
        list.add("23:00");
        list.add("23:30");
        
        
		return list;
	}

	@PostMapping
    public String registerDemand(@ModelAttribute("demand") @Valid DemandRegistrationDto demandDto,
                                      BindingResult result){

    	long id = demandDto.getId();
    	
    	if(id > 0) {
    		//edit
    		Demand existing = demandService.findById(id);

	        if (result.hasErrors()){
	            return "demand";
	        }
	        
	        demandService.update(existing, demandDto);
	        
    	}
    	else {       
	        if (result.hasErrors()){
	            return "demand";
	        }
	
	        demandService.save(demandDto);
    	}
        return "redirect:/demand?success";
    }
	
	/*
	@PostMapping("/assign")
    public String assignDemand(@ModelAttribute("demand") @Valid DemandRegistrationDto demandDto,
                                      BindingResult result){

		System.out.println("----------" + demandDto);
    	long id = demandDto.getId();
    	
    	if(id > 0) {
    		//edit
    		Demand existing = demandService.findById(id);

	        if (result.hasErrors()){
	            return "demandList";
	        }
	        
	        demandService.update(existing, demandDto);
	        
    	}
    	
        return "redirect:/demandList?success";
    }
    
    */
	@RequestMapping(value = "/demandList", method = RequestMethod.GET)
	public String demandList(Model model) {
		List<Demand> demandsList = demandService.findAllDemands();

		List<Demand> newList = new ArrayList<>();
		if(demandsList != null) {
					
			for(Demand demand : demandsList){
				if (demand.getDemandDetails() != null) {		
					demand.setUserId(demand.getDemandDetails().getUser_id());
					demand.setCarId(demand.getDemandDetails().getCar_id());
					newList.add(demand);
				}
			}
		}
		
		model.addAttribute("demandList", newList);

		model.addAttribute("hideLabel", true);
        return "demandList";
	}
		
	@RequestMapping(value = "/currentDemandList", method = RequestMethod.GET)
	public String currentDemandList(Model model) {
		List<Demand> demandsList = demandService.findAllDemands();		
		
		List<Demand> newList = new ArrayList<>();
		
		if(demandsList != null) {
			
			for(Demand demand : demandsList){
				if (demand.getDemandDetails() != null && 
						(demand.getDemandDetails().getCar_id() <= 0 || demand.getDemandDetails().getUser_id() <= 0)) {		
					demand.setUserId(demand.getDemandDetails().getUser_id());
					demand.setCarId(demand.getDemandDetails().getCar_id());
					newList.add(demand);
				}
				else if(demand.getDemandDetails() == null) {
					newList.add(demand);
				}
			}
		}
		
		model.addAttribute("demandList", newList);
		model.addAttribute("hideLabel", false);		
        return "demandList";
	}
	
		
		
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteDemand(@PathVariable("id") Long id, Model model) {
    	
		Demand demand = demandService.findById(id);
		if(demand != null) {
			demandService.deleteDemandById(id);
		}
		
        return "redirect:/demand/demandList";
	}
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public String showUser(@PathVariable("id") Long id, Model model) {
    	
		CarUsers user = userService.findById(id);
		if(user != null) {
			List<CarUsers> users = new ArrayList<>();
			users.add(user);
			model.addAttribute("usersList", users);
			
	        return "userDetails";
		}		
        return "redirect:/demand/demandList";
	}


	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String showRegistrationFormEdit(@PathVariable("id") Long id, 
			@RequestParam(value = "param1", defaultValue="edit") String param1, Model model) {
    	
		System.out.println(param1);
		
		Demand demand = demandService.findById(id);
		DemandDetails dds = demand.getDemandDetails();
		demand.setUserId(dds.getUser_id());
		demand.setCarId(dds.getCar_id());
		
        model.addAttribute("times", initTimeList());        
        
        model.addAttribute("fuelType", initFuelType());
        
        model.addAttribute("userMap", initUsers());
        model.addAttribute("carMap" , initCars());
        
		model.addAttribute("disableField", false);
		model.addAttribute("hiddenField", true);
		model.addAttribute("demand", demand);
		
		if("assign".equalsIgnoreCase(param1)) {
			model.addAttribute("disableField", true);
			model.addAttribute("hiddenField", false);
		}
        return "demand";
	}
	
	
	@RequestMapping(value = "/assign/{id}", method = RequestMethod.GET)
	public String showRegistrationFormAssign(@PathVariable("id") Long id, Model model) {
    	
		Demand demand = demandService.findById(id);
		DemandDetails dds = demand.getDemandDetails();
		demand.setUserId(dds.getUser_id());
		demand.setCarId(dds.getCar_id());
		
        model.addAttribute("times", initTimeList());        
        
        model.addAttribute("fuelType", initFuelType());
        
        model.addAttribute("userMap", initUsers());
        model.addAttribute("carMap" , initCars());
        
		model.addAttribute("disableField", true);
		model.addAttribute("hiddenField", false);
		model.addAttribute("demand", demand);
		
        return "bookcar";
	}
	

}
