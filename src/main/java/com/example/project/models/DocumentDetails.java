package com.example.project.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.project.models.Application_details;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity

@CrossOrigin(origins = "http://localhost:4200")
public class DocumentDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private String adharNum;
	private String accountNum;
	private String ifscNum;
	private String branch;
	private String rollNum;
	
	
	@OneToOne(fetch= FetchType.EAGER)
	//@JsonIgnore
	@JoinColumn(name="applicationId", referencedColumnName = "appId")
	private Application_details application_details;
	
	public DocumentDetails(String adharNum, String accountNum, String ifscNum, String branch,String rollNum) {
		super();
		this.adharNum = adharNum;
		this.accountNum = accountNum;
		this.ifscNum = ifscNum;
		this.branch = branch;
		this.rollNum=rollNum;

	}
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getAdharNum() {
		return adharNum;
	}



	public void setAdharNum(String adharNum) {
		this.adharNum = adharNum;
	}



	public String getAccountNum() {
		return accountNum;
	}



	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}



	public String getIfscNum() {
		return ifscNum;
	}



	public void setIfscNum(String ifscNum) {
		this.ifscNum = ifscNum;
	}



	public String getBranch() {
		return branch;
	}



	public void setBranch(String branch) {
		this.branch = branch;
	}



	public String getRollNum() {
		return rollNum;
	}



	public void setRollNum(String rollNum) {
		this.rollNum = rollNum;
	}



	public Application_details getApplication_details() {
		return application_details;
	}



	public void setApplication_details(Application_details application_details) {
		this.application_details = application_details;
	}



	public DocumentDetails(int id, String adharNum, String accountNum, String ifscNum, String branch, String rollNum,
			Application_details application_details) {
		super();
		this.id = id;
		this.adharNum = adharNum;
		this.accountNum = accountNum;
		this.ifscNum = ifscNum;
		this.branch = branch;
		this.rollNum = rollNum;
		this.application_details = application_details;
	}

	public DocumentDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
