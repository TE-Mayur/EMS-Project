package com.te.ems.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.ems.beans.UserBean;

@Repository
public interface UserDAO extends JpaRepository<UserBean, String> {

	public UserBean findByEmailAndPassword(String email, String password);
}
