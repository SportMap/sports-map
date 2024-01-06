package pl.edu.pja.sportsmap.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pja.sportsmap.persistence.model.OpeningHours;

import java.time.DayOfWeek;
import java.util.List;

public interface OpeningHoursRepository extends JpaRepository<OpeningHours, Long> {
    List<OpeningHours> findBySportComplexId(Long complexId);
    OpeningHours getOpeningHoursBySportComplexIdAndAndDayOfWeek(Long sportComplexId, DayOfWeek dayOfWeek);
}
