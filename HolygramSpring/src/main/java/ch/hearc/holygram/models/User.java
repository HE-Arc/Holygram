package ch.hearc.holygram.models;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(min = 2, max = 30)
	private String username;

	@NotNull
	@Size(min = 2, max = 30)
	private String email;

	@NotNull
	@Size(min = 2, max = 30)
	private String password;

	@ManyToOne
	@JoinColumn
	private Role role;

	public User(String username, String password, String email, Role role) throws Exception {
		if (validateUsername(username) && validatePassword(password) && validateEmail(email)) {
			this.username = username;
			this.password = password;
			this.email = email;
			this.role = role;
		} else
			throw new Exception("Invalid arguments provided !");
	}

	public User() {
	}

	/*
	 * Dirty method to get attributes of a user 3 Classes (Template, Business,
	 * Entity) for each Model should be used
	 */
	public Map<String, String> getAttributes() {
		Map<String, String> attributes = new HashMap<String, String>();

		attributes.put("id", id.toString());
		attributes.put("username", username.toString());
		attributes.put("email", email.toString());

		return attributes;
	}

	private boolean validateUsername(String username) {
		return true; // TODO
	}

	private boolean validatePassword(String password) {
		return true; // TODO
	}

	private boolean validateEmail(String email) {
		return true; // TODO
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
