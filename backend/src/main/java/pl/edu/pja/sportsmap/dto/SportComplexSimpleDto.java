package pl.edu.pja.sportsmap.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import pl.edu.pja.sportsmap.persistence.model.SportComplexCategory;

@Getter
@Builder
@AllArgsConstructor
public class SportComplexSimpleDto {
    private Long id;
    private SportComplexCategory category;
    private Double latitude;
    private Double longitude;
    private boolean isOpen;
    private boolean isEventNow;
    private boolean isEventTomorrow;
}
