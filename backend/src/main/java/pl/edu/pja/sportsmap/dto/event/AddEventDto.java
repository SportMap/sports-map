package pl.edu.pja.sportsmap.dto.event;

import java.time.LocalDateTime;

public record AddEventDto(
                          String photo,
                          Long creatorId,
                          String name,
                          LocalDateTime startTime,
                          LocalDateTime endTime,
                          String description,
                          Long sportComplexId
) {
}
