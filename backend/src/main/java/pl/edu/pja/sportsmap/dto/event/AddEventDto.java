package pl.edu.pja.sportsmap.dto.event;

import java.time.LocalDateTime;

public record AddEventDto(String photo,
                          String creatorNickname,

                          String name,
                          LocalDateTime startTime,
                          LocalDateTime endTime,
                          String description,
                          Long sportComplexId
                          ) {
}
