package pl.edu.pja.sportsmap.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.pja.sportsmap.dto.AddSportComplexDto;
import pl.edu.pja.sportsmap.dto.SportComplexDetailedDto;
import pl.edu.pja.sportsmap.dto.SportComplexSimpleDto;
import pl.edu.pja.sportsmap.exception.NotFoundException;
import pl.edu.pja.sportsmap.persistence.dao.EventRepository;
import pl.edu.pja.sportsmap.persistence.dao.SportComplexPaginationRepository;
import pl.edu.pja.sportsmap.persistence.dao.SportComplexRepository;
import pl.edu.pja.sportsmap.persistence.model.Address;
import pl.edu.pja.sportsmap.persistence.model.SportComplex;
import pl.edu.pja.sportsmap.persistence.model.SportComplexStatus;

import java.util.List;
import java.util.Optional;

@Service
public class SportComplexService {
    private final SportComplexRepository sportComplexRepository;
    private final SportComplexPaginationRepository sportComplexPaginationRepository;
    private final OpeningHoursService openingHoursService;
    private final EventRepository eventRepository;
    private final AddressService addressService;

    public SportComplexService(SportComplexRepository sportComplexRepository, SportComplexPaginationRepository sportComplexPaginationRepository, OpeningHoursService openingHoursService, EventRepository eventRepository, AddressService addressService) {
        this.sportComplexRepository = sportComplexRepository;
        this.sportComplexPaginationRepository = sportComplexPaginationRepository;
        this.openingHoursService = openingHoursService;
        this.eventRepository = eventRepository;
        this.addressService = addressService;
    }

    public List<SportComplex> getAllSportComplexes() {
        return sportComplexRepository.findAll();
    }

    public List<SportComplexSimpleDto> getApprovedSportComplexesSimpleDto() {
        return sportComplexRepository.findAllByStatus(SportComplexStatus.APPROVED)
                .stream()
                .map(this::convertToSimpleDto)
                .toList();
    }

    public Page<SportComplexDetailedDto> getApprovedSportComplexesDetailedDto(int pageNumber, int pageSize) {
        PageRequest pageable = PageRequest.of(pageNumber, pageSize);
        List<SportComplexDetailedDto> content = sportComplexPaginationRepository
                .findAllByStatus(SportComplexStatus.APPROVED, pageable)
                .stream()
                .map(this::convertToDetailedDto)
                .toList();
        return new PageImpl<>(content, PageRequest.of(pageNumber, pageSize), content.size());
    }

    public Page<SportComplexDetailedDto> getAwaitingApprovalSportComplexesDetailedDto(int pageNumber, int pageSize) {
        PageRequest pageable = PageRequest.of(pageNumber, pageSize);
        List<SportComplexDetailedDto> content = sportComplexPaginationRepository
                .findAllByStatus(SportComplexStatus.AWAITING_APPROVAL, pageable)
                .stream()
                .map(this::convertToDetailedDto)
                .toList();
        return new PageImpl<>(content, PageRequest.of(pageNumber, pageSize), content.size());
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

    public void approveSportComplex(Long id) {
        SportComplex sportComplex = sportComplexRepository.getReferenceById(id);
        sportComplex.setStatus(SportComplexStatus.APPROVED);
        sportComplexRepository.save(sportComplex);
    }

    @Transactional
    public SportComplex createSportComplex(AddSportComplexDto sportComplexDto) {
        SportComplex entity = convertDtoToEntity(sportComplexDto);
        entity.setStatus(SportComplexStatus.AWAITING_APPROVAL);
        SportComplex sportComplex = sportComplexRepository.saveAndFlush(entity);
        openingHoursService.addOpeningHours(sportComplexDto.openingHours(), sportComplex);
        return sportComplex;
    }

    public boolean isEventNow(SportComplex sportComplex) {
        return !eventRepository.findCurrentEventsByComplexId(sportComplex.getId()).isEmpty();
    }

    public boolean isEventTomorrow(SportComplex sportComplex) {
        return !eventRepository.findEventsStartingNextDayByComplexId(sportComplex.getId()).isEmpty();
    }

    public Address getSportComplexAddressById(Long sportComplexId) {
        Optional<SportComplex> sportComplex = sportComplexRepository.findById(sportComplexId);
        return sportComplex.map(SportComplex::getAddress).orElse(null);

    }
    private SportComplexDetailedDto convertToDetailedDto(SportComplex sportComplex) {
        return SportComplexDetailedDto.builder()
                .id(sportComplex.getId())
                .address(sportComplex.getAddress())
                .description(sportComplex.getDescription())
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

    private SportComplex convertDtoToEntity(AddSportComplexDto sportComplexDto) {
        return SportComplex.builder()
                .name(sportComplexDto.name())
                .description(sportComplexDto.description())
                .category(sportComplexDto.category())
                .longitude(sportComplexDto.longitude())
                .latitude(sportComplexDto.latitude())
                .website(sportComplexDto.website())
                .isOpen247(sportComplexDto.isOpen247())
                .photo(sportComplexDto.photo())
                .address(addressService.addAddress(sportComplexDto.address()))
                .phoneNumber(sportComplexDto.phoneNumber())
                .surface(sportComplexDto.surface())
                .build();
    }
}
