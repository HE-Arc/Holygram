package ch.hearc.holygram.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Evaluation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn
	private Customer fk_customer;

	@ManyToOne
	@JoinColumn
	private Exorcist fk_exorcist;

	@NotNull
	private boolean isPositive;

	@NotNull
	private Date datetime;
	
	@NotNull
	@Size(min = 50, max = 255)
	private String text;
	
	public Evaluation(Customer customer, Exorcist exorcist, boolean isPositive, String text)
	{
		this.fk_customer = customer;
		this.fk_exorcist = exorcist;
		this.isPositive = isPositive;
		this.text = text;
	}

}
