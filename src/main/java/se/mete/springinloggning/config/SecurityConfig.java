//package se.mete.springinloggning.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class SecurityConfig {
//
//    // Configure HTTP security
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable() // Disable CSRF for simplicity (enable in production)
//                .authorizeHttpRequests(authorize -> authorize
//                        .requestMatchers("/admin/**").hasRole("ADMIN") // Only ADMIN role can access /admin paths
//                        .requestMatchers("/user/**").hasRole("USER") // Only USER role can access /user paths
//                        .anyRequest().authenticated() // All other requests require authentication
//                )
//                .formLogin(form -> form
//                        .loginPage("/login") // Custom login page
//                        .permitAll() // Allow access to login for everyone
//                )
//                .logout(logout -> logout
//                        .logoutUrl("/logout")
//                        .permitAll() // Allow everyone to logout
//                );
//
//        return http.build();
//    }
//
//    // Password encoder for encoding passwords
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    // Configure authentication with in-memory users or custom user details
//    @Bean
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("admin")
//                .password(passwordEncoder().encode("admin123"))
//                .roles("ADMIN")
//                .and()
//                .withUser("user")
//                .password(passwordEncoder().encode("user123"))
//                .roles("USER");
//    }
//}
