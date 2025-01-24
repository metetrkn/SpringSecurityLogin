package se.mete.springinloggning.repository;


// Interface for JPA repository to manage ApplicationUser entities
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.mete.springinloggning.entity.User;


// Entity is assumed to be ApplicationUser with Long as ID type
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Additional query methods can be added here if needed
}
