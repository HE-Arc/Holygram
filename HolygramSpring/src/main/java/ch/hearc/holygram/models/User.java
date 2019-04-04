package ch.hearc.holygram.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
/**
 * Class representing a user
 * 
 * @author Seg
 *
 */
public class User {

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	protected Long id;

	@NotNull
	@Size(min = 2, max = 30)
	protected String name;

	@NotNull
	@Size(min = 2, max = 30)
	protected String password;

	@NotNull
	@Size(min = 5, max = 45)
	protected String email;

	@NotNull
	protected String avatar;

	public User() {
	}

	public User(String name, String password, String email, String avatar) {
		this.name = name;
		this.password = password;
		this.email = email;
		this.avatar = avatar;
	}

	@Override
	public String toString() {
		return "TODO";
	}

}
