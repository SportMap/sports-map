package pl.edu.pja.sportsmap.dto;

import lombok.Builder;
import pl.edu.pja.sportsmap.persistence.model.Address;
import pl.edu.pja.sportsmap.persistence.model.SportComplexCategory;
import pl.edu.pja.sportsmap.persistence.model.SportComplexSurface;

@Builder
public record SportComplexDetailedDto(
        String name,
        SportComplexCategory category,
        SportComplexSurface surface,
        String website,
        String phoneNumber,
        Address address,
        String photo,
        boolean isOpen,
        boolean isEventNow,
        boolean isEventTomorrow,
        boolean isOpen247,
        OpeningHoursDto openingHours

) {
}
