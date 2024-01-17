package pl.edu.pja.sportsmap.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.edu.pja.sportsmap.persistence.model.Event;
import pl.edu.pja.sportsmap.persistence.model.Review;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    @Query(value = "SELECT * FROM events WHERE NOW() BETWEEN start_time AND end_time AND sport_complex_id = :sportComplexId", nativeQuery = true)
    List<Event> findCurrentEventsByComplexId(@Param("sportComplexId") Long sportComplexId);

    @Query(value = "SELECT * FROM events " +
            "WHERE start_time >= CURRENT_DATE + INTERVAL '1 day' AND start_time < CURRENT_DATE + INTERVAL '2 days' " +
            "AND sport_complex_id = :sportComplexId", nativeQuery = true)
    List<Event> findEventsStartingNextDayByComplexId(@Param("sportComplexId") Long sportComplexId);

    List<Event> findAllBySportComplexIdAndEndTimeAfter(Long sportComplexId, LocalDateTime endDate);

    List<Event> findAllByUserIdAndEndTimeAfter(Long userId, LocalDateTime endDate);
}
