package com.te.ems.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.ems.beans.UserBean;
import com.te.ems.beans.UserResponse;
import com.te.ems.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@PostMapping(path = "/signin")
	public ResponseEntity<UserResponse> signIn(@RequestBody UserBean bean){
		UserResponse response = new UserResponse(false, service.login(bean.getEmail(), bean.getPassword()));
		return new ResponseEntity<UserResponse>(response, HttpStatus.OK);
	}
	
	@PostMapping(path = "/update")
	public ResponseEntity<UserResponse> update(@Valid @RequestBody UserBean emp) {
		UserResponse response = new UserResponse(false, service.updateDetails(emp));
		return new ResponseEntity<UserResponse>(response, HttpStatus.OK);
	}

}
