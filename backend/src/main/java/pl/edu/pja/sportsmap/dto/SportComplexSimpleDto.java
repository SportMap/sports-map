package pl.edu.pja.sportsmap.dto;

import lombok.Builder;
import pl.edu.pja.sportsmap.persistence.model.SportComplexCategory;

@Builder
public record SportComplexSimpleDto(
        Long id,
        String name,
        SportComplexCategory category,
        Double latitude,
        Double longitude,
        boolean isOpen,
        boolean isEventNow,
        boolean isEventTomorrow
) {}

