package pl.edu.pja.sportsmap.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pja.sportsmap.persistence.model.UserEvent;

public interface UserEventRepository extends JpaRepository<UserEvent, Long> {
}
