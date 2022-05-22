package com.project.Agriculturalinsurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.project.Agriculturalinsurance.model.ClaimOfficer;

@Component
public interface ClaimOfficerRepository extends JpaRepository<ClaimOfficer, Long> {

}
