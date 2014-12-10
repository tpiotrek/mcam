package pl.mcam.web.utils;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.security.authentication.dao.ReflectionSaltSource;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

import pl.mcam.web.domain.User;
import pl.mcam.web.domain.UserStatus;
import pl.mcam.web.validators.IPasswordCorfirmation;

/**
 * 
 * @author Tokarz Piotr
 *
 */
public class Registration implements IPasswordCorfirmation {
	
	public void setFname(String fname) {
		this.fname = fname;
	}
	
	public String getFname() {
		return this.fname;
	}
	
	public void setLname(String lname) {
		this.lname = lname;
	}
	
	public String getLname() {
		return this.lname;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setVemail(String email) {
		this.vemail = email;
	}
	
	public String getVemail() {
		return this.vemail;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setVpassword(String password) {
		this.vpassword = password;
	}
	
	public String getVpassword() {
		return this.vpassword;
	}
	
	public User populate() {	
		Md5PasswordEncoder encoder = new Md5PasswordEncoder();
		User user = new User();
		user.setFname(this.fname);
		user.setLname(this.lname);	
		user.setEmail(this.email);
		user.setPassword(encoder.encodePassword(this.password,null));
		user.setStatus(UserStatus.NEW);
		return user;
	}
	
	@NotNull
	@Size(min=3, max=45)
	private String fname;
	
	@NotNull
	@Size(min=3, max=45)
	private String lname;
	
	@NotNull
	@Email
	@Size(min=4, max=45)
	private String email;
	
	@NotNull
	@Email
	@Size(max=45)
	private String vemail;
	
	@NotNull
	@Size(min=6, max=45)
	private String password;
	
	@NotNull
	@Size(min=6, max=45)
	private String vpassword;
}
