package pl.edu.pja.sportsmap.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.pja.sportsmap.dto.event.GetSimpleDetailedEventDto;
import pl.edu.pja.sportsmap.dto.event.GetSimpleShortEventDto;
import pl.edu.pja.sportsmap.persistence.model.Event;
import pl.edu.pja.sportsmap.service.EventService;
import pl.edu.pja.sportsmap.service.SportComplexService;
import pl.edu.pja.sportsmap.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;
    private final SportComplexService sportComplexService;
    private final UserService userService;


    public EventController(EventService eventService, SportComplexService sportComplexService, UserService userService) {
        this.eventService = eventService;
        this.sportComplexService = sportComplexService;
        this.userService = userService;
    }

    @GetMapping("/short/{id}")
    public ResponseEntity<List<GetSimpleShortEventDto>> getShortInfoAboutAllAvailableEventsForSportComplex(@PathVariable Long id){
        List<GetSimpleShortEventDto> getSimpleShortEventDtos = eventService.getAllAvailableEventsBySportComplexId(id)
                .stream()
                .map(this::convertEntityToSimpleShortEventDto)
                .toList();

        return ResponseEntity.ok(getSimpleShortEventDtos);
    }

    @GetMapping("/detailed/{id}")
    public ResponseEntity<List<GetSimpleDetailedEventDto>> getDetailedInfoAboutAllAvailableEventsForSportComplex(@PathVariable Long id){
        List<GetSimpleDetailedEventDto> getSimpleDetailedEventDtos = eventService.getAllAvailableEventsBySportComplexId(id)
                .stream()
                .map(this::convertEntityToSimpleDetailedEventDto)
                .toList();

        return ResponseEntity.ok(getSimpleDetailedEventDtos);
    }

    public GetSimpleShortEventDto convertEntityToSimpleShortEventDto(Event event){
        return GetSimpleShortEventDto.builder()
                .photo(event.getPhoto())
                .name(event.getName())
                .sportObjectName(sportComplexService.getSportComplexNameById(event.getSportComplex().getId()))
                .startTime(event.getStartTime())
                .interested_people(event.getInterestedPeople())
                .build();
    }

    public GetSimpleDetailedEventDto convertEntityToSimpleDetailedEventDto(Event event){
        return GetSimpleDetailedEventDto.builder()
                .name(event.getName())
                .photo(event.getPhoto())
                .sportObjectName(sportComplexService.getSportComplexNameById(event.getSportComplex().getId()))
                .startTime(event.getStartTime())
                .endTime(event.getEndTime())
                .interestedPeople(event.getInterestedPeople())
                .creatorNickname(userService.getNicknameById(event.getUser().getId()))
                .creatorAvatar(userService.getAvatarById(event.getUser().getId()))
                .duration(eventService.getEventDurationByEventId(event.getId()))
                .description(event.getDescription())
                .build();
    }



}
