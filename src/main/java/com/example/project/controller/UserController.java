package com.example.project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.models.UserModel;
import com.example.project.services.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/Users")
	public List<UserModel> getAllUser(){
		return userService.getAllUser();
	}
	
	@GetMapping("/User")
	public Optional<UserModel> getUser(@RequestParam(value="id" ,required=true) int id){
		return userService.getUser(id);
	}
	
	@PostMapping("/User")
	public String saveUser(@RequestBody UserModel userModel) {
		return userService.saveUser(userModel);
	}
	
	@PutMapping("/User")
	public String editUser(@RequestBody UserModel userModel, @RequestParam(value="id" ,required=true) int id) {
		return userService.editUser(userModel,id);
	}
	
	@DeleteMapping("/User")
	public String deleteUser(@RequestParam(value="id" , required=true) int id) {
		return userService.deleteUser(id);
	}
	
}
