package pl.edu.pja.sportsmap.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pja.sportsmap.persistence.model.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
}
