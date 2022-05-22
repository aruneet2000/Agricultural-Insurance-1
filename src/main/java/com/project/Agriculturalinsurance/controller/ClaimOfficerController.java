package com.project.Agriculturalinsurance.controller;

import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.Agriculturalinsurance.model.ClaimOfficer;
import com.project.Agriculturalinsurance.repository.ClaimOfficerRepository;
import com.project.Agriculturalinsurance.service.ClaimOfficerService;


@Controller
public class ClaimOfficerController {
	
	@Autowired
	private ClaimOfficerService claimOfficerService;
	
	@Autowired
	private ClaimOfficerRepository claimOfficerRepository;
	
	@RequestMapping(value = "/officer-registration" , method = RequestMethod.GET)
    public String showOfficerRegistrationPage(Model model) {
        model.addAttribute("claimOfficer", new ClaimOfficer());

        return "registration-forms/officer-registration";
    }

	@RequestMapping(value = "/officer-registration" , method = RequestMethod.POST)
	public String saveOfficerDetails(ModelMap model,ClaimOfficer claimOfficer, BindingResult result) {

//		if (result.hasErrors()) {
//			return "registration-forms/officer-registration";
//		}
		
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
}
