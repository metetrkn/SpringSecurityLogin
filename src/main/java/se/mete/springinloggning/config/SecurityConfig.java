package se.mete.springinloggning.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import se.mete.springinloggning.service.CustomUserDetailsService;

/**
 * Security configuration class for the application.
 * This class configures Spring Security to handle authentication and authorization.
 */
@Configuration
@EnableWebSecurity // Web security support
public class SecurityConfig {
    // Injects beans
    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Configures the security filter chain for HTTP requests.
     * This method defines which endpoints are public, which require authentication,
     * and how login and logout are handled.
     *
     * @param http The HttpSecurity object used to configure security
     * @return The configured SecurityFilterChain
     * @throws Exception If an error occurs during configuration
     */
    @Bean // Marks this method as a bean definition
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Configure authorization rules
                .authorizeHttpRequests(auth -> auth
                        // Allow access to the login page and static resources without authentication
                        .requestMatchers("/login", "/css/**", "/js/**").permitAll()
                        // Require authentication for all other requests
                        .anyRequest().authenticated()
                )
                // Configure form-based login
                .formLogin(form -> form
                        .loginPage("/login") // Specify the custom login page
                        .loginProcessingUrl("/login") // URL to submit the login form
                        .defaultSuccessUrl("/welcome", true) // Redirect to /welcome after successful login
                        .failureUrl("/login?error=true") // Redirect to /login with an error parameter on failure
                        .permitAll() // Allow everyone to access the login page
                )
                // Configure logout
                .logout(logout -> logout
                        .logoutSuccessUrl("/login?logout=true") // Redirect to /login with a logout parameter after logout
                        .invalidateHttpSession(true) // Invalidate the HTTP session
                        .deleteCookies("JSESSIONID") // Delete the JSESSIONID cookie
                        .permitAll() // Allow everyone to access the logout endpoint
                );

        // Build and return the configured SecurityFilterChain
        return http.build();
    }

    /**
     * Configures the global authentication manager.
     * This method sets up the custom UserDetailsService and PasswordEncoder
     * for authenticating users.
     *
     * @param auth The AuthenticationManagerBuilder used to configure authentication
     * @throws Exception If an error occurs during configuration
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // Use the custom UserDetailsService and PasswordEncoder for authentication
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }
}