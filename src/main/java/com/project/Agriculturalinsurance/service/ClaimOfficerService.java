package com.project.Agriculturalinsurance.service;

import org.springframework.stereotype.Service;

import com.project.Agriculturalinsurance.model.ClaimOfficer;

@Service
public interface ClaimOfficerService {
    public ClaimOfficer findByOfficerId(String officerId);
    
	public void getAllOfficers();
	
	boolean validateOfficer(String firstName, String password);
}
