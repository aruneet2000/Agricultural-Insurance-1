package com.project.Agriculturalinsurance.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.Agriculturalinsurance.model.Farmer;

@Service
public interface FarmerService {
	public Farmer findByFarmerId(String farmerId);
    
	public void getAllFarmers();
	
	boolean validateFarmers(String firstName, String password);

	public Farmer getFarmerById(String farmerId);
	
	public List<Farmer> getUnApprovedFarmer();

	void rejectFarmer(int id);

	void approveFarmer(int id);
	
}
