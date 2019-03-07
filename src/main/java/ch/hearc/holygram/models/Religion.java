package ch.hearc.holygram.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Religion {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;

	@NotNull
	@Size(min = 3, max = 45)
	private String name;

	public Religion() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "TODO";
	}

}