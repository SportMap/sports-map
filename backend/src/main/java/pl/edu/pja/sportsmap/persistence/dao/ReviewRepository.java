package pl.edu.pja.sportsmap.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.edu.pja.sportsmap.persistence.model.Review;

import java.util.List;


public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findAllBySportComplexId(Long sportComplexId);

    @Query("SELECT COUNT(r) FROM Review r WHERE r.sportComplex.id = :sportComplexId AND r.rate = :rate")
    Long countReviewsBySportComplexIdAndRate(@Param("sportComplexId") Long sportComplexId, @Param("rate") Integer rate);

    Long countReviewsBySportComplexId(Long sportComplexId);
}


