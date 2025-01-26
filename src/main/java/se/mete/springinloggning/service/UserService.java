package se.mete.springinloggning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import se.mete.springinloggning.repository.ApplicationUserRepository;
import se.mete.springinloggning.entity.ApplicationUser;

@Service
public class UserService {
    @Autowired
    private ApplicationUserRepository userRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public ApplicationUser createUser(String username, String password, String role) {
        if (userRepository.findByUsername(username).isPresent()) {
            throw new RuntimeException("Username already exists");
        }
        
        String encodedPassword = passwordEncoder.encode(password);
        ApplicationUser newUser = new ApplicationUser(username, encodedPassword, role);
        return userRepository.save(newUser);
    }
}
