package pl.edu.pja.sportsmap.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pja.sportsmap.persistence.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByNickname(String nickname);
}
