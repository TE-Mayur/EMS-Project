package com.te.ems.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.ems.beans.UserBean;
import com.te.ems.beans.UserResponse;
import com.te.ems.customexceptions.CustomException;
import com.te.ems.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping(path = "/signin")
	public ResponseEntity<UserResponse> signIn(@RequestBody UserBean bean) {
		if (service.login(bean.getEmail(), bean.getPassword())) {
			UserResponse employeeResponse = new UserResponse(false, "Login successfull");
			return new  ResponseEntity<UserResponse>(employeeResponse,HttpStatus.OK);
		}
		throw new CustomException("Please Login First!!!!!..........");
	}

	@GetMapping(path = "/get/{email}")
	public ResponseEntity<UserResponse> getUser(@PathVariable String email) {
		UserResponse response = new UserResponse(false, service.getUserBean(email));
		return new ResponseEntity<UserResponse>(response, HttpStatus.OK);
	}

	@PostMapping(path = "/add")
	public ResponseEntity<UserResponse> addUser(@Valid @RequestBody UserBean bean) {
		UserResponse response = new UserResponse(false, service.addUser(bean));
		return new ResponseEntity<UserResponse>(response, HttpStatus.OK);
	}

	@PutMapping(path = "/update")
	public ResponseEntity<UserResponse> update(@Valid @RequestBody UserBean emp) {
		UserResponse response = new UserResponse(false, service.updateDetail(emp));
		return new ResponseEntity<UserResponse>(response, HttpStatus.OK);
	}
	
	@PostMapping(path = "/update")
	public ResponseEntity<UserResponse> update(@Valid @RequestBody UserBean emp) {
		UserResponse response = new UserResponse(false, service.updateDetails(emp));
		return new ResponseEntity<UserResponse>(response, HttpStatus.OK);
	}

	@PostMapping("/register")
	public ResponseEntity<UserResponse> registration(@Valid @RequestBody UserBean user) {
			UserResponse response = new UserResponse(false,service.register(user));
			return new ResponseEntity<UserResponse>(response, HttpStatus.OK);
		}
	
	@GetMapping("/getall")
	public ResponseEntity<UserResponse> getAllUser(){
		UserResponse response = new UserResponse(false, service.getAllData());
		return new ResponseEntity<UserResponse>(response, HttpStatus.OK);
	}
}
