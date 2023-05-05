package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.PersonNew;
import com.example.demo.repository.PersonRepository;

@Service
public class AddressPersonService {
	@Autowired
	PersonRepository perRepository;
	public List<PersonNew>fetchAllPersons()
	   {
		   return perRepository.findAll();
	   }
    public PersonNew savePersons(PersonNew p)
	   {
		   return perRepository.save(p);
	   }
}

