package se.mete.springinloggning.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Security configuration class for the application.
 * This class configures Spring Security to handle authentication and authorization.
 */
@Configuration // Marks this class as a configuration, fabrik for @Beans
@EnableWebSecurity // Enables Spring Security's web security support
public class SecurityConfig {

    // Constructor injection
    private final CustomAuthenticationSuccessHandler successHandler;

    /**
     * Parametrised constructor with DI
     *
     * @param successHandler = how app reacts after authentication
     */
    public SecurityConfig(CustomAuthenticationSuccessHandler successHandler) {
        this.successHandler = successHandler;
    }

    /**
     * Configures the security filter chain for HTTP requests.
     *
     * @param http The HttpSecurity object used to configure security
     * @return The configured SecurityFilterChain
     * @throws Exception If an error occurs during configuration
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        //This section specifies which users (based on roles) can access different parts of the application.
        http.authorizeHttpRequests(auth -> auth

                        // Define access rules for specific endpoints
                        // Allow USER, ADMIN, and MANAGER roles to access /user/** url
                        .requestMatchers("/user/**").hasAnyRole("USER", "ADMIN", "MANAGER")

                        // Allow ADMIN and MANAGER roles to access /admin/** url
                        .requestMatchers("/admin/**").hasAnyRole("ADMIN", "MANAGER")

                        // Allow only MANAGER role to access /manager/** url
                        .requestMatchers("/manager/**").hasRole("MANAGER")

                        // Allow ADMIN and MANAGER roles to access /create-user/** url
                        .requestMatchers("/create-user/**").hasAnyRole("ADMIN", "MANAGER")

                        // Allow public access/all users to the root and login pages
                        .requestMatchers("/", "/login").permitAll()

                        // All other requests doesn't specify above requires authentication
                        .anyRequest().authenticated()
                )

                .formLogin(form -> form // Lambda expression for representing the FormLoginConfigurer<HttpSecurity> object.
                        // Specify the custom login page / not default login page of Spring Security
                        .loginPage("/login")
                        // How to act after authorization. Use custom success handler that defined in config/CustomAuth...
                        .successHandler(successHandler)
                        // Allow all users to access the login page
                        .permitAll()
                )

                // Method reference, ClassName::methodName
                .logout(LogoutConfigurer::permitAll // Allow all users to access the logout endpoint
                );

        // Returns configured SecurityFilterChain
        return http.build();
    }
}