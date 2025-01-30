package se.mete.springinloggning.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


/**
 * Used for encoding passwords in the application.
 * PasswordEncoder interface that defined here used in service layer-UserService to hash new user passwords
 */
@Configuration // Configuration annotation to create Spring config class, fabrik for @Beans
public class PasswordEncoderConfig {

    /**
     * Defines a bean for the PasswordEncoder for securely hashing passwords using the BCrypt
     *
     * @return A new instance of BCryptPasswordEncoder.
     */
    @Bean // Indicates that this method returns a bean managed by the Spring application context container
    public PasswordEncoder passwordEncoder() {
        // Create and return a new BCryptPasswordEncoder instance
        return new BCryptPasswordEncoder();
    }
}