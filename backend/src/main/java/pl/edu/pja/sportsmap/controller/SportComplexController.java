package pl.edu.pja.sportsmap.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.pja.sportsmap.dto.AllSportComplexCategoryDto;
import pl.edu.pja.sportsmap.dto.AvailableSportComplexCategoryDto;
import pl.edu.pja.sportsmap.dto.SportComplexDetailedDto;
import pl.edu.pja.sportsmap.dto.SportComplexSimpleDto;
import pl.edu.pja.sportsmap.exception.NotFoundException;
import pl.edu.pja.sportsmap.persistence.model.SportComplex;
import pl.edu.pja.sportsmap.persistence.model.SportComplexCategory;
import pl.edu.pja.sportsmap.service.EventService;
import pl.edu.pja.sportsmap.service.OpeningHoursService;
import pl.edu.pja.sportsmap.service.SportComplexCategoryService;
import pl.edu.pja.sportsmap.service.SportComplexService;

import java.util.List;
import java.util.Optional;


@RestController
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

    @GetMapping("{id}")
    public ResponseEntity<SportComplexDetailedDto> getSportComplex(@PathVariable Long id) {
        Optional<SportComplex> sportComplex = sportComplexService.getSportComplex(id);
        if (sportComplex.isEmpty()) {
            throw new NotFoundException("Sport Complex not found");
        }
        return ResponseEntity.ok(convertToDetailedDto(sportComplex.get()));
    }

    @Operation(
            summary = "side panel - returns a list of all categories")
    @GetMapping("/categories")
    public ResponseEntity<List<AllSportComplexCategoryDto>> getAllSportCategories() {
        List<SportComplexCategory> sportCategories = sportComplexCategoryService.getAllSportComplexCategories();
        List<AllSportComplexCategoryDto> sportCategoryDtos = sportCategories.stream()
                .map(AllSportComplexCategoryDto::new)
                .toList();
        return ResponseEntity.ok(sportCategoryDtos);
    }

    @Operation(
            summary = "side panel - returns a list of available categories",
            description = "Returns only categories in which any sportsComplex is currently open. (It's 16:00 and any pool is open - the swimming category will be available. It is 23:00 and all pools are closed, the swimming category will be hidden)")
    @GetMapping("/categories/available-now")
    public ResponseEntity<List<AvailableSportComplexCategoryDto>> getAvailableCategoriesAtThisMoment() {
        List<SportComplexCategory> availableCategories = sportComplexCategoryService.getAvailableComplexCategories();

        List<AvailableSportComplexCategoryDto> sportCategoryDtos = sportComplexCategoryService.mapToDtoIfOpen(availableCategories);

        return ResponseEntity.ok(sportCategoryDtos);
    }

    private SportComplexDetailedDto convertToDetailedDto(SportComplex sportComplex) {
        return SportComplexDetailedDto.builder()
                .address(sportComplex.getAddress())
                .category(sportComplex.getCategory())
                .phoneNumber(sportComplex.getPhoneNumber())
                .name(sportComplex.getName())
                .website(sportComplex.getWebsite())
                .surface(sportComplex.getSurface())
                .photo(sportComplex.getPhoto())
                .isOpen(openingHoursService.isSportComplexOpenNow(sportComplex))
                .isEventNow(eventService.isEventNow(sportComplex))
                .isEventTomorrow(eventService.isEventTomorrow(sportComplex))
                .isOpen247(sportComplex.isOpen247())
                .openingHours(openingHoursService.getOpeningHours(sportComplex.getId()))
                .build();
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
