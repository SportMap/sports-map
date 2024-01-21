package pl.edu.pja.sportsmap.dto.review;

import lombok.Builder;

@Builder
public record GetRatesDto(Long sportComplexId, Long total, Long five, Long four, Long three, Long two, Long one, Double medium) {
}
