package ch.hearc.holygram.models;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
    private String email;

    @NotNull
    private String password;

    @OneToOne(optional = false, mappedBy = "user")
    private Customer customer;

    @OneToOne(optional = false, mappedBy = "user")
    private Exorcist exorcist;

    @Transient
    private String passwordConfirm;

    private Date lastLogin;

    @ManyToOne
    @JoinColumn
    @JsonBackReference
    private Role role;

    public User(String username, String password, String email, Role role) throws Exception {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public User(String username, String password, String passwordConfirm, String email) throws Exception {
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
        Map<String, String> attributes = new HashMap<String, String>();

        attributes.put("id", id.toString());
        attributes.put("username", username.toString());
        attributes.put("email", email.toString());

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
        // TODO Auto-generated method stub
        return id.hashCode();
    }
}
