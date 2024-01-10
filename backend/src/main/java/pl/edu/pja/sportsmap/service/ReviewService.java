package pl.edu.pja.sportsmap.service;

import org.springframework.stereotype.Service;
import pl.edu.pja.sportsmap.dto.ReviewDto;
import pl.edu.pja.sportsmap.persistence.dao.ReviewRepository;
import pl.edu.pja.sportsmap.persistence.model.Review;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> getAllReviewsBySportComplexId(Long id){

      return reviewRepository.findAllBySportComplexId(id);
    }

}
