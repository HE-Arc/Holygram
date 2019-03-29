package ch.hearc.holygram.models;

import java.util.Map;

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
public class Exorcist extends Customer {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotNull
	private String description;

	@NotNull
	private String phoneNumber;

	@ManyToOne(fetch = FetchType.LAZY)
	private Canton canton;

	public Exorcist(String name, String password, String email, String avatar, String description, String phoneNumber, Canton canton) {
		super(name, password, email, avatar);
		this.description = description;
		this.phoneNumber = phoneNumber;
		this.canton = canton;
	}

	@Override
	public String toString() {
		return "TODO";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
