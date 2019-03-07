package ch.hearc.holygram.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Service {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;

	@NotNull
	@Size(min = 3, max = 45)
	private String name;

	@NotNull
	private float price;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	private User principal;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	private Exorcist exorcist;

	public Service() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "TODO";
	}

}
