package com.te.ems.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class UserInfo implements Serializable{
	
	@Column
	private String name;
	
	@Column
	private String username;
	
	@Column
	@Id
	private String mail;
	
	@Column
	//@JsonIgnore
	private String password;
	
	@Column
	//@JsonIgnore
	private String reenterthepassword;
	
	

}