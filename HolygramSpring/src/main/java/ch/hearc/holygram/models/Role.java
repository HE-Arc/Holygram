package ch.hearc.holygram.models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
/**
 * Class representing role
 * @author fabmo
 *
 */
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@ManyToMany(mappedBy = "customers")
	private Set<Customer> customers;
	
	@ManyToMany(mappedBy = "exorcists")
	private Set<Exorcist> exorcists;

	@ManyToMany
	private Set<Privilege> privileges;
	
	public Role(String string) {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}

	public Set<Privilege> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(Set<Privilege> privileges) {
		this.privileges = privileges;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Exorcist> getExorcists() {
		return exorcists;
	}

	public void setExorcists(Set<Exorcist> exorcists) {
		this.exorcists = exorcists;
	}
}
