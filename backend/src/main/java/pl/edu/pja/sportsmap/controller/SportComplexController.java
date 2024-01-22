package pl.edu.pja.sportsmap.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.edu.pja.sportsmap.dto.*;
import pl.edu.pja.sportsmap.persistence.model.SportComplex;
import pl.edu.pja.sportsmap.persistence.model.SportComplexCategory;
import pl.edu.pja.sportsmap.service.SportComplexCategoryService;
import pl.edu.pja.sportsmap.service.SportComplexService;

import java.net.URI;
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
    public ResponseEntity<List<SportComplexSimpleDto>> getAllApprovedSportComplexes() {
        return ResponseEntity.ok(sportComplexService.getApprovedSportComplexesSimpleDto());
    }

    @GetMapping("admin")
    public ResponseEntity<Page<SportComplexDetailedDto>> getApprovedDetailedSportComplexes(@RequestParam int pageNumber, @RequestParam int pageSize) {
        return ResponseEntity.ok(sportComplexService.getApprovedSportComplexesDetailedDto(pageNumber, pageSize));
    }

    @GetMapping("admin/awaiting-approval")
    public ResponseEntity<Page<SportComplexDetailedDto>> getAwaitingApprovalDetailedSportComplexes(@RequestParam int pageNumber, @RequestParam int pageSize) {
        return ResponseEntity.ok(sportComplexService.getAwaitingApprovalSportComplexesDetailedDto(pageNumber, pageSize));
    }

    @PatchMapping("admin/approve/{id}")
    public ResponseEntity<Void> getAwaitingApprovalDetailedSportComplexes(@PathVariable Long id) {
        sportComplexService.approveSportComplex(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<SportComplexDetailedDto> getSportComplex(@PathVariable Long id) {
        return ResponseEntity.ok(sportComplexService.getSportComplex(id));
    }

    @PostMapping()
    public ResponseEntity<SportComplexDetailedDto> getSportComplex(@RequestBody AddSportComplexDto newSportComplex) {
        SportComplex sportComplex = sportComplexService.createSportComplex(newSportComplex);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(sportComplex.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @Operation(summary = "side panel - returns a list of all categories")
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
            description = "Returns only categories in which any sportsComplex is currently open. (It's 16:00 and any pool is open - the swimming category will be available. It is 23:00 and all pools are closed, the swimming category will be hidden)"
    )
    @GetMapping("/categories/available-now")
    public ResponseEntity<List<AvailableSportComplexCategoryDto>> getAvailableCategoriesAtThisMoment() {
        List<SportComplexCategory> availableCategories = sportComplexCategoryService.getAvailableComplexCategories();

        List<AvailableSportComplexCategoryDto> sportCategoryDtos = sportComplexCategoryService.mapToDtoIfOpen(availableCategories);

        return ResponseEntity.ok(sportCategoryDtos);
    }
}
