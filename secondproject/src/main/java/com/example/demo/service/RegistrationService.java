package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.model.Registration;

import com.example.demo.repository.RegistrationRepository;

@Service
public class RegistrationService {
	
	@Autowired
	RegistrationRepository regRepo;


	public Registration saveDetails(Registration u) {
		// TODO Auto-generated method stub
		return regRepo.save(u);
	}

	} 
	
	

