package ch.hearc.holygram.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
/**
 * Class representing a religion
 */
public class Religion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(min = 3, max = 45)
	private String name;

	@OneToMany(mappedBy = "religion", cascade = CascadeType.ALL)
	@JsonManagedReference
	private Set<Demon> demons = new HashSet<Demon>();

	public Religion(String name) {
		this.name = name;
	}

	public Religion() {
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

	public Set<Demon> getDemons() {
		return demons;
	}

	public void setDemons(Set<Demon> demons) {
		this.demons = demons;
	}
}
