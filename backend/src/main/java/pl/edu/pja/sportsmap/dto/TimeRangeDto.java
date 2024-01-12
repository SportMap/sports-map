package pl.edu.pja.sportsmap.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalTime;

@AllArgsConstructor
@Getter
public class TimeRangeDto {
    private LocalTime openTime;
    private LocalTime closeTime;
}
