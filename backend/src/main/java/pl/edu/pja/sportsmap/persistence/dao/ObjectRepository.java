package pl.edu.pja.sportsmap.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pja.sportsmap.persistence.model.SportObject;

public interface ObjectRepository extends JpaRepository<SportObject, Long> {
}
