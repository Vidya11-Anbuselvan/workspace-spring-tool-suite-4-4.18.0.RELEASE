package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Registration;
import com.example.demo.service.RegistrationService;



@RestController
public class RegistrationController {

	@Autowired
	RegistrationService regService;
	
	
	//http://localhost:8080/addname
	@PostMapping("/addname")
	public Registration saveDetails(@RequestBody Registration u)
	{
	return regService.saveDetails(u);
	}
}