package com.example.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project.models.DocumentDetails;


@Repository
public interface DocumentRepository extends JpaRepository<DocumentDetails, Integer> {
	//public DocumentDetails findByapplication_details(Integer application_details);
	//public DocumentDetails findByappId(int appId);

}
