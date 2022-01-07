package com.te.ems.services;

import java.util.List;

import com.te.ems.beans.UserBean;

public interface UserService {

<<<<<<< HEAD
	public boolean login(String email, String password);
	
	public UserBean getUserBean(String email);

	public UserBean addUser(UserBean bean);
	
	public UserBean updateDetail(UserBean emp);

	public boolean register(UserBean user);
	
	public List<UserBean> getAllData();
=======
	public UserBean login(String email, String password);

	public UserBean updateDetails(UserBean emp);
>>>>>>> 706f3224ce7c357d1c529a30d85e078822726a61
}
