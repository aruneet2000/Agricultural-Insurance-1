package com.project.Agriculturalinsurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.project.Agriculturalinsurance.model.ClaimRequests;


@Component
public interface ClaimRequestsRepository extends JpaRepository<ClaimRequests, Long>{

}
