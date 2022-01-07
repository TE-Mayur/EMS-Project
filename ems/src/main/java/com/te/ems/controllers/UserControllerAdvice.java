package com.te.ems.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.te.ems.beans.UserResponse;
import com.te.ems.customexceptions.CustomException;

@RestControllerAdvice
public class UserControllerAdvice {

	@ExceptionHandler(CustomException.class)
	public ResponseEntity<UserResponse> handleException(CustomException exception){
		UserResponse response = new UserResponse(true, exception.getMessage());
		return new ResponseEntity<UserResponse>(response , HttpStatus.NOT_FOUND);
		}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<UserResponse> methodInvalid(MethodArgumentNotValidException exp){
		UserResponse res = new UserResponse(true, exp.getFieldError().getDefaultMessage());
		return new ResponseEntity<UserResponse>(res,HttpStatus.NOT_FOUND);
	}
}
