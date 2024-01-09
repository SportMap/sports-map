package pl.edu.pja.sportsmap.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.pja.sportsmap.dto.AvailableSportComplexCategoryDto;
import pl.edu.pja.sportsmap.dto.AllSportComplexCategoryDto;
import pl.edu.pja.sportsmap.dto.SportComplexSimpleDto;
import pl.edu.pja.sportsmap.persistence.model.SportComplex;
import pl.edu.pja.sportsmap.persistence.model.SportComplexCategory;
import pl.edu.pja.sportsmap.service.EventService;
import pl.edu.pja.sportsmap.service.OpeningHoursService;
import pl.edu.pja.sportsmap.service.SportComplexCategoryService;
import pl.edu.pja.sportsmap.service.SportComplexService;

import java.util.List;


@Controller
@RequestMapping("/sport-complexes")
public class SportComplexController {
    private final SportComplexService sportComplexService;
    private final OpeningHoursService openingHoursService;
    private final EventService eventService;
    private final SportComplexCategoryService sportComplexCategoryService;

    public SportComplexController(SportComplexService sportComplexService, OpeningHoursService openingHoursService, EventService eventService, SportComplexCategoryService sportComplexCategoryService) {
        this.sportComplexService = sportComplexService;
        this.openingHoursService = openingHoursService;
        this.eventService = eventService;
        this.sportComplexCategoryService = sportComplexCategoryService;
    }

    @GetMapping
    public ResponseEntity<List<SportComplexSimpleDto>> getAllSportComplexes() {
        List<SportComplexSimpleDto> sportComplexDtos = sportComplexService.getAllSportComplexes()
                .stream()
                .map(this::convertEntityToDto)
                .toList();
        return ResponseEntity.ok(sportComplexDtos);
    }


    @GetMapping("/allCategories")
    public ResponseEntity<List<AllSportComplexCategoryDto>> getAllSportCategories() {
        List<SportComplexCategory> sportCategories = sportComplexCategoryService.getAllSportComplexCategories();
        List<AllSportComplexCategoryDto> sportCategoryDtos = sportCategories.stream()
                .map(AllSportComplexCategoryDto::new)
                .toList();
        return ResponseEntity.ok(sportCategoryDtos);
    }


    @GetMapping("/availableCategoriesAtThisMoment")
    public ResponseEntity<List<AvailableSportComplexCategoryDto>> getAvailableCategoriesAtThisMoment() {
        List<SportComplexCategory> availableCategories = sportComplexCategoryService.getAvailableComplexCategories();

        List<AvailableSportComplexCategoryDto> sportCategoryDtos = sportComplexCategoryService.mapToDtoIfOpen(availableCategories);

        return ResponseEntity.ok(sportCategoryDtos);
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
