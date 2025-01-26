package se.mete.springinloggning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.mete.springinloggning.entity.ApplicationUser;

import java.util.Optional;

@Repository // Marks this interface as a Spring Data repository
public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {
    /**
     * Finds an ApplicationUser by their username.
     *
     * @param username The username to search for
     * @return An Optional containing the ApplicationUser if found, or empty if not found
     */
    Optional<ApplicationUser> findByUsername(String username);
}