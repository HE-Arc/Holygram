package ch.hearc.holygram.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
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

	public Long getId() {
		return id;
	}

	public Religion getReligion() {
		return religion;
	}

	public String getName() {
		return name;
	}

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	private Religion religion;

	@NotNull
	private String name;

	public Demon(String name, Religion religion) {
		this.name = name;
		this.religion = religion;
	}
	
	public Demon()
	{
		
	}

	@Override
	public String toString() {
		return "TODO";
	}

}
