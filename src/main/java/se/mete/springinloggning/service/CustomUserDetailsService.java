package se.mete.springinloggning.service;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import se.mete.springinloggning.entity.ApplicationUser;
import se.mete.springinloggning.repository.ApplicationUserRepository;
import java.util.Collections;

/**
 * Custom implementation of the UserDetailsService interface.
 * This service is used by Spring Security to load user-specific data
 * during the authentication process.
 */
@Service // Marks this class as a Spring service component
public class CustomUserDetailsService implements UserDetailsService {

    // Injecting in constructor, safer than @AutoWired
    private final ApplicationUserRepository userRepository;

    public CustomUserDetailsService(ApplicationUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Loads a user by their username.
     * This method is called by Spring Security during the authentication process.
     *
     * @param username The username of the user to load
     * @return A UserDetails object representing the user
     * @throws UsernameNotFoundException If the user is not found
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Find the user by username in the repository
        ApplicationUser applicationUser = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        // Create and return a UserDetails object using the user's details
        return new User(
                applicationUser.getUsername(), // Username of the user
                applicationUser.getPassword(), // Password of the user (encoded)
                Collections.singleton(new SimpleGrantedAuthority(applicationUser.getRole())) // User's role as a GrantedAuthority
        );
    }
}