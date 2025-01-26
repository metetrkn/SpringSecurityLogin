package se.mete.springinloggning.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import se.mete.springinloggning.entity.ApplicationUser;
import se.mete.springinloggning.repository.ApplicationUserRepository;

@Component
public class ApplicationUserInitializer {

    @Autowired
    private ApplicationUserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void initializeUsers() {
        // Only initialize if no users exist
        if (userRepository.count() == 0) {
            // Create USER role
            ApplicationUser user = new ApplicationUser();
            user.setUsername("user");
            user.setPassword(passwordEncoder.encode("userpass"));
            user.setRole("ROLE_USER");
            userRepository.save(user);

            // Create ADMIN role
            ApplicationUser admin = new ApplicationUser();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("adminpass"));
            admin.setRole("ROLE_ADMIN");
            userRepository.save(admin);

            // Create MANAGER role
            ApplicationUser manager = new ApplicationUser();
            manager.setUsername("manager");
            manager.setPassword(passwordEncoder.encode("managerpass"));
            manager.setRole("ROLE_MANAGER");
            userRepository.save(manager);
        }
    }
}
