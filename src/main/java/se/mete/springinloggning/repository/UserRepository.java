package se.mete.springinloggning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.mete.springinloggning.entity.User;

import java.util.Optional;

/**
 * Repository interface for managing User entities.
 * This interface extends JpaRepository, providing CRUD operations
 * and additional query methods for the User entity.
 */
@Repository // Marks this interface as a Spring Data repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Finds a user by their username.
     *
     * @param username The username to search for
     * @return An Optional containing the User if found, or empty if not found
     */
    Optional<User> findByUsername(String username);
}