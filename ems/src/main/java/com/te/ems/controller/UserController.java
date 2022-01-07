package com.te.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.te.ems.beans.UserResponse;
import com.te.ems.service.UserInterface;

@RestController
public class UserController {
	
	@Autowired(required = false)
	private UserInterface interface1;
	
	@GetMapping("/getData")
	public ResponseEntity<UserResponse> getData(@PathVariable String mail){
		UserResponse response = new UserResponse(false, interface1.getData(mail));
		return new ResponseEntity<UserResponse>(response, HttpStatus.OK);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<UserResponse> getAllUser(){
		UserResponse response = new UserResponse(false, interface1.getAllData());
		return new ResponseEntity<UserResponse>(response, HttpStatus.OK);
	}
	

}
