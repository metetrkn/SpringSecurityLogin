package se.mete.springinloggning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import se.mete.springinloggning.entity.User;
import se.mete.springinloggning.repository.UserRepository;

/**
 * Custom implementation of the UserDetailsService interface.
 * This service is used by Spring Security to load user-specific data
 * during the authentication process.
 */
@Service // Marks this class as a Spring service component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired // Injects the UserRepository bean
    private UserRepository userRepository;

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
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        // Return the User object, which implements the UserDetails interface
        return user;
    }
}