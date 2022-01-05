package com.te.ems.beans;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "user_emp")
public class UserBean implements Serializable {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String fullname;

	@Id
	private String email;

	private String password;

	private Double salary;

	private String designation;

	private Integer age;

}
