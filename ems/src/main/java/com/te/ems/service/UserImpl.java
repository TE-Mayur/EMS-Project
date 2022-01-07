package com.te.ems.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.ems.beans.UserInfo;
import com.te.ems.dao.UserDao;
import com.te.ems.exception.UserException;

@Service
public class UserImpl implements UserInterface {

	@Autowired(required = false)
	private UserDao dao;

	@Override
	public UserInfo getData(String mail) {

		if (mail != null && !mail.isEmpty()) {
			Optional<UserInfo> optional = dao.findById(mail);
			return optional.get();
		}
		throw new UserException("User Not Exsist");
	}

	@Override
	public List<UserInfo> getAllData() {
		return dao.findAll();
	}
}
