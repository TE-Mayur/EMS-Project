package com.te.ems.services;

import com.te.ems.beans.UserBean;

public interface UserService {

	public UserBean login(String email, String password);

	public UserBean updateDetails(UserBean emp);
}
