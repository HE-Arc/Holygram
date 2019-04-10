package ch.hearc.holygram.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
/**
 * Class representing a demon
 */
public class Demon {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn
	private Religion fk_religion;

	@NotNull
	private String name;

	public Demon(String name, Religion fk_religion) {
		this.name = name;
		this.fk_religion = fk_religion;
	}
	
	public Demon() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Religion getFk_religion() {
		return fk_religion;
	}

	public void setFk_religion(Religion fk_religion) {
		this.fk_religion = fk_religion;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
