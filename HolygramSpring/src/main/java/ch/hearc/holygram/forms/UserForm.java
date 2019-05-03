package ch.hearc.holygram.forms;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import ch.hearc.holygram.models.Canton;

public class UserForm {

	@NotBlank
	@Size(min=6)
	private String username;
	
	@NotBlank
	@Email
	private String email;
	
	@NotBlank
	@Size(min=8,max=32)
	private String password;
	
	@NotBlank
	@Size(min=8,max=32)
	private String passwordConfirm;
	
	private String cantonAcronym;
	
	private String phoneNumber;
	
	private String description;

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

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public String getCantonAcronym() {
		return cantonAcronym;
	}

	public void setCantonAcronym(String cantonAcronym) {
		this.cantonAcronym = cantonAcronym;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
