package pl.edu.pja.sportsmap.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pja.sportsmap.persistence.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
