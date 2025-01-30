package se.mete.springinloggning.service;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import se.mete.springinloggning.repository.ApplicationUserRepository;
import se.mete.springinloggning.entity.ApplicationUser;


/**
 * Interacts with controller-UserManagementController and repository-userRepository
 * To create new user and save it into db
 */
@Service // Marks this class as a Spring service component
public class UserService {
    // Dependency injection in constructor
    private final ApplicationUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    /**
     * Parameterised constructor used for Dependency Injection
     *
     * @param userRepository = Interacts with DB
     * @param passwordEncoder = To hash passwords
     */
    public UserService(ApplicationUserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    /**
     * Creates a new user with the provided unique username, password, and role.
     * The password is hashed before being stored in the database.
     *
     * @param username The username of the new user
     * @param password The password of the new user
     * @param role The role of the new user (e.g., USER, ADMIN, MANAGER)
     * @throws RuntimeException If the username already exists in the database
     */
    public void createUser(String username, String password, String role) {
        // Check if a user with the same username already exists
        if (userRepository.findByUsername(username).isPresent()) {
            throw new RuntimeException("Username already exists"); // Throw an exception if the username is taken
        }

        // Hashes the plain text password using the PasswordEncoder
        String encodedPassword = passwordEncoder.encode(password);

        // Create a new ApplicationUser object with the provided details
        ApplicationUser newUser = new ApplicationUser(username, encodedPassword, role);

        // Save the new user to the database and return the saved user
        userRepository.save(newUser);
    }
}