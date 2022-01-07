package com.te.ems.service;

import java.util.List;

import com.te.ems.beans.UserInfo;

public interface UserInterface {

	public UserInfo getData(String mail);

	public List<UserInfo> getAllData();

}
