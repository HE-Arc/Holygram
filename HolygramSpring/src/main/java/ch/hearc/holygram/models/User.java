package ch.hearc.holygram.models;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(unique = true)
	private Customer customer;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(unique = true)
	private Exorcist exorcist;

	public User(String username, String password, String email) throws Exception {
		if (validateUsername(username) && validatePassword(password) && validateEmail(email)) {
			this.username = username;
			this.password = password;
			this.email = email;
		} else
			throw new Exception("Invalid arguments provided !");
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
		return false; // TODO
	}

	private boolean validatePassword(String password) {
		return false; // TODO
	}

	private boolean validateEmail(String email) {
		return false; // TODO
	}
}
