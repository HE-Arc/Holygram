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
	
	public Evaluation() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Customer getFk_customer() {
		return fk_customer;
	}

	public void setFk_customer(Customer fk_customer) {
		this.fk_customer = fk_customer;
	}

	public Exorcist getFk_exorcist() {
		return fk_exorcist;
	}

	public void setFk_exorcist(Exorcist fk_exorcist) {
		this.fk_exorcist = fk_exorcist;
	}

	public boolean isPositive() {
		return isPositive;
	}

	public void setPositive(boolean isPositive) {
		this.isPositive = isPositive;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
