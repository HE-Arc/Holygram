package ch.hearc.holygram.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
/**
 * Class representing an exorcist
 *
 */
public class Exorcist extends User {

	@NotNull
	private String description;

	@NotNull
	private String phoneNumber;

	@ManyToOne(fetch = FetchType.LAZY)
	private Canton canton;

	public Exorcist() {

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

	public Exorcist(String name, String password, String email, String avatar, String description, String phoneNumber,
			Canton canton) {
		super(name, password, email, avatar);
		this.description = description;
		this.phoneNumber = phoneNumber;
		this.canton = canton;
	}


	@Override
	public String toString() {
		return id + " " + name + " " + email;
	}

}
