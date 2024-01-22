package pl.edu.pja.sportsmap.dto;

import lombok.Builder;
import pl.edu.pja.sportsmap.persistence.model.SportComplexCategory;
import pl.edu.pja.sportsmap.persistence.model.SportComplexSurface;

@Builder
public record AddSportComplexDto(
        String name,
        String description,
        SportComplexCategory category,
        SportComplexSurface surface,
        String website,
        String phoneNumber,
        AddressDto address,
        Double latitude,
        Double longitude,
        String photo,
        Boolean isOpen247,
        OpeningHoursDto openingHours
) {
}
