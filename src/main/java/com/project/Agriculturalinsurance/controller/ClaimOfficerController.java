package com.project.Agriculturalinsurance.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import com.project.Agriculturalinsurance.model.ClaimOfficer;
import com.project.Agriculturalinsurance.model.Farmer;
import com.project.Agriculturalinsurance.repository.ClaimOfficerRepository;
import com.project.Agriculturalinsurance.service.ClaimOfficerService;
import com.project.Agriculturalinsurance.service.FarmerService;


@Controller
@SessionAttributes("claimOfficer")
public class ClaimOfficerController {
	
	@Autowired
	private ClaimOfficerService claimOfficerService;
	
	@Autowired
	private ClaimOfficerRepository claimOfficerRepository;
	
	@Autowired
	private FarmerService farmerService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// Date - dd/MM/yyyy
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}
	
	@RequestMapping(value = "/officer-registration" , method = RequestMethod.GET)
    public String showOfficerRegistrationPage(Model model) {
        model.addAttribute("claimOfficer", new ClaimOfficer());

        return "registration-forms/officer-registration";
    }

	@RequestMapping(value = "/officer-registration" , method = RequestMethod.POST)
	public String saveOfficerDetails(ModelMap model, @Valid ClaimOfficer claimOfficer, BindingResult result) {

		if (result.hasErrors()) {
			return "registration-forms/officer-registration";
		}
		
		claimOfficerRepository.save(claimOfficer);
		
		return "redirect:/officer-login";
	}
	
	@RequestMapping(value = "/officer-login", method = RequestMethod.GET)
	public String showOfficerLoginPage() {
		return "login-forms/officer-login";
	}
	
	@RequestMapping(value="/officer-login", method = RequestMethod.POST)
	public String showOfficerDashboardPage(ModelMap model, @RequestParam String officerId, @RequestParam String password){
		claimOfficerService.getAllOfficers();
		
		
		boolean isValidOfficer = claimOfficerService.validateOfficer(officerId, password);
		
		if (!isValidOfficer) {
			model.put("errorMessage", "Invalid Credentials");
			return "login-forms/officer-login";
		}
		
		
		ClaimOfficer claimOfficer = claimOfficerService.findByOfficerId(officerId);
		
		model.put("claimOfficer", claimOfficer);
		
		return "dashboards/officer-dashboard";
	}
	
	@RequestMapping(value = "/officer-dashboard", method = RequestMethod.GET)
	public String redirectToDashboardPage(ModelMap model) {
		
		return "dashboards/officer-dashboard";
	}
	
	@RequestMapping(value = "/farmer", method = RequestMethod.GET)
	public String redirectToDashboardPage(ModelMap model, @RequestParam  String farmerId) {
		Farmer farmer = farmerService.getFarmerById(farmerId);
		model.put("farmer", farmer);
		return "pages/farmer";
	}
	
}
