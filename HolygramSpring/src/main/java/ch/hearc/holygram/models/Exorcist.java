package ch.hearc.holygram.models;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
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
	@Size(min = 1, max = 1000)
	private String description;

	@NotNull
	private String phoneNumber;

	@ManyToOne
	@JoinColumn
	private Canton canton;

	@OneToMany(mappedBy = "exorcist", cascade = CascadeType.ALL)
	private Set<Evaluation> evaluations;

	@OneToMany(mappedBy = "exorcist", cascade = CascadeType.ALL)
	private List<Service> services;

	public Exorcist(String description, String phoneNumber, Canton canton) {
		this.description = description;
		this.phoneNumber = phoneNumber;
		this.canton = canton;
		this.evaluations = new HashSet<Evaluation>();
		this.services = new ArrayList<Service>();
	}

	public Exorcist() {}

	/*
	 * Dirty method to get attributes of a user 3 Classes (Template, Business,
	 * Entity) for each Model should be used
	 */
	public Map<String, String> getAttributes() {
		Map<String, String> attributes = new HashMap<String, String>();

		attributes.put("id", id.toString());
		attributes.put("description", description.toString());
		attributes.put("phoneNumber", phoneNumber.toString());
		attributes.put("canton", canton.toString());
		attributes.put("evaluations", evaluations.toString());
		attributes.put("services", services.toString());

		return attributes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Canton getCanton() {
		return canton;
	}

	public void setCanton(Canton canton) {
		this.canton = canton;
	}

	public Set<Evaluation> getEvaluations() {
		return evaluations;
	}

	public void setEvaluations(Set<Evaluation> evaluations) {
		this.evaluations = evaluations;
	}

	public List<Service> getServices() {
		Collections.sort(services, (s1, s2) -> {
			return Float.compare(s1.getPrice(), s2.getPrice());
		});
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}
}
