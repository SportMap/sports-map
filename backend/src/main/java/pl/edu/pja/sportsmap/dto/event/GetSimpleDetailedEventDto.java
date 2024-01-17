package pl.edu.pja.sportsmap.dto.event;

import lombok.Builder;
import pl.edu.pja.sportsmap.persistence.model.Address;

import java.time.LocalDateTime;

@Builder
public record GetSimpleDetailedEventDto(String name,
                                        String photo,
                                        String sportObjectName,
                                        Address sportObjectAddress,
                                        LocalDateTime startTime,
                                        LocalDateTime endTime,
                                        Integer interestedPeople,
                                        String creatorNickname,
                                        String creatorAvatar,
                                        EventDurationDto duration,
                                        String description
                                     ) {
}
