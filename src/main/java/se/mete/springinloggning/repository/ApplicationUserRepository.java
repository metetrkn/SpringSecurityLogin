package se.mete.springinloggning.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.mete.springinloggning.entity.ApplicationUser;
import java.util.Optional;


/**
 * JpaRepository<T, ID> = Spring Data JPA interface that provides CRUD operations for an entity.
 * T = ApplicationUser entity class that represents table
 * ID = unique ID of object/user in the table
 */
@Repository // Marks this interface as a Spring Data repository
public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {
    /**
     * Querying db to find an ApplicationUser object/user by their username.
     *
     * @param username The username to search for
     * @return An Optional containing the ApplicationUser if found otherwise empty
     */
    Optional<ApplicationUser> findByUsername(String username);
}