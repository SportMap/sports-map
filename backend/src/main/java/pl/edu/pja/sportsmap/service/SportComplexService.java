package pl.edu.pja.sportsmap.service;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.edu.pja.sportsmap.dto.SportComplexDetailedDto;
import pl.edu.pja.sportsmap.dto.SportComplexSimpleDto;
import pl.edu.pja.sportsmap.exception.NotFoundException;
import pl.edu.pja.sportsmap.persistence.dao.SportComplexPaginationRepository;
import pl.edu.pja.sportsmap.persistence.dao.SportComplexRepository;
import pl.edu.pja.sportsmap.persistence.model.SportComplex;

import java.util.List;
import java.util.Optional;

@Service
public class SportComplexService {
    private final SportComplexRepository sportComplexRepository;
    private final SportComplexPaginationRepository sportComplexPaginationRepository;
    private final OpeningHoursService openingHoursService;
    private final EventService eventService;

    public SportComplexService(SportComplexRepository sportComplexRepository, SportComplexPaginationRepository sportComplexPaginationRepository, OpeningHoursService openingHoursService, EventService eventService) {
        this.sportComplexRepository = sportComplexRepository;
        this.sportComplexPaginationRepository = sportComplexPaginationRepository;
        this.openingHoursService = openingHoursService;
        this.eventService = eventService;
    }

    public List<SportComplex> getAllSportComplexes() {
        return sportComplexRepository.findAll();
    }

    public List<SportComplexSimpleDto> getAllSportComplexesSimpleDto() {
        return sportComplexRepository.findAll()
                .stream()
                .map(this::convertToSimpleDto)
                .toList();
    }

    public List<SportComplexDetailedDto> getAllSportComplexesDetailedDto(int pageNumber, int pageSize) {
        return sportComplexPaginationRepository.findAll(PageRequest.of(pageNumber, pageSize))
                .stream()
                .map(this::convertToDetailedDto)
                .toList();
    }

    public SportComplexDetailedDto getSportComplex(Long id) {
        Optional<SportComplex> sportComplex = sportComplexRepository.findById(id);
        if (sportComplex.isEmpty()) {
            throw new NotFoundException("Sport Complex not found");
        }
        return convertToDetailedDto(sportComplex.get());
    }

    public String getSportComplexNameById(Long sportComplexId){
        Optional<SportComplex> sportComplex = sportComplexRepository.findById(sportComplexId);
        return sportComplex.map(SportComplex::getName).orElse(null);
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

    private SportComplexSimpleDto convertToSimpleDto(SportComplex sportComplex) {
        return SportComplexSimpleDto.builder()
                .id(sportComplex.getId())
                .name(sportComplex.getName())
                .category(sportComplex.getCategory())
                .latitude(sportComplex.getLatitude())
                .longitude(sportComplex.getLongitude())
                .photo(sportComplex.getPhoto())
                .isOpen(openingHoursService.isSportComplexOpenNow(sportComplex))
                .isEventNow(eventService.isEventNow(sportComplex))
                .isEventTomorrow(eventService.isEventTomorrow(sportComplex))
                .build();
    }
}
