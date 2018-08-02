/**
 * 
 */
package com.oooffers.web.model;

/**
 * @author Zrieq
 *
 */
public class UserRegisterForm {
	
	private String username;
	
	private String email;
	
	private String password;
	
	private String confirmPassword;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@Override
	public String toString() {
		return "username=[" + username +"], email=[" + email + "], password=[" + password + "], confirmPassword=[" + confirmPassword + "].";
	}
}
