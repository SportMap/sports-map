package pl.edu.pja.sportsmap.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pja.sportsmap.persistence.model.Review;

import java.util.List;


public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findAllBySportComplexId(Long sportComplexId);
}


