package com.example.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FirstProjectController {
	
	@ResponseBody
	@RequestMapping(value="/",method=RequestMethod.GET)
public String Welcome()
{
	return "Welcome";
}
}