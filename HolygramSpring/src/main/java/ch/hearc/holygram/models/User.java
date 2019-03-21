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
