package ch.hearc.holygram.models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
/**
 * Class representing a user
 * 
 * @author Seg
 *
 */
public class Customer {

	@GeneratedValue(strategy = GenerationType.AUTO)
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

	private String avatar;

	@ManyToMany
	private Set<Role> roles;
	
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Customer() {
	}

	public Customer(String name, String password, String email, String avatar) {
		this.name = name;
		this.password = password;
		this.email = email;
		this.avatar = avatar;
	}
	
	public Customer(String name, String password, String email) {
		this.name = name;
		this.password = password;
		this.email = email;
		this.avatar = "";
	}


	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", avatar="
				+ avatar + "]";
	}

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

}
