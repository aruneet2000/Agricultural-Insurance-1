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
import com.project.Agriculturalinsurance.model.Farmer;
import com.project.Agriculturalinsurance.service.AdminService;
import com.project.Agriculturalinsurance.service.ClaimOfficerService;
import com.project.Agriculturalinsurance.service.FarmerService;

@Controller
@SessionAttributes({"admin","unApprovedOfficer","unApprovedFarmer"})
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private ClaimOfficerService claimOfficerService;
	
	@Autowired
	private FarmerService farmerService;
	
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
	
	@RequestMapping(value = "/pending-requests", method = RequestMethod.GET)
	public String showPendingRegistrationRequestsPage(ModelMap model) {
		
		List<ClaimOfficer> unApprovedOfficer = claimOfficerService.getUnApprovedOfficer();
		List<Farmer> unApprovedFarmer = farmerService.getUnApprovedFarmer();
		
		model.put("unApprovedOfficer", unApprovedOfficer);
		model.put("unApprovedFarmer", unApprovedFarmer);
		
		return "pages/pending-regi-request";
	}
	
	@RequestMapping(value = "/approve-officer", method = RequestMethod.GET)
	public String approveOfficerRegistrationRequest(ModelMap model, @RequestParam int id) {
		claimOfficerService.approveOfficer(id);
		List<ClaimOfficer> unApprovedOfficer = claimOfficerService.getUnApprovedOfficer();
		
//		if(unApprovedOfficer.size()==0) {
//			model.put("emptyList", "Currently No Requests to Show");
//		}
//		else model.put("unApprovedOfficer", unApprovedOfficer);
		
		model.put("unApprovedOfficer", unApprovedOfficer);
		return "pages/pending-regi-request";
	}
	
	@RequestMapping(value = "/reject-officer", method = RequestMethod.GET)
	public String rejectOfficerRegistrationRequest(ModelMap model, @RequestParam int id) {
		claimOfficerService.rejectOfficer(id);
		List<ClaimOfficer> unApprovedOfficer = claimOfficerService.getUnApprovedOfficer();
		model.put("unApprovedOfficer", unApprovedOfficer);
		return "pages/pending-regi-request";
	}
	
	@RequestMapping(value = "/approve-farmer", method = RequestMethod.GET)
	public String approveFarmerRegistrationRequest(ModelMap model, @RequestParam int id) {
		farmerService.approveFarmer(id);
		List<Farmer> unApprovedFarmer = farmerService.getUnApprovedFarmer();
		
//		if(unApprovedFarmer.size()==0) {
//			model.put("emptyList", "Currently No Requests to Show");
//		}
//		else model.put("unApprovedFarmer", unApprovedFarmer);
		
		model.put("unApprovedFarmer", unApprovedFarmer);
		return "pages/pending-regi-request";
	}
	
	@RequestMapping(value = "/reject-farmer", method = RequestMethod.GET)
	public String rejectFarmerRegistrationRequest(ModelMap model, @RequestParam int id) {
		farmerService.rejectFarmer(id);
		List<Farmer> unApprovedFarmer = farmerService.getUnApprovedFarmer();
		model.put("unApprovedFarmer", unApprovedFarmer);
		return "pages/pending-regi-request";
	}
	
	@RequestMapping(value="/admin-dashboard", method = RequestMethod.GET)
	public String showAdminDashboardPage() {
		return "dashboards/admin-dashboard";
	}
}
