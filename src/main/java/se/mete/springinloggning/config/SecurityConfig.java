package se.mete.springinloggning.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Security configuration class for the application.
 * This class configures Spring Security to handle authentication and authorization.
 */
@Configuration // Marks this class as a configuration class for Spring
@EnableWebSecurity // Enables Spring Security's web security support
public class SecurityConfig {

    @Autowired // Injects the custom authentication success handler
    private CustomAuthenticationSuccessHandler successHandler;

    /**
     * Configures the security filter chain for HTTP requests.
     * This method defines which endpoints are public, which require authentication,
     * and how login and logout are handled.
     *
     * @param http The HttpSecurity object used to configure security
     * @return The configured SecurityFilterChain
     * @throws Exception If an error occurs during configuration
     */
    @Bean // Marks this method as a bean definition, making it a Spring-managed bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        // Define access rules for specific endpoints
                        .requestMatchers("/user/**").hasAnyRole("USER", "ADMIN", "MANAGER") // Allow USER, ADMIN, and MANAGER roles to access /user/**
                        .requestMatchers("/admin/**").hasAnyRole("ADMIN", "MANAGER") // Allow ADMIN and MANAGER roles to access /admin/**
                        .requestMatchers("/manager/**").hasRole("MANAGER") // Allow only MANAGER role to access /manager/**
                        .requestMatchers("/create-user").hasAnyRole("ADMIN", "MANAGER") // Allow ADMIN and MANAGER roles to access /create-user
                        .requestMatchers("/", "/login").permitAll() // Allow public access to the root and login pages
                        .anyRequest().authenticated() // Require authentication for all other requests
                )
                .formLogin(form -> form
                        .loginPage("/login") // Specify the custom login page
                        .successHandler(successHandler) // Use the custom success handler for login redirection
                        .permitAll() // Allow everyone to access the login page
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/login?logout") // Redirect to the login page with a logout parameter after logout
                        .permitAll() // Allow everyone to access the logout endpoint
                );

        return http.build(); // Build and return the configured SecurityFilterChain
    }
}