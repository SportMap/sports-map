package pl.edu.pja.sportsmap.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pja.sportsmap.dto.ReviewDto;
import pl.edu.pja.sportsmap.persistence.model.Review;
import pl.edu.pja.sportsmap.service.ReviewService;
import pl.edu.pja.sportsmap.service.UserService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService reviewService;
    private final UserService userService;

    public ReviewController(ReviewService reviewService, UserService userService) {
        this.reviewService = reviewService;
        this.userService = userService;
    }



    @GetMapping("/get-reviews-{id}")
    public ResponseEntity<List<ReviewDto>> getAllSportComplexReviewsById(@PathVariable("id") Long id){
        List<Review> reviews = reviewService.getAllReviewsBySportComplexId(id);
        List<ReviewDto> reviewsDto = new ArrayList<>();
        for (Review review : reviews){
            reviewsDto.add(convertEntityToDto(review));
        }
        return ResponseEntity.ok(reviewsDto);
    }

    private ReviewDto convertEntityToDto(Review review){
        return ReviewDto.builder()
                .nickname(userService.getNicknameById(review.getUser().getId()))
                .date(review.getReview_date())
                .rate(review.getRate())
                .content(review.getContent())
                .build();
    }
}
