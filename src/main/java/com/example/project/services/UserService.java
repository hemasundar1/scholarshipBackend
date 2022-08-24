package com.example.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.example.project.models.UserModel;
import com.example.project.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public List<UserModel> getAllUser(){
		return userRepo.findAll();
	}

	public Optional<UserModel> getUser(int id){
		return userRepo.findById(id);
	}
	
//	public String saveUser(UserModel userModel) {
//		String response;
//		
//		if (userRepo.save(userModel) != null)
//			response = "Successfully inserted";
//		else
//			response = "Not inserted , Please try again";
//		return response;
//		
//	}

	public String editUser(UserModel userModel, int id) {
		
		Optional<UserModel> user = userRepo.findById(id);
		UserModel result =  user.get();
		result.setEmail(userModel.getEmail());
		result.setMobileNumber(userModel.getMobileNumber());
		result.setPassword(getEncodedPassword(userModel.getPassword()));
		result.setConfirmPassword(getEncodedPassword(userModel.getConfirmPassword()));
		result.setUserName(userModel.getUserName());

		if(userRepo.save(result)!=null) {
			 return "Successfully updated";
		}
		else {
			return "Not Updated, Please try again";
		}
		
	}
	
	public String deleteUser(int id) {
		
		try {
			userRepo.deleteById(id);
			return "Successfully Deleted";
		}
		catch(Exception e) {
			return "Not deleted , Please try again";
		
		}
		
	}
	
	public String getEncodedPassword(String password) {
		return passwordEncoder.encode(password);
	}
	
}
