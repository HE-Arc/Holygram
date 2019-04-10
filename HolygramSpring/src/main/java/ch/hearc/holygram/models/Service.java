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
	
	public Service() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Exorcist getFk_exorcist() {
		return fk_exorcist;
	}

	public void setFk_exorcist(Exorcist fk_exorcist) {
		this.fk_exorcist = fk_exorcist;
	}

	public Demon getFk_demon() {
		return fk_demon;
	}

	public void setFk_demon(Demon fk_demon) {
		this.fk_demon = fk_demon;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
}
