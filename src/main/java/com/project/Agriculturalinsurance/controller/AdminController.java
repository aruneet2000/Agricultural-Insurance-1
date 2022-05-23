package com.project.Agriculturalinsurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.project.Agriculturalinsurance.model.Admin;
import com.project.Agriculturalinsurance.model.ClaimOfficer;
import com.project.Agriculturalinsurance.service.AdminService;
import com.project.Agriculturalinsurance.service.ClaimOfficerService;

@Controller
@SessionAttributes({"admin","unApprovedOfficer"})
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private ClaimOfficerService claimOfficerService;
	
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
		
		claimOfficerService.getAllOfficers();
		List<ClaimOfficer> unApprovedOfficer = claimOfficerService.getUnApprovedOfficer();
		model.put("admin", new Admin(userId,password));
		model.put("unApprovedOfficer", unApprovedOfficer);
		
		return "dashboards/admin-dashboard";
	}
	
	
	@RequestMapping(value = "/approve-officer", method = RequestMethod.GET)
	public String approveOfficerRegistrationRequest(ModelMap model, @RequestParam int id) {
		claimOfficerService.approveOfficer(id);
		claimOfficerService.getAllOfficers();
		List<ClaimOfficer> unApprovedOfficer = claimOfficerService.getUnApprovedOfficer();
		if(unApprovedOfficer.size()==0) {
			model.put("emptyList", "Currently No Requests to Show");
		}
		else model.put("unApprovedOfficer", unApprovedOfficer);
		return "dashboards/admin-dashboard";
	}
	
	@RequestMapping(value = "/reject-officer", method = RequestMethod.GET)
	public String rejectOfficerRegistrationRequest(ModelMap model, @RequestParam int id) {
		claimOfficerService.rejectOfficer(id);
		claimOfficerService.getAllOfficers();
		List<ClaimOfficer> unApprovedOfficer = claimOfficerService.getUnApprovedOfficer();
		model.put("unApprovedOfficer", unApprovedOfficer);
		return "dashboards/admin-dashboard";
	}
}
