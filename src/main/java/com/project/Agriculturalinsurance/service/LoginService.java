package com.project.Agriculturalinsurance.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

	public boolean validateAdmin(String name, String pwd) {
		return name.equalsIgnoreCase("Admin") && pwd.equalsIgnoreCase("dummy");
	}
	
	public boolean validateFarmer(String name, String pwd) {
		return name.equalsIgnoreCase("Farmer") && pwd.equalsIgnoreCase("dummy");
	}

}
