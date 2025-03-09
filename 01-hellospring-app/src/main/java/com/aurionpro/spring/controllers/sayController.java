package com.aurionpro.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.spring.entity.Computer;

@RestController
@RequestMapping("/app")
public class sayController {
	
	@Autowired
	private Computer computer;
	
	@GetMapping("/sayhello")
	public String sayHello() {
		return "Hello to spring boot";
	}
	
	@GetMapping("/saybye")
	public String sayBye() {
		return "Bye bye to spring boot";
	}
	
	@GetMapping("/computers")
	public Computer computer() {
		return computer;
	}
}
