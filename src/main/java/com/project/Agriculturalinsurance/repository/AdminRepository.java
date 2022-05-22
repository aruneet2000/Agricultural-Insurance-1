package com.project.Agriculturalinsurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.project.Agriculturalinsurance.model.Admin;

@Component
public interface AdminRepository extends JpaRepository<Admin, Long>{

}
