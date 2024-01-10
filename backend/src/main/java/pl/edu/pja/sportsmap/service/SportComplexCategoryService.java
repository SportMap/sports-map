package pl.edu.pja.sportsmap.service;

import org.springframework.stereotype.Service;
import pl.edu.pja.sportsmap.dto.AvailableSportComplexCategoryDto;
import pl.edu.pja.sportsmap.persistence.model.SportComplex;
import pl.edu.pja.sportsmap.persistence.model.SportComplexCategory;

import java.util.Arrays;
import java.util.List;

@Service
public class SportComplexCategoryService {

    private final List<SportComplexCategory> categories = Arrays.asList(SportComplexCategory.values());
    private final SportComplexService sportComplexService;
    private final OpeningHoursService openingHoursService;


    public SportComplexCategoryService(SportComplexService sportComplexService, OpeningHoursService openingHoursService) {
        this.sportComplexService = sportComplexService;
        this.openingHoursService = openingHoursService;
    }

    public List<SportComplexCategory> getAllSportComplexCategories() {
        return categories;
    }

    public List<SportComplexCategory> getAvailableComplexCategories(){

        return categories;
    }

    public List<AvailableSportComplexCategoryDto> mapToDtoIfOpen(List<SportComplexCategory> categories) {
        List<SportComplex> allSportComplexes = sportComplexService.getAllSportComplexes();

        List<SportComplexCategory> availableCategories = categories.stream()
                .filter(category -> openingHoursService.isAnySportComplexOpenNow(allSportComplexes, category))
                .toList();

        return availableCategories.stream()
                .map(AvailableSportComplexCategoryDto::new)
                .toList();
    }


}
