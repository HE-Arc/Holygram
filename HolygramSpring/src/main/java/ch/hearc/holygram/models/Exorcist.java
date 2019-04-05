package ch.hearc.holygram.models;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Exorcist {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min = 50, max = 255)
	private String description;

	@NotNull
	private String phoneNumber;

	@OneToOne(mappedBy = "exorcist")
	private User fk_user;

	@ManyToOne
	@JoinColumn
	private Canton canton;

	@OneToMany(mappedBy = "fk_exorcist", cascade = CascadeType.ALL)
	private Set<Evaluation> evaluations;

	@OneToMany(mappedBy = "fk_exorcist", cascade = CascadeType.ALL)
	private Set<Service> services;
	
	public Exorcist(User user, String description, String phoneNumber) {
		this.fk_user = user;
		this.description = description;
		this.phoneNumber = phoneNumber;
		this.evaluations = new HashSet<Evaluation>();
		this.services = new HashSet<Service>();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}
	/*
	 * Dirty method to get attributes of a user 3 Classes (Template, Business,
	 * Entity) for each Model should be used
	 */
	public Map<String, String> getAttributes() {
		Map<String, String> attributes = new HashMap<String, String>();

		attributes.put("id", id.toString());
		attributes.put("fk_user", fk_user.toString());
		attributes.put("description", description.toString());
		attributes.put("phoneNumber", phoneNumber.toString());
		attributes.put("canton", canton.toString());
		attributes.put("evaluations", evaluations.toString());
		attributes.put("services", services.toString());

		return attributes;
	}
}