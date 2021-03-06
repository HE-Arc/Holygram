package ch.hearc.holygram.models;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * Represente a user
 */
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2, max = 30)
    @Column(unique = true)
    private String username;

    @NotNull
    @Size(min = 2, max = 30)
    @Column(unique = true)
    private String email;

    @NotNull
    private String password;

    @OneToOne(mappedBy = "user")
    private Customer customer;

    @OneToOne(mappedBy = "user")
    private Exorcist exorcist;

    @Transient
    private String passwordConfirm;

    private Date lastLogin;

    @ManyToOne
    @JoinColumn
    @JsonBackReference
    private Role role;

    public User(String username, String password, String email, Role role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public User(String username, String password, String passwordConfirm, String email) {
        this.username = username;
        this.password = password;
        this.passwordConfirm = passwordConfirm;
        this.email = email;
    }

    public User() {
    }

    /*
     * Dirty method to get attributes of a user 3 Classes (Template, Business,
     * Entity) for each Model should be used
     */
    public Map<String, String> getAttributes() {
        Map<String, String> attributes = new HashMap<>();

        attributes.put("id", id.toString());
        attributes.put("username", username);
        attributes.put("email", email);

        return attributes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Exorcist getExorcist() {
        return exorcist;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setExorcist(Exorcist exorcist) {
		this.exorcist = exorcist;
	}
}
