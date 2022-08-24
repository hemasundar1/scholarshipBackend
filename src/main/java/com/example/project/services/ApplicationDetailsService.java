package com.example.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.util.Optional;


import com.example.project.models.Application_details;
import com.example.project.models.UserModel;
import com.example.project.repository.ApplicationDetailsRepository;

@Service
public class ApplicationDetailsService {

	@Autowired
	ApplicationDetailsRepository appRepo;

	public Optional<Application_details> getAppDetails(int id) {
		return appRepo.findById(null);
	}
	
	public int postAppDetails(Application_details app) {
		
		if(appRepo.save(app)!=null) {
			return app.getAppId() ;
		}
		else {
			return 0;
		}
	}
	
	public String putAppDetails(Application_details app, int id) {
		Optional<Application_details> result = appRepo.findById(id);
		Application_details appDetails = result.get();
		appDetails.setClassName(app.getClassName());
		appDetails.setCollegeName(app.getCollegeName());
		appDetails.setFirstName(app.getFirstName());
		appDetails.setLastName(app.getLastName());
		
		appDetails.setPostalAddress(app.getPostalAddress());
		appDetails.setState(app.getState());
		
		
		
		if(appRepo.save(appDetails) !=null) {
			
			 return "Successfully updated";
		}
		else {
			return "Not updated successfully";
		}
	}
	
	public String deleteAppDetails(int id) {
		
		try {
			appRepo.deleteById(id);
			return "Deleted Successfully";
			
		}
		catch(Exception e) {
			return "Not Deleted";
		}
		
	}
	
	public int uploadFile(MultipartFile multipartFile, String firstName,String lastName,String postalAddress,String collegeName, String state, String className,int studentId) throws IOException {
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());

		String url = ServletUriComponentsBuilder.fromCurrentContextPath()
				.path("/downloadFromDB")
				.path(fileName)
				.toUriString();
		
		Application_details appDetails = new Application_details(fileName, firstName, lastName, postalAddress, collegeName, state,className, url,multipartFile.getBytes());
		appDetails.setUserModel(new UserModel(studentId));
		appRepo.save(appDetails);
		
		String contentType = multipartFile.getContentType();

		return appDetails.getAppId();
	}
	


}
