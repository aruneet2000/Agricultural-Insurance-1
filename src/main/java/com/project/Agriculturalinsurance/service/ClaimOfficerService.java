package com.project.Agriculturalinsurance.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.Agriculturalinsurance.model.ClaimOfficer;

@Service
public interface ClaimOfficerService {
	
    public ClaimOfficer findByOfficerId(String officerId);
	public void getAllOfficers();
	public List<ClaimOfficer> getUnApprovedOfficer();
	boolean validateOfficer(String firstName, String password);
	public void rejectOfficer(int id);
	public void approveOfficer(int id);
}
