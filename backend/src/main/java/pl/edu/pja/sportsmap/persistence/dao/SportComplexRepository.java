package pl.edu.pja.sportsmap.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pja.sportsmap.persistence.model.SportComplex;
import pl.edu.pja.sportsmap.persistence.model.SportComplexStatus;

import java.util.List;

public interface SportComplexRepository extends JpaRepository<SportComplex, Long> {
    List<SportComplex> findAllByStatus(SportComplexStatus status);
}
