package pl.edu.pja.sportsmap.dto.event;

import lombok.Builder;

@Builder
public record EventDurationDto(Integer days, Integer hours, Integer minutes) {
}
