package pl.edu.pja.sportsmap.dto.event;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record GetSimpleShortEventDto(String photo,
                                     String name,
                                     String sportObjectName,
                                     LocalDateTime startTime,
                                     Integer interested_people
) {
}
