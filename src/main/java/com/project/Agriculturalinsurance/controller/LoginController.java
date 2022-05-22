package com.project.Agriculturalinsurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.project.Agriculturalinsurance.service.ClaimOfficerService;
import com.project.Agriculturalinsurance.service.LoginService;


@Controller
@SessionAttributes("name")
public class LoginController {
	
	@Autowired
	LoginService service;
	
	@RequestMapping(value = "/farmer-login", method = RequestMethod.GET)
	public String showFarmerLoginPage() {
		return "login-forms/farmer-login";
	}
	
	@RequestMapping(value="/farmer-login", method = RequestMethod.POST)
	public String showFarmerDashboardPage(ModelMap model, @RequestParam String name, @RequestParam String password){
		
		boolean isValidUser = service.validateFarmer(name, password);
		
		if (!isValidUser) {
			model.put("errorMessage", "Invalid Credentials");
			return "login-forms/farmer-login";
		}
		
		model.put("name", name);
		model.put("password", password);
		
		return "dashboards/farmer-dashboard";
	}
	
}
