package ch.hearc.holygram.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
/**
 * Class representing a swiss canton
 */
public class Canton {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(min = 3, max = 45)
	private String name;

	@NotNull
	@Size(min = 2, max = 2)
	private String acronym;

	@OneToMany(mappedBy = "canton", cascade = CascadeType.ALL)
	@JsonBackReference
	private Set<Exorcist> exorcists;

	/**
	 * Constructor of class "Canton"
	 * 
	 * @param acronym
	 * @param name
	 */
	public Canton(String acronym, String name) {
		this.acronym = acronym;
		this.name = name;
	}

	/**
	 * Constructor of class "Canton"
	 */
	public Canton() {
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

	public String getAcronym() {
		return acronym;
	}

	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}

	public Set<Exorcist> getExorcists() {
		return exorcists;
	}

	public void setExorcists(Set<Exorcist> exorcists) {
		this.exorcists = exorcists;
	}
}
