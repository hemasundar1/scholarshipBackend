package com.example.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project.models.Application_details;
import com.example.project.models.DocumentDetails;

public interface ApplicationDetailsRepository extends JpaRepository<Application_details,Integer> {
	
	

}
