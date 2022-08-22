package com.example.project.models;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.annotation.JsonIgnore;



@CrossOrigin(origins = "http://localhost:4200")

@Entity

public class Application_details {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int appId;
	private String image;
	private String firstName;
	private String lastName;
	private String postalAddress;
	private String collegeName;
	private String state;
	private String className;
	private String url;
	
	@Lob
	private byte[] document;
	
	
	
	@OneToOne(mappedBy= "application_details" , fetch = FetchType.LAZY , orphanRemoval = true)
	@JsonIgnore
	private DocumentDetails documentDetails;
	
	
	
	@OneToOne(fetch= FetchType.LAZY, optional = false)
	@JsonIgnore
	@JoinColumn(name="studentId", referencedColumnName = "userId", nullable= false)
	private UserModel userModel;
	
	
	
	public Application_details(int appId) {
		this.appId = appId;
	}

	public int getAppId() {
		return appId;
	}

	public void setAppId(int appId) {
		this.appId = appId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPostalAddress() {
		return postalAddress;
	}

	public void setPostalAddress(String postalAddress) {
		this.postalAddress = postalAddress;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public DocumentDetails getDocumentDetails() {
		return documentDetails;
	}

	public void setDocumentDetails(DocumentDetails documentDetails) {
		this.documentDetails = documentDetails;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public byte[] getDocument() {
		return document;
	}

	public void setDocument(byte[] document) {
		this.document = document;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Application_details( String image, String firstName, String lastName, String postalAddress,
			String collegeName, String state, String className,  String url,
			byte[] document) {
		super();
		
		this.image = image;
		this.firstName = firstName;
		this.lastName = lastName;
		this.postalAddress = postalAddress;
		this.collegeName = collegeName;
		this.state = state;
		this.className = className;
		this.url = url;
		this.document = document;
		
	}

	public Application_details() {
		super();
		// TODO Auto-generated constructor stub
	}




	
}
