package ch.hearc.holygram.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Demon {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	private Religion religion;

	@NotNull
	private String name;

	public Demon() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "TODO";
	}

}
