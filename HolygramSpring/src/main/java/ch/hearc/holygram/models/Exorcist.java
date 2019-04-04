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

	public Exorcist() {

	}

	public Exorcist(String name, String password, String email, String avatar, String description, String phoneNumber,
			Canton canton) {
		super(name, password, email, avatar);
		this.description = description;
		this.phoneNumber = phoneNumber;
		this.canton = canton;
	}
	
	public Exorcist(String name, String password, String email, String description, String phoneNumber, Canton canton) {
		super(name, password, email);
		this.description = description;
		this.phoneNumber = phoneNumber;
		this.canton = canton;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Canton getCanton() {
		return canton;
	}

	public void setCanton(Canton canton) {
		this.canton = canton;
	}

	@Override
	public String toString() {
		return id + " " + this.getName() + " " + this.getEmail();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
