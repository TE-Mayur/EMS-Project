package com.te.ems.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.te.ems.beans.UserResponse;
import com.te.ems.exception.UserException;

@RestControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(UserException.class)
	public ResponseEntity<UserResponse> handler(UserException exception) {
		UserResponse response  = new UserResponse(true, exception.getMessage());
		return new ResponseEntity<UserResponse>(response,HttpStatus.NOT_FOUND);
	}

}
