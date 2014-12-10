package pl.mcam.web.utils;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

/**
 * 
 * @author Tokarz Piotr
 *
 */
public class Login {
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public void sePassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	@NotNull
	@Email
	@Size(min=6, max=45)
	private String username;
	
	@NotNull
	@Size(min=4, max=45)
	private String password;
}
