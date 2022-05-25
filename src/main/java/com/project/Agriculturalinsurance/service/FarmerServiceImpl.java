package com.project.Agriculturalinsurance.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Agriculturalinsurance.model.ClaimOfficer;
import com.project.Agriculturalinsurance.model.Farmer;
import com.project.Agriculturalinsurance.repository.FarmerRepository;

@Service
public class FarmerServiceImpl implements FarmerService{
private List<Farmer> farmerList = new ArrayList<Farmer>();
    
    @Autowired
    private FarmerRepository farmerRepository;
    
	@Override
	public Farmer findByFarmerId(String farmerId) {
		for(Farmer farmer : farmerList) {
			if(farmer.getFarmerId().equals(farmerId)) {
				return farmer;
			}
		}
		
		return null;
	}
	
	@Override
	public void getAllFarmers() {
		farmerList = farmerRepository.findAll();
	}

	@Override
	public boolean validateFarmers(String farmerId, String password) {
		
		for(Farmer farmer : farmerList) {
			if(farmer.getFarmerId().equals(farmerId) && farmer.getPassword().equals(password)) {
				return true;
			}
		}
		
		return false;
	}

	@Override
	public Farmer getFarmerById(String farmerId) {
		getAllFarmers();
		for(Farmer farmer : farmerList) {
			if(farmer.getFarmerId().equals(farmerId)) {
				return farmer;
			}
		}
		return null;
	}

	@Override
	public List<Farmer> getUnApprovedFarmer() {
		List<Farmer> unApprovedFarmer = new ArrayList<Farmer>();
		getAllFarmers();
		for(Farmer farmer : farmerList) {
			if(!farmer.isApproved()) {
				unApprovedFarmer.add(farmer);
			}
		}
		
		return unApprovedFarmer;
	}

	@Override
	public void rejectFarmer(int id) {
		for(Farmer farmer : farmerList) {
			if(farmer.getId()==id) {
				farmerRepository.delete(farmer);
				/*
				 * farmer.setApproved(false); farmerRepository.save(farmer);
				 */
				break;
			}
		}
	}

	@Override
	public void approveFarmer(int id) {
		for(Farmer farmer : farmerList) {
			if(farmer.getId()==id) {
				farmer.setApproved(true);
				farmerRepository.save(farmer);
				break;
			}
		}
	}


}
