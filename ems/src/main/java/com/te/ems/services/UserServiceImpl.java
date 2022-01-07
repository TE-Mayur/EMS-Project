package com.te.ems.services;

import javax.transaction.Transactional;

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

	@Override
	@Transactional
	public UserBean updateDetails(UserBean emp) {
		if (dao.existsById(emp.getEmail())) {

			UserBean emp1 = dao.findByEmail(emp.getEmail());

			if (emp1 != null) {
				if (emp.getAge() != null) {
					emp1.setAge(emp.getAge());
				}
				if (emp.getDesignation() != null && !emp.getDesignation().isEmpty()) {
					emp1.setDesignation(emp.getDesignation());
				}
				if (emp.getFull_name() != null && !emp.getFull_name().isEmpty()) {
					emp1.setFull_name(emp.getFull_name());
				}
				if (emp.getPassword() != null && !emp.getPassword().isEmpty()) {
					emp1.setPassword(emp.getPassword());
				}
				if (emp.getSalary() != null) {
					emp1.setSalary(emp.getSalary());
				}
				if (emp.getUser_name() != null && !emp.getUser_name().isEmpty()) {
					emp1.setUser_name(emp.getUser_name());
				}
				dao.save(emp1);
			}
			return emp1;
		} else {
			throw new CustomException("Data not found");
		}

	}

}
