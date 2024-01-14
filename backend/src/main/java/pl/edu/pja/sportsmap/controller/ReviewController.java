package pl.edu.pja.sportsmap.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pja.sportsmap.dto.review.AddReviewDto;
import pl.edu.pja.sportsmap.dto.review.GetReviewDto;
import pl.edu.pja.sportsmap.persistence.model.Review;
import pl.edu.pja.sportsmap.service.ReviewService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("{id}")
    public ResponseEntity<List<GetReviewDto>> getAllSportComplexReviewsById(@PathVariable("id") Long id){
        List<Review> reviews = reviewService.getAllReviewsBySportComplexId(id);
        List<GetReviewDto> reviewsDto = new ArrayList<>();
        for (Review review : reviews){
            reviewsDto.add(reviewService.convertEntityToDto(review));
        }
        return ResponseEntity.ok(reviewsDto);
    }

    @PostMapping()
    public ResponseEntity<Review> addReview(@RequestBody AddReviewDto reviewDto){
        Review review = reviewService.addReview(reviewDto);
        return ResponseEntity.ok(review);
    }

}
