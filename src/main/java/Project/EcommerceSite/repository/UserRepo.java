package Project.EcommerceSite.repository;

import Project.EcommerceSite.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User , Long> {
    Optional<User> findByUsername(String username);
}
