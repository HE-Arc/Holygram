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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToMany(mappedBy = "fk_customer", cascade = CascadeType.ALL)
	private Set<Evaluation> evaluations;

	public Customer() {
		this.evaluations = new HashSet<Evaluation>();
	}

	/*
	 * Dirty method to get attributes of a user 3 Classes (Template, Business,
	 * Entity) for each Model should be used
	 */
	public Map<String, String> getAttributes() {
		Map<String, String> attributes = new HashMap<String, String>();

		attributes.put("id", id.toString());
		attributes.put("evaluations", evaluations.toString());

		return attributes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Evaluation> getEvaluations() {
		return evaluations;
	}

	public void setEvaluations(Set<Evaluation> evaluations) {
		this.evaluations = evaluations;
	}
}
