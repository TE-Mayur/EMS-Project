package com.te.ems.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.ems.beans.UserBean;
import com.te.ems.customexceptions.CustomException;
import com.te.ems.dao.UserDAO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO dao;

	@Override
	public UserBean login(String email, String password) {
		if ((!email.isEmpty() && email != null) && (!password.isEmpty() && password != null)) {
			UserBean log = dao.findByEmailAndPassword(email, password);
			if (log != null) {
				return log;
			} else {
				throw new CustomException("Invalid Credentials");
			}
		} else {
			throw new CustomException("Enter valid Login Details");

		}
	}
}
