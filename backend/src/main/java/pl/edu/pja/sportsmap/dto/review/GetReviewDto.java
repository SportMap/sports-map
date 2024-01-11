package pl.edu.pja.sportsmap.dto.review;

import lombok.Builder;

import java.time.LocalDate;
@Builder
public record GetReviewDto(String nickname, LocalDate date, Integer rate, String content, String avatar) {
}
