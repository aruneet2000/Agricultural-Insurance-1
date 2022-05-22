package com.project.Agriculturalinsurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.Agriculturalinsurance.model.Admin;
import com.project.Agriculturalinsurance.service.AdminService;

@Controller
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value = "/admin-login", method = RequestMethod.GET)
	public String showOfficerLoginPage() {
		return "login-forms/admin-login";
	}
	
	@RequestMapping(value="/admin-login", method = RequestMethod.POST)
	public String showAdminDashboardPage(ModelMap model, @RequestParam String userId, @RequestParam String password){
		adminService.loadAdmin();
		
		boolean isValidAdmin = adminService.validateAdmin(userId, password);
		
		if (!isValidAdmin) {
			model.put("errorMessage", "Invalid Credentials");
			return "login-forms/admin-login";
		}
		
		model.put("admin", new Admin(userId,password));
		
		return "dashboards/admin-dashboard";
	}
}
