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
@Configuration
@EnableWebSecurity // Web security support
public class SecurityConfig {

    @Autowired
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
    @Bean // Marks this method as a bean definition
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/user/**").hasAnyRole("USER", "ADMIN", "MANAGER")
                        .requestMatchers("/admin/**").hasAnyRole("ADMIN", "MANAGER")
                        .requestMatchers("/manager/**").hasRole("MANAGER")
                        .requestMatchers("/create-user").hasAnyRole("ADMIN", "MANAGER")
                        .requestMatchers("/", "/login").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .successHandler(successHandler)
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/login?logout")
                        .permitAll()
                );

        return http.build();
    }
}