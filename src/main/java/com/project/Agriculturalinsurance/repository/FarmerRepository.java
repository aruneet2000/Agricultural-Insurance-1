package com.project.Agriculturalinsurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.project.Agriculturalinsurance.model.Farmer;

@Component
public interface FarmerRepository extends JpaRepository<Farmer, Long>{

}