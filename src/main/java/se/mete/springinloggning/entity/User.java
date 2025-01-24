package se.mete.springinloggning.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

/**
 * Entity class representing a user in the application.
 * This class implements the UserDetails interface, which is required
 * by Spring Security for authentication and authorization.
 */
@Entity // Marks this class as a JPA entity, representing a table in the database
public class User implements UserDetails {

    @Id // Marks this field as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generates the ID using database identity column
    private Long id; // Primary key for the user

    private String username; // Username of the user
    private String password; // Password of the user (encoded)
    private String role; // Role of the user (e.g., ROLE_USER, ROLE_ADMIN)

    /**
     * Default constructor required by JPA.
     */
    public User() {}

    /**
     * Parameterized constructor for creating a User object.
     *
     * @param username The username of the user
     * @param password The password of the user
     * @param role The role of the user
     */
    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    // Getters and setters

    /**
     * Returns the authorities (roles) granted to the user.
     *
     * @return A collection of GrantedAuthority objects
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Returns a singleton list containing the user's role as a GrantedAuthority
        return Collections.singletonList(new SimpleGrantedAuthority(role));
    }

    /**
     * Returns the password of the user.
     *
     * @return The password of the user
     */
    @Override
    public String getPassword() {
        return password;
    }

    /**
     * Returns the username of the user.
     *
     * @return The username of the user
     */
    @Override
    public String getUsername() {
        return username;
    }

    /**
     * Indicates whether the user's account has expired.
     *
     * @return true if the account is non-expired, false otherwise
     */
    @Override
    public boolean isAccountNonExpired() {
        return true; // Accounts are always non-expired
    }

    /**
     * Indicates whether the user's account is locked.
     *
     * @return true if the account is non-locked, false otherwise
     */
    @Override
    public boolean isAccountNonLocked() {
        return true; // Accounts are always non-locked
    }

    /**
     * Indicates whether the user's credentials (password) have expired.
     *
     * @return true if the credentials are non-expired, false otherwise
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Credentials are always non-expired
    }

    /**
     * Indicates whether the user is enabled.
     *
     * @return true if the user is enabled, false otherwise
     */
    @Override
    public boolean isEnabled() {
        return true; // Users are always enabled
    }

    /**
     * Sets the username of the user.
     *
     * @param username The username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Sets the password of the user.
     *
     * @param password The password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Sets the role of the user.
     *
     * @param role The role to set
     */
    public void setRole(String role) {
        this.role = role;
    }
}