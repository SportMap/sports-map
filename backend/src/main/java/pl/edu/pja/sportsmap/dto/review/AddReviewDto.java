package pl.edu.pja.sportsmap.dto.review;

import lombok.Builder;


@Builder
public record AddReviewDto(String content, Integer rate, Long userId, Long sportComplexId) {
}
