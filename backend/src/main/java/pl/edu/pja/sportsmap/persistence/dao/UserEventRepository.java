package pl.edu.pja.sportsmap.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pja.sportsmap.persistence.model.UserEvent;
import java.util.List;

public interface UserEventRepository extends JpaRepository<UserEvent, Long> {

    public Integer countByEventId(Long eventId);

    public boolean existsByUser_IdAndEvent_Id(Long userId, Long eventId);

    public List<UserEvent> findAllByUserId(Long userId);
}
