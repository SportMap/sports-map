package pl.edu.pja.sportsmap.persistence.dao;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import pl.edu.pja.sportsmap.persistence.model.SportComplex;
import pl.edu.pja.sportsmap.persistence.model.SportComplexStatus;

import java.util.List;

public interface SportComplexPaginationRepository extends PagingAndSortingRepository<SportComplex, Long> {
    List<SportComplex> findAllByStatus(SportComplexStatus status, Pageable pageable);
}
