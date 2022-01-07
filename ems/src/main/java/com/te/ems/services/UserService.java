package com.te.ems.services;

import java.util.List;

import com.te.ems.beans.UserBean;

public interface UserService {

	public boolean login(String email, String password);
	
	public UserBean getUserBean(String email);

	public UserBean addUser(UserBean bean);
	
	public UserBean updateDetail(UserBean emp);

	public boolean register(UserBean user);
	
	public List<UserBean> getAllData();
}
