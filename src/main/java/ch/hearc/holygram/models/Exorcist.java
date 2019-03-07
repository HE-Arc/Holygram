package ch.hearc.holygram.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
/**
 * Class representing an exorcist
 * @author Seg
 *
 */
public class Exorcist extends User {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;

	@NotNull
	private String description;

	@NotNull
	private String phoneNumber;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	private Canton canton;

	public Exorcist() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "TODO";
	}

}
