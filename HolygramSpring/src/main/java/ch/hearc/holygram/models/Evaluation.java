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
	private Customer customer;

	@ManyToOne
	@JoinColumn
	private Exorcist exorcist;

	@NotNull
	private boolean isPositive;

	@NotNull
	private Date datetime;

	@NotNull
	private String text;

	public Evaluation(Customer customer, Exorcist exorcist, boolean isPositive, String text)
	{
		this.datetime = new Date();
		this.customer = customer;
		this.exorcist = exorcist;
		this.isPositive = isPositive;
		this.text = text;
	}

	public Evaluation() {
		this.datetime = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Exorcist getExorcist() {
		return exorcist;
	}

	public void setExorcist(Exorcist exorcist) {
		this.exorcist = exorcist;
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
