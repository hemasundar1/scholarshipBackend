package com.example.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.modelsDto.JwtRequest;
import com.example.project.modelsDto.JwtResponse;
import com.example.project.services.JwtService;



@CrossOrigin(origins = "http://localhost:4200")
@RestController


public class JwtController {

    @Autowired
    private JwtService jwtService;

    @PostMapping({"/authenticate"})
    public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {
    	System.out.println("Enytered");
        return jwtService.createJwtToken(jwtRequest);
    }
}
