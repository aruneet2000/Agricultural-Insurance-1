package com.project.Agriculturalinsurance.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import com.project.Agriculturalinsurance.repository.FarmerRepository;
import com.project.Agriculturalinsurance.model.Farmer;
import com.project.Agriculturalinsurance.service.FarmerService;


@Controller
@SessionAttributes("farmer")
public class FarmerController {

	@Autowired
	private FarmerService farmerService;
	
	@Autowired
	private FarmerRepository farmerRepository;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// Date - dd/MM/yyyy
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}
	
	@RequestMapping(value = "/farmer-registration" , method = RequestMethod.GET)
    public String showFarmerRegistrationPage(Model model) {
        model.addAttribute("farmer", new Farmer());

        return "registration-forms/farmer-registration";
    }

	@RequestMapping(value = "/farmer-registration" , method = RequestMethod.POST)
	public String saveFarmerDetails(ModelMap model, @Valid Farmer farmer, BindingResult result) {

		if (result.hasErrors()) {
			return "registration-forms/farmer-registration";
		}
		
		farmerRepository.save(farmer);
		
		return "redirect:/farmer-login";
	}
	
	@RequestMapping(value = "/farmer-login", method = RequestMethod.GET)
	public String showFarmerLoginPage() {
		return "login-forms/farmer-login";
	}
	
	@RequestMapping(value="/farmer-login", method = RequestMethod.POST)
	public String showFarmerDashboardPage(ModelMap model, @RequestParam String farmerId, @RequestParam String password){
		farmerService.getAllFarmers();
		
		
		boolean isValidFarmer = farmerService.validateFarmers(farmerId, password);
		
		if (!isValidFarmer) {
			model.put("errorMessage", "Invalid Credentials");
			return "login-forms/farmer-login";
		}
		
		
		Farmer farmer = farmerService.findByFarmerId(farmerId);
		
		model.put("farmer", farmer);
		
		return "dashboards/farmer-dashboard";
	}
	
	@RequestMapping(value="/farmer-dashboard", method = RequestMethod.GET)
	public String showFarmerDashboardPage() {
		return "dashboards/farmer-dashboard";
	}

}
