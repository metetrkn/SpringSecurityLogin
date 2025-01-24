package se.mete.springinloggning.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import se.mete.springinloggning.entity.User;
import se.mete.springinloggning.repository.UserRepository;


/**
 * A component that initializes data in the database when the application starts.
 * This class implements CommandLineRunner, which allows it to execute code
 * after the application context is loaded.
 */
@Component // Marks this class as a Spring component, making it a managed bean
public class DataInitializer implements CommandLineRunner {
    // Injecting beans
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * This method is executed after the application context is loaded.
     * It checks if the database is empty and, if so, creates a default user.
     *
     * @param args Command-line arguments passed to the application (not used here)
     */
    @Override
    public void run(String... args) {
        // Check if the database has no users
        if (userRepository.count() == 0) {
            // Create a new User object
            User user = new User();
            user.setUsername("user"); // Set the username
            user.setPassword(passwordEncoder.encode("password")); // Encode and set the password
            user.setRole("ROLE_USER"); // Set the user's role

            // Save the user to the database
            userRepository.save(user);
        }
    }
}