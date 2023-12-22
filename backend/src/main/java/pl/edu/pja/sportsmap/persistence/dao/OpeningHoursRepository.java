package pl.edu.pja.sportsmap.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pja.sportsmap.persistence.model.OpeningHours;

public interface OpeningHoursRepository extends JpaRepository<OpeningHours, Long> {

}
