package pl.edu.pja.sportsmap.controller;

import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(
            summary = "returns a list of reviews about an object with the given id")
    @GetMapping("{id}")
    public ResponseEntity<List<GetReviewDto>> getAllSportComplexReviewsById(@PathVariable("id") Long id){
        List<Review> reviews = reviewService.getAllReviewsBySportComplexId(id);
        List<GetReviewDto> reviewsDto = new ArrayList<>();
        for (Review review : reviews){
            reviewsDto.add(reviewService.convertEntityToDto(review));
        }
        return ResponseEntity.ok(reviewsDto);
    }

    @Operation(
            summary = "add new review ",
            description = "Body - UserId and SportComplexId must exists in database")
    @PostMapping()
    public ResponseEntity<Review> addReview(@RequestBody AddReviewDto reviewDto){
        Review review = reviewService.addReview(reviewDto);
        return ResponseEntity.ok(review);
    }

}
