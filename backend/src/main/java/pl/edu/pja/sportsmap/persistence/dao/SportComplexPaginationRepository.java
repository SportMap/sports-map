package pl.edu.pja.sportsmap.persistence.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import pl.edu.pja.sportsmap.persistence.model.SportComplex;

public interface SportComplexPaginationRepository extends PagingAndSortingRepository<SportComplex, Long> {
}
