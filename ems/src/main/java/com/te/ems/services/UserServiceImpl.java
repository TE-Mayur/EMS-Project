package com.te.ems.services;

<<<<<<< HEAD
import java.util.List;
=======
import javax.transaction.Transactional;
>>>>>>> 706f3224ce7c357d1c529a30d85e078822726a61

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
	public boolean login(String email, String password) {
		if (dao.existsById(email)) {
			if (dao.getById(email).getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public UserBean getUserBean(String email) {
		UserBean bean = dao.findByEmail(email);
		return bean;
	}

	@Override
	public UserBean addUser(UserBean bean) {
		if (bean != null) {
			return dao.save(bean);
		}
		throw new CustomException("Data Already Exsits");
	}

	@Override
	public UserBean updateDetail(UserBean emp) {
		if (dao.existsById(emp.getEmail())) {

			UserBean emp1 = dao.findByEmail(emp.getEmail());

			if (emp1 != null) {
				if (emp.getAge() != null) {
					emp1.setAge(emp.getAge());
				}
				if (emp.getDesignation() != null && !emp.getDesignation().isEmpty()) {
					emp1.setDesignation(emp.getDesignation());
				}
				if (emp.getFullname() != null && !emp.getFullname().isEmpty()) {
					emp1.setFullname(emp.getFullname());
				}
				if (emp.getPassword() != null && !emp.getPassword().isEmpty()) {
					emp1.setPassword(emp.getPassword());
				}
				if (emp.getSalary() != null) {
					emp1.setSalary(emp.getSalary());
				}
				if (emp.getUsername() != null && !emp.getUsername().isEmpty()) {
					emp1.setUsername(emp.getUsername());
				}
				dao.save(emp1);
			}
			return emp1;
		} else {
			throw new CustomException("Data not found");
		}

	}

	@Override
	public boolean register(UserBean user) {
		if (user != null) {
			dao.save(user);
		}
		throw new CustomException("Registration Failed");
	}

	@Override
	public List<UserBean> getAllData() {
		return dao.findAll();
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
