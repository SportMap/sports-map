package pl.edu.pja.sportsmap.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pja.sportsmap.dto.AllSportComplexCategoryDto;
import pl.edu.pja.sportsmap.dto.AvailableSportComplexCategoryDto;
import pl.edu.pja.sportsmap.dto.SportComplexDetailedDto;
import pl.edu.pja.sportsmap.dto.SportComplexSimpleDto;
import pl.edu.pja.sportsmap.persistence.model.SportComplexCategory;
import pl.edu.pja.sportsmap.service.SportComplexCategoryService;
import pl.edu.pja.sportsmap.service.SportComplexService;

import java.util.List;


@RestController
@RequestMapping("/sport-complexes")
public class SportComplexController {
    private final SportComplexService sportComplexService;
    private final SportComplexCategoryService sportComplexCategoryService;

    public SportComplexController(SportComplexService sportComplexService, SportComplexCategoryService sportComplexCategoryService) {
        this.sportComplexService = sportComplexService;
        this.sportComplexCategoryService = sportComplexCategoryService;
    }

    @GetMapping
    public ResponseEntity<List<SportComplexSimpleDto>> getAllSportComplexes() {
        return ResponseEntity.ok(sportComplexService.getAllSportComplexesSimpleDto());
    }

    @GetMapping("admin")
    public ResponseEntity<List<SportComplexDetailedDto>> getAllDetailedSportComplexes(@RequestParam int pageNumber, @RequestParam int pageSize) {
        return ResponseEntity.ok(sportComplexService.getAllSportComplexesDetailedDto(pageNumber, pageSize));
    }

    @GetMapping("{id}")
    public ResponseEntity<SportComplexDetailedDto> getSportComplex(@PathVariable Long id) {
        return ResponseEntity.ok(sportComplexService.getSportComplex(id));
    }

    @GetMapping("/categories")
    public ResponseEntity<List<AllSportComplexCategoryDto>> getAllSportCategories() {
        List<SportComplexCategory> sportCategories = sportComplexCategoryService.getAllSportComplexCategories();
        List<AllSportComplexCategoryDto> sportCategoryDtos = sportCategories.stream()
                .map(AllSportComplexCategoryDto::new)
                .toList();
        return ResponseEntity.ok(sportCategoryDtos);
    }


    @GetMapping("/categories/available-now")
    public ResponseEntity<List<AvailableSportComplexCategoryDto>> getAvailableCategoriesAtThisMoment() {
        List<SportComplexCategory> availableCategories = sportComplexCategoryService.getAvailableComplexCategories();

        List<AvailableSportComplexCategoryDto> sportCategoryDtos = sportComplexCategoryService.mapToDtoIfOpen(availableCategories);

        return ResponseEntity.ok(sportCategoryDtos);
    }
}
