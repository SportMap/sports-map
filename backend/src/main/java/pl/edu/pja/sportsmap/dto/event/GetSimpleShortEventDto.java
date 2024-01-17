package pl.edu.pja.sportsmap.dto.event;

import lombok.Builder;
import pl.edu.pja.sportsmap.persistence.model.Address;

import java.time.LocalDateTime;

@Builder
public record GetSimpleShortEventDto(String photo,
                                     String name,
                                     String sportObjectName,
                                     Address sportObjectAddress,
                                     LocalDateTime startTime,
                                     Integer interested_people
) {
}
