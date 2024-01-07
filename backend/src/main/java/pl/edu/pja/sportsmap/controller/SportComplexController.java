package pl.edu.pja.sportsmap.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.pja.sportsmap.dto.SportComplexSimpleDto;
import pl.edu.pja.sportsmap.persistence.model.SportComplex;
import pl.edu.pja.sportsmap.service.EventService;
import pl.edu.pja.sportsmap.service.OpeningHoursService;
import pl.edu.pja.sportsmap.service.SportComplexService;

import java.util.List;

@Controller
@RequestMapping("/sport-complexes")
public class SportComplexController {
    private final SportComplexService sportComplexService;
    private final OpeningHoursService openingHoursService;
    private final EventService eventService;

    public SportComplexController(SportComplexService sportComplexService, OpeningHoursService openingHoursService, EventService eventService) {
        this.sportComplexService = sportComplexService;
        this.openingHoursService = openingHoursService;
        this.eventService = eventService;
    }

    @GetMapping
    public ResponseEntity<List<SportComplexSimpleDto>> getAllSportComplexes() {
        List<SportComplexSimpleDto> sportComplexDtos = sportComplexService.getAllSportComplexes()
                .stream()
                .map(this::convertEntityToDto)
                .toList();
        return ResponseEntity.ok(sportComplexDtos);
    }

    private SportComplexSimpleDto convertEntityToDto(SportComplex sportComplex) {
        return SportComplexSimpleDto.builder()
                .id(sportComplex.getId())
                .name(sportComplex.getName())
                .category(sportComplex.getCategory())
                .latitude(sportComplex.getLatitude())
                .longitude(sportComplex.getLongitude())
                .isOpen(openingHoursService.isSportComplexOpenNow(sportComplex))
                .isEventNow(eventService.isEventNow(sportComplex))
                .isEventTomorrow(eventService.isEventTomorrow(sportComplex))
                .build();
    }
}
