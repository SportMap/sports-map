package pl.edu.pja.sportsmap.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import pl.edu.pja.sportsmap.dto.review.AddReviewDto;
import pl.edu.pja.sportsmap.dto.review.GetReviewDto;
import pl.edu.pja.sportsmap.persistence.dao.ReviewRepository;
import pl.edu.pja.sportsmap.persistence.dao.SportComplexRepository;
import pl.edu.pja.sportsmap.persistence.dao.UserRepository;
import pl.edu.pja.sportsmap.persistence.model.Review;
import pl.edu.pja.sportsmap.persistence.model.SportComplex;
import pl.edu.pja.sportsmap.persistence.model.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final SportComplexRepository sportComplexRepository;
    private final UserService userService;

    public ReviewService(ReviewRepository reviewRepository, UserRepository userRepository, SportComplexRepository sportComplexRepository, UserService userService) {
        this.reviewRepository = reviewRepository;
        this.userRepository = userRepository;
        this.sportComplexRepository = sportComplexRepository;
        this.userService = userService;
    }

    public List<Review> getAllReviewsBySportComplexId(Long id){

      return reviewRepository.findAllBySportComplexId(id);
    }

    public Review addReview(AddReviewDto addReviewDto){
        Review review = convertDtoToEntity(addReviewDto);
        return reviewRepository.save(review);
    }

    public GetReviewDto convertEntityToDto(Review review){
        return GetReviewDto.builder()
                .nickname(userService.getNicknameById(review.getUser().getId()))
                .date(review.getReviewDate())
                .rate(review.getRate())
                .content(review.getContent())
                .avatar(userService.getAvatarById(review.getUser().getId()))
                .build();
    }

    public Review convertDtoToEntity(AddReviewDto reviewDto) {
        Review review = new Review();

        review.setContent(reviewDto.content());
        review.setRate(reviewDto.rate());

        Optional<User> userOptional = userRepository.findUserByNickname(reviewDto.nickname());
        User user = userOptional.orElseThrow(() -> new EntityNotFoundException("User not found"));
        review.setUser(user);

        Optional<SportComplex> sportComplexOptional = sportComplexRepository.findById(reviewDto.sportComplexId());
        SportComplex sportComplex = sportComplexOptional.orElseThrow(() -> new EntityNotFoundException("Sport Complex not found"));
        review.setSportComplex(sportComplex);

        review.setReviewDate(LocalDate.now());
        return review;
    }


}
