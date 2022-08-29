package com.example.project.controller;


import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.project.services.ApplicationDetailsService;
import com.example.project.models.Application_details;
import com.example.project.models.DocumentDetails;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ApplicationDetailsController {
	
	@Autowired
	ApplicationDetailsService appSer;
	
	Application_details app=new Application_details();
	
	@GetMapping("/employee/requests")
	public List<Application_details> getAllRequests()
	{
		return (List<Application_details>)appSer.getAllRequests();
	}
	
	@GetMapping("/employee/requests/{id}")
	public Application_details getAppDetailsByID(@PathVariable Integer id){
		return appSer.getAppDetailsById(id);
	}
	
	@PutMapping("/employee/requestApprove/{id}")
	public void requestApprove(@PathVariable Integer id,@RequestBody Application_details appdetails)
	{
		appSer.requestApprove(id, appdetails);
	}
	
	@PutMapping("/employee/requestReject/{id}")
	public void requestReject(@PathVariable Integer id,@RequestBody Application_details appdetails)
	{
		appSer.requestReject(id, appdetails);
	}
	
	@PutMapping("/request/assign/{id}")
	public void assignedTo(@PathVariable Integer id,@RequestBody Application_details assign)
	{
		System.out.println("assigning part............"+" "+assign);
		appSer.assigned(id, assign);
	}
	
	@PutMapping("/request/student")
	public void updateApp(@RequestBody Application_details assign)
	{
		appSer.updateApp(assign);
	}
	
	
	@PutMapping("/appDetails")
	public String puttAppDet(@RequestBody Application_details appDet, @RequestParam(value="id" ,required= true) int id) {
		return appSer.putAppDetails(appDet, id);
	}
	
	@PostMapping("/appDetails")
	public int postAppDet(@RequestBody Application_details appDet) {
		return appSer.postAppDetails(appDet);
	}
	
	@DeleteMapping("/appDetails")
	public String deleteAppDet(@RequestParam(value="id", required = true) int id) {
		return appSer.deleteAppDetails(id);
	}
	
	@PostMapping("/uploadFile")
	public int uploadFile(@RequestParam("file") MultipartFile multipartFile,@RequestParam("firstName") String firstName,@RequestParam("lastName") String lastName,@RequestParam("postalAddress") String postalAddress,@RequestParam("collegeName") String collegeName,@RequestParam("state") String state,@RequestParam("className") String className, @RequestParam("studentId") int studentId) throws IOException{
		 return appSer.uploadFile(multipartFile, firstName,lastName,postalAddress,collegeName,state,className,studentId );
	  }
}
