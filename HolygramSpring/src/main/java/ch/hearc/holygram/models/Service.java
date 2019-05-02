package ch.hearc.holygram.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * Class representing a service provided by an exorcist
 */
@Entity
public class Service {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn
	@JsonBackReference
	private Exorcist exorcist;

	@ManyToOne
	@JoinColumn
	@JsonBackReference
	private Demon demon;

	@NotNull
	private float price;

	public Service(Exorcist exorcist, Demon demon, float price) {
		this.exorcist = exorcist;
		this.demon = demon;
		this.price = price;
	}

	public Service() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Exorcist getExorcist() {
		return exorcist;
	}

	public void setExorcist(Exorcist exorcist) {
		this.exorcist = exorcist;
	}

	public Demon getDemon() {
		return demon;
	}

	public void setDemon(Demon demon) {
		this.demon = demon;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
}
