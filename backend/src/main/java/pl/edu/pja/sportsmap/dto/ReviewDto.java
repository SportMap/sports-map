package pl.edu.pja.sportsmap.dto;

import lombok.Builder;

import java.time.LocalDate;
@Builder
public record ReviewDto(String nickname, LocalDate date, Integer rate, String content, String avatar) {
}
