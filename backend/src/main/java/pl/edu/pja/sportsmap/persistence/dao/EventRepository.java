package pl.edu.pja.sportsmap.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pja.sportsmap.persistence.model.Event;

public interface EventRepository extends JpaRepository<Event, Long> {
}
