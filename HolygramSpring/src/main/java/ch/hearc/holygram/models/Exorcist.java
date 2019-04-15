package ch.hearc.holygram.models;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/*
 * Dirty method to get attributes of a user 3 Classes (Template, Business,
 * Entity) for each Model should be used
 */
@Entity
public class Exorcist {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @OneToOne
    @JoinColumn
    private User user;

    @NotNull
    @Size(min = 1, max = 1000)
    private String description;

    @NotNull
    private String phoneNumber;

    @ManyToOne
    @JoinColumn
    private Canton canton;

    @OneToMany(mappedBy = "exorcist", cascade = CascadeType.ALL)
    private List<Evaluation> evaluations;

    @OneToMany(mappedBy = "exorcist", cascade = CascadeType.ALL)
    private List<Service> services;

    public Exorcist(User user, String description, String phoneNumber, Canton canton) {
    	this.user = user;
        this.description = description;
        this.phoneNumber = phoneNumber;
        this.canton = canton;
        this.evaluations = new ArrayList<Evaluation>();
        this.services = new ArrayList<Service>();
    }

    public Exorcist() {
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

    public List<Evaluation> getEvaluations() {
        Collections.sort(evaluations, (o1, o2) -> -o1.getDatetime().compareTo(o2.getDatetime()));
        return evaluations;
    }

    public void setEvaluations(List<Evaluation> evaluations) {
        this.evaluations = evaluations;
    }

    public List<Service> getServices() {
        Collections.sort(services, (s1, s2) -> Float.compare(s1.getPrice(), s2.getPrice()));
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }
    
    @Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return id.hashCode();
	}
}
