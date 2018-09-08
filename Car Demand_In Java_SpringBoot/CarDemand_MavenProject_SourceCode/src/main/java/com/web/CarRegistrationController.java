package com.web;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.service.CarService;
import com.web.dto.CarRegistrationDto;

@Controller
@RequestMapping("/car_registration")
public class CarRegistrationController {

    @Autowired
    private CarService carService;

    @ModelAttribute("car")
    public CarRegistrationDto carRegistrationDto() {
        return new CarRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
    	List<String> fuelType = new ArrayList<String>();
        fuelType.add("Diesel");
        fuelType.add("Petrol");
        fuelType.add("Gas");
        
        model.addAttribute("fuelType", fuelType);
        
        return "car_registration";
    }

    @PostMapping
    public String registerCarAccount(@ModelAttribute("car") @Valid CarRegistrationDto carDto,
                                      BindingResult result){

        //Car existing = carService.findByModel(carDto.getModel());

        if (result.hasErrors()){
            return "car_registration";
        }

        carService.save(carDto);
        return "redirect:/car_registration?success";
    }

}
