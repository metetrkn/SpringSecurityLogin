package se.mete.springinloggning.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


/**
 * ApplicationUser entity/Table = represents different users in the db
 */
@Entity
public class ApplicationUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Automatically generates the ID
    private Long id; // Primary Key
    private String username; // Username of the user
    private String password; // Password of the user
    private String role; // Role of the user (e.g., USER, ADMIN, MANAGER)


    /**
     * Empty constructor for JPA
     */
    public ApplicationUser() {}


    /**
     * Parametrized constructor
     *
     * @param username = users name and surname
     * @param password = users password to logg in the system
     * @param role = users authorization role in the system
     */
    public ApplicationUser(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }


    /**
     * Getters and setters of class attributes
     */
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
