package com.project.Agriculturalinsurance.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Agriculturalinsurance.model.ClaimRequests;
import com.project.Agriculturalinsurance.repository.ClaimRequestsRepository;

@Service
public class ClaimRequestsService {
	
	private List<ClaimRequests> claimRequestsList = new ArrayList<ClaimRequests>();
	
	@Autowired
    private ClaimRequestsRepository claimRequestsRepository;

	public void getAllClaimRequests() {
		claimRequestsList = claimRequestsRepository.findAll();
	}

	public List<ClaimRequests> findByFarmerId(String farmerId) {
		List<ClaimRequests> claimRequestsByThisFarmer = new ArrayList<ClaimRequests>();
		getAllClaimRequests();
		for(ClaimRequests claimRequest:claimRequestsList) {
			if(claimRequest.getFarmerId().equals(farmerId)) {
				claimRequestsByThisFarmer.add(claimRequest);
			}
		}
		return claimRequestsByThisFarmer;
	}

	public List<ClaimRequests> getAllDueClaimRequests() {
		List<ClaimRequests> dueClaimRequests = new ArrayList<ClaimRequests>();
		getAllClaimRequests();
		for(ClaimRequests claimRequest:claimRequestsList) {
			if(claimRequest.isDue()) {
				dueClaimRequests.add(claimRequest);
			}
		}
		return dueClaimRequests;
	}

}
