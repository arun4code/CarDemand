package com.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.CarUsers;
import com.service.CarUsersService;
import com.web.dto.CarUsersRegistrationDto;

@Controller
@RequestMapping("/user_registration")
public class CarUsersRegistrationController {
	 @Autowired
    private CarUsersService carService;

    @ModelAttribute("carusers")
    public CarUsersRegistrationDto carRegistrationDto() {
        return new CarUsersRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
    	
    	return "user_registration";
    	
    	
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String showRegistrationFormEdit(@PathVariable("id") Long id, Model model) {
    	
		CarUsers users = carService.findById(id);
		
		model.addAttribute("disableField", true);
		model.addAttribute("carusers", users);
		
        return "user_registration";
	}
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteUser(@PathVariable("id") Long id, Model model) {
    	
		CarUsers users = carService.findById(id);
		if(users != null) {
			carService.deleteUserById(id);
		}
		
        return "redirect:/user_registration/usersList";
	}
    
    @RequestMapping(method=RequestMethod.POST)
    public String registerCarAccount(@ModelAttribute("carusers") @Valid CarUsersRegistrationDto carDto,
                                      BindingResult result){

    	long id = carDto.getId();
    	System.out.println(id);
    	if(id > 0) {
    		//edit
    		CarUsers existing = carService.findById(id);

	        if (result.hasErrors()){
	            return "user_registration";
	        }
	        
	        carService.update(existing, carDto);
	        
    	}
    	else {
	        CarUsers existing = carService.findByEmail(carDto.getEmail());
	        if (existing != null){
	            result.rejectValue("email", null, "There is already one user registered with same email");
	        }
	
	        if (result.hasErrors()){
	            return "user_registration";
	        }
	
	        carService.save(carDto);
    	}
        return "redirect:/user_registration?success";
    }
    

	@RequestMapping(value = "/usersList", method = RequestMethod.GET)
	public String usersList(Model model) {
		List<CarUsers> users = carService.findAllUsers();
				
		model.addAttribute("usersList", users);
		
        return "userDetails";
	}
    
	
    @RequestMapping("/update")
    public String editCarUsers(@ModelAttribute("carusers") CarUsers carusers, 
    		@PathVariable("id") Long id,
    		BindingResult result,  Model model){

        //CarUsers existing = carService.findById(id);
        
        //carService.save(carDto);
        return "redirect:/user_registration?success";
    }
    
    

}
