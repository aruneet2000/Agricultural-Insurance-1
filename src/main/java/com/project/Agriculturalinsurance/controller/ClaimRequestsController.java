package com.project.Agriculturalinsurance.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import com.project.Agriculturalinsurance.model.ClaimRequests;
import com.project.Agriculturalinsurance.repository.ClaimRequestsRepository;
import com.project.Agriculturalinsurance.service.ClaimRequestsService;

@Controller
public class ClaimRequestsController {
	@Autowired
	private ClaimRequestsService claimRequestsService;

	@Autowired
	private ClaimRequestsRepository claimRequestsRepository;
	
	private static int count = 1000;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// Date - dd/MM/yyyy
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	@RequestMapping(value = "/claim-request", method = RequestMethod.GET)
	public String showRaiseClaimRequestPage(Model model, @RequestParam String farmerId) {
		String claimId = farmerId+count;
		model.addAttribute("claimRequest", new ClaimRequests(claimId, farmerId, new Date()));
		count++;
		
		List<String> claimTypeList = new ArrayList<String>();
		
		claimTypeList.add("Choose Claim Type");
		claimTypeList.add("Impact due to drought");
		claimTypeList.add("Less crop yield");
		claimTypeList.add("Impact due to hailstrom / landslide");
		claimTypeList.add("Post harvest losses");
		claimTypeList.add("Fluctuating prices of agricultural products");
		claimTypeList.add("Impacts due to pest");
		claimTypeList.add("Other unfortunate event of crop failure");
		
		model.addAttribute("claimTypeList", claimTypeList);
		
		return "dashboards/new-claims";
	}

	@RequestMapping(value = "/claim-request", method = RequestMethod.POST)
	public String saveClaimRequestInDatabase(ModelMap model, @Valid ClaimRequests claimRequest, BindingResult result) {

		if (result.hasErrors()) {
			return "dashboards/new-claims";
		}

		claimRequestsRepository.save(claimRequest);

		return "dashboards/farmer-dashboard";
	}
	
	@RequestMapping(value = "/due-claims", method = RequestMethod.GET)
	public String showDueClaimsPage(ModelMap model) {
		List<ClaimRequests> dueClaimRequests = claimRequestsService.getAllDueClaimRequests();
		model.put("dueClaimRequests", dueClaimRequests);
		return "dashboards/due-claims";
	}
	
	@RequestMapping(value = "/view-requests", method = RequestMethod.GET)
	public String showClaimRequests(ModelMap model, @RequestParam String farmerId) {
		claimRequestsService.getAllClaimRequests();

		List<ClaimRequests> claimRequest = claimRequestsService.findByFarmerId(farmerId);

		model.put("claimRequest", claimRequest);

		return "dashboards/claims";
	}
	
	
}
