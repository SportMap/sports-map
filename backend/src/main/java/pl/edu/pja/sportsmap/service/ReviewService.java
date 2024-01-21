package pl.edu.pja.sportsmap.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import pl.edu.pja.sportsmap.dto.review.AddReviewDto;
import pl.edu.pja.sportsmap.dto.review.GetRatesDto;
import pl.edu.pja.sportsmap.dto.review.GetReviewDto;
import pl.edu.pja.sportsmap.persistence.dao.ReviewRepository;
import pl.edu.pja.sportsmap.persistence.dao.SportComplexRepository;
import pl.edu.pja.sportsmap.persistence.dao.UserRepository;
import pl.edu.pja.sportsmap.persistence.model.Review;
import pl.edu.pja.sportsmap.persistence.model.SportComplex;
import pl.edu.pja.sportsmap.persistence.model.User;

import java.text.DecimalFormat;
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

    public GetRatesDto getSportComplexRatesById(Long id){
        return GetRatesDto.builder()
                .sportComplexId(getSportComplexId(id))
                .total(reviewRepository.countReviewsBySportComplexId(id))
                .one(reviewRepository.countReviewsBySportComplexIdAndRate(getSportComplexId(id), 1))
                .two(reviewRepository.countReviewsBySportComplexIdAndRate(getSportComplexId(id),2))
                .three(reviewRepository.countReviewsBySportComplexIdAndRate(getSportComplexId(id),3))
                .four(reviewRepository.countReviewsBySportComplexIdAndRate(getSportComplexId(id),4))
                .five(reviewRepository.countReviewsBySportComplexIdAndRate(getSportComplexId(id),5))
                .medium(getMediumRateForSportComplex(getSportComplexId(id)))
                .build();

    }

    public Long getSportComplexId(Long id){
        if (sportComplexRepository.findById(id).isPresent()) {
            return sportComplexRepository.findById(id).get().getId();
        }else return null;
    }

    public String getMediumRateForSportComplex(Long id){
        Long totalCount = reviewRepository.countReviewsBySportComplexId(id);
        Long oneCount = reviewRepository.countReviewsBySportComplexIdAndRate(getSportComplexId(id), 1);
        Long twoCount = reviewRepository.countReviewsBySportComplexIdAndRate(getSportComplexId(id),2);
        Long threeCount = reviewRepository.countReviewsBySportComplexIdAndRate(getSportComplexId(id),3);
        Long fourCount = reviewRepository.countReviewsBySportComplexIdAndRate(getSportComplexId(id),4);
        Long fiveCount = reviewRepository.countReviewsBySportComplexIdAndRate(getSportComplexId(id),5);
        Double result = (double) (oneCount + twoCount * 2 + threeCount * 3 + fourCount * 4 + fiveCount * 5) / totalCount;

        DecimalFormat decimalFormat = new DecimalFormat("#.#");
        String resultString = decimalFormat.format(result);
        return resultString;
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

        Optional<User> userOptional = userRepository.findById(reviewDto.userId());
        User user = userOptional.orElseThrow(() -> new EntityNotFoundException("User not found"));
        review.setUser(user);

        Optional<SportComplex> sportComplexOptional = sportComplexRepository.findById(reviewDto.sportComplexId());
        SportComplex sportComplex = sportComplexOptional.orElseThrow(() -> new EntityNotFoundException("Sport Complex not found"));
        review.setSportComplex(sportComplex);

        review.setReviewDate(LocalDate.now());
        return review;
    }


}
