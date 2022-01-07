package com.te.ems.beans;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
@Entity
@Table(name = "user_emp")
public class UserBean implements Serializable {
<<<<<<< HEAD
	
	
	
	@NotNull(message = "Id can not be null")
	private Integer id;
=======

	private static final long serialVersionUID = 1L;
>>>>>>> 706f3224ce7c357d1c529a30d85e078822726a61

	@Id
	@NotEmpty(message = "email should not be empty")
	@Pattern(regexp = "^[a-zA-Z0-9+_]+@[a-zA-Z.]+$", message = "enter a crt format name@gamil.com")
	private String email;
     
	@NotEmpty(message = "password not empty")
	@Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,})",message = "enter the crt format")
	private String password;

	@NotEmpty(message = "username should not be empty")
<<<<<<< HEAD
	private String username;

	@NotEmpty(message = "fullname should not be empty")
	private String fullname;

=======
	private String user_name;

	@NotEmpty(message = "fullname should not be empty")
	private String full_name;

>>>>>>> 706f3224ce7c357d1c529a30d85e078822726a61
	@NotEmpty(message = "desgination should not be empty")
	private String designation;

	@NotNull(message = "salary should not be null")
	private Double salary;

	@Min(value = 18, message = "age should not be less than 18")
<<<<<<< HEAD
	@Max(value = 60, message = "age should not be greater than 100")
=======
	@Max(value = 100, message = "age should not be greater than 100")
>>>>>>> 706f3224ce7c357d1c529a30d85e078822726a61
	private Integer age;

}
