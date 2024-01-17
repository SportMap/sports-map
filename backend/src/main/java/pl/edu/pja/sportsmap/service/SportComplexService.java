package pl.edu.pja.sportsmap.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.edu.pja.sportsmap.dto.SportComplexDetailedDto;
import pl.edu.pja.sportsmap.dto.SportComplexSimpleDto;
import pl.edu.pja.sportsmap.exception.NotFoundException;
import pl.edu.pja.sportsmap.persistence.dao.EventRepository;
import pl.edu.pja.sportsmap.persistence.dao.SportComplexPaginationRepository;
import pl.edu.pja.sportsmap.persistence.dao.SportComplexRepository;
import pl.edu.pja.sportsmap.persistence.model.Address;
import pl.edu.pja.sportsmap.persistence.model.SportComplex;

import java.util.List;
import java.util.Optional;

@Service
public class SportComplexService {
    private final SportComplexRepository sportComplexRepository;
    private final SportComplexPaginationRepository sportComplexPaginationRepository;
    private final OpeningHoursService openingHoursService;
    private final EventRepository eventRepository;

    public SportComplexService(SportComplexRepository sportComplexRepository, SportComplexPaginationRepository sportComplexPaginationRepository, OpeningHoursService openingHoursService, EventRepository eventRepository) {
        this.sportComplexRepository = sportComplexRepository;
        this.sportComplexPaginationRepository = sportComplexPaginationRepository;
        this.openingHoursService = openingHoursService;
        this.eventRepository = eventRepository;
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

    public Page<SportComplexDetailedDto> getAllSportComplexesDetailedDto(int pageNumber, int pageSize) {
        PageRequest pageable = PageRequest.of(pageNumber, pageSize);
        List<SportComplexDetailedDto> content = sportComplexPaginationRepository.findAll(pageable)
                .stream()
                .map(this::convertToDetailedDto)
                .toList();
        long count = sportComplexRepository.count();
        return new PageImpl<>(content, PageRequest.of(pageNumber, pageSize), count);
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

    public Address getSportComplexAddressById(Long sportComplexId) {
        Optional<SportComplex> sportComplex = sportComplexRepository.findById(sportComplexId);
        return sportComplex.map(SportComplex::getAddress).orElse(null);

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
                .isEventNow(isEventNow(sportComplex))
                .isEventTomorrow(isEventTomorrow(sportComplex))
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
                .isEventNow(isEventNow(sportComplex))
                .isEventTomorrow(isEventTomorrow(sportComplex))
                .build();
    }

    public boolean isEventNow(SportComplex sportComplex) {
        return !eventRepository.findCurrentEventsByComplexId(sportComplex.getId()).isEmpty();
    }

    public boolean isEventTomorrow(SportComplex sportComplex) {
        return !eventRepository.findEventsStartingNextDayByComplexId(sportComplex.getId()).isEmpty();
    }
}
