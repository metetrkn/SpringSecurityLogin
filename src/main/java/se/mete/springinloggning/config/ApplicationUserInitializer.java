package se.mete.springinloggning.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import se.mete.springinloggning.entity.ApplicationUser;
import se.mete.springinloggning.repository.ApplicationUserRepository;

@Component // Marks this class as a Spring component, making it a candidate for auto-detection and dependency injection
public class ApplicationUserInitializer {

    @Autowired // Injects an instance of ApplicationUserRepository
    private ApplicationUserRepository userRepository;

    @Autowired // Injects an instance of PasswordEncoder for encoding passwords
    private PasswordEncoder passwordEncoder;

    /**
     * Default method to create new users into system if there is no initial records in db
     * In that case 1 user, admin and manager will create in db
     */
    @PostConstruct // This method will be executed after dependency injection is done to perform any initialization
    public void initializeUsers() {
        // Check if there are no users in the repository
        if (userRepository.count() == 0) {
            // Create and save a user with the USER role
            ApplicationUser user = new ApplicationUser();
            user.setUsername("user"); // Set the username
            user.setPassword(passwordEncoder.encode("userpass")); // Encode and set the password
            user.setRole("ROLE_USER"); // Set the role
            userRepository.save(user); // Save the user to the repository

            // Create and save a user with the ADMIN role
            ApplicationUser admin = new ApplicationUser();
            admin.setUsername("admin"); // Set the username
            admin.setPassword(passwordEncoder.encode("adminpass")); // Encode and set the password
            admin.setRole("ROLE_ADMIN"); // Set the role
            userRepository.save(admin); // Save the admin to the repository

            // Create and save a user with the MANAGER role
            ApplicationUser manager = new ApplicationUser();
            manager.setUsername("manager"); // Set the username
            manager.setPassword(passwordEncoder.encode("managerpass")); // Encode and set the password
            manager.setRole("ROLE_MANAGER"); // Set the role
            userRepository.save(manager); // Save the manager to the repository
        }
    }
}