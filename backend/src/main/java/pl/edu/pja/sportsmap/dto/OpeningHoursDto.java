package pl.edu.pja.sportsmap.dto;

import lombok.Builder;

@Builder
public record OpeningHoursDto(
        TimeRangeDto monday,
        TimeRangeDto tuesday,
        TimeRangeDto wednesday,
        TimeRangeDto thursday,
        TimeRangeDto friday,
        TimeRangeDto saturday,
        TimeRangeDto sunday
) {
}
