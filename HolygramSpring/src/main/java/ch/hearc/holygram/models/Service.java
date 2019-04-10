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
 * Class representing a service provided by an exorcist
 */
public class Service {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn
	private Exorcist fk_exorcist;

	@ManyToOne
	@JoinColumn
	private Demon fk_demon;

	@NotNull
	private float price;

	public Service(Exorcist exorcist, Demon demon, float price) {
		this.fk_exorcist = exorcist;
		this.fk_demon = demon;
		this.price = price;
	}
}
