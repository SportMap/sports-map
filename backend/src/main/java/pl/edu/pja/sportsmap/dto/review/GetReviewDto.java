package pl.edu.pja.sportsmap.dto.review;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;

import java.time.LocalDate;
@Builder
public record GetReviewDto(
        String nickname,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
        LocalDate date,
        Integer rate,
        String content,
        String avatar
) {
}
