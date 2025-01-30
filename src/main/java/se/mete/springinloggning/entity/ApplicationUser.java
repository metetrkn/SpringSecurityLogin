package se.mete.springinloggning.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.Collections;
import lombok.Data;


/**
 * @Entity = Marks this class as a table
 * @Data = Lombok annotation to automatically generate getters, setters etc
 * ApplicationUser class represents each user/row/record in table
 */
@Entity
@Data // Automatic getters and setters
@Table(name = "application_users") // Name of the table
public class ApplicationUser implements UserDetails {

    @Id // Primary key annotation
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generated ID
    private Long id;

    @Column(unique = true, nullable = false) // Ensures usernames are unique and can not be null
    private String username; // Username of the user

    @Column(nullable = false) // Ensures the password cannot be null
    private String password; // Password of user encoded

    @Column(nullable = false) // Ensures the role cannot be null
    private String role; // Role of the user (e.g., ROLE_USER, ROLE_ADMIN)


    /**
     * Default constructor for JPA.
     */
    public ApplicationUser() {}


    /**
     * Parameterized constructor for ApplicationUser
     *
     * @param username Username of the user
     * @param password Password of the user
     * @param role Role of the user
     */
    public ApplicationUser(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }


    // Getters and setters are automatically generated by Lombok's @Data annotation


    /**
     * Implements the abstract getAuthorities() method from the UserDetails interface in Spring Security.
     * Implementation must for interface’s sake
     * Gets the role field of objects and Spring Security uses these info to check which users allowed to access
     *
     * @return A collection of GrantedAuthority objects
     */
    @Override
    public Collection<  ? extends GrantedAuthority> getAuthorities() {
        // Returns a singleton list of GrantedAuthority
        // Returns only one role for each user
        // In the abstract getAuthorities() method's signature expects collection as return type
        // The reason we return singletonList is immutability, role can not change after created
        return Collections.singletonList(new SimpleGrantedAuthority(role));
    }
}