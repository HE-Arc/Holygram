package ch.hearc.holygram.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class User {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;

	@NotNull
	@Size(min = 2, max = 30)
	private String name;

	@NotNull
	@Size(min = 2, max = 30)
	private String password;

	@NotNull
	@Size(min = 5, max = 45)
	private String email;

	private String avatarPath;

	public User() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "TODO";
	}

}
