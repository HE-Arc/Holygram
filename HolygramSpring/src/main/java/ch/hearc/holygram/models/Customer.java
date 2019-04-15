package ch.hearc.holygram.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	@JoinColumn
	@JsonBackReference
	private User user;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	@JsonBackReference
	private Set<Evaluation> evaluations;

	public Customer(User user) {
		this();
		this.user = user;
	}

	public Customer() {
		this.evaluations = new HashSet<Evaluation>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public synchronized void setUser(User user) {
		this.user = user;
	}

	public Set<Evaluation> getEvaluations() {
		return evaluations;
	}

	public void setEvaluations(Set<Evaluation> evaluations) {
		this.evaluations = evaluations;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return id.hashCode();
	}
}
