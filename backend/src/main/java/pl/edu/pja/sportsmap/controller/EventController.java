package pl.edu.pja.sportsmap.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pja.sportsmap.dto.event.*;
import pl.edu.pja.sportsmap.dto.event.request.JoinEventRequestDto;
import pl.edu.pja.sportsmap.persistence.model.Event;
import pl.edu.pja.sportsmap.service.EventService;
import pl.edu.pja.sportsmap.service.SportComplexService;
import pl.edu.pja.sportsmap.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/events")
@Tag(name = "Events API", description = "Endpointy dotyczące wydarzeń")
public class EventController {

    private final EventService eventService;
    private final SportComplexService sportComplexService;
    private final UserService userService;


    public EventController(EventService eventService, SportComplexService sportComplexService, UserService userService) {
        this.eventService = eventService;
        this.sportComplexService = sportComplexService;
        this.userService = userService;
    }

    @Operation(
            summary = "Return basic information",
            description = "Returns basic information about an events for the given SportComplexId. (only the events that are just in progress or will begin in the future, past events are omitted ")
    @GetMapping("/{id}")
    public ResponseEntity<List<GetSimpleShortEventDto>> getShortInfoAboutAllAvailableEventsForSportComplex(@PathVariable Long id){
        List<GetSimpleShortEventDto> getSimpleShortEventDtos = eventService.getAllAvailableEventsBySportComplexId(id)
                .stream()
                .map(eventService::convertEntityToSimpleShortEventDto)
                .toList();

        return ResponseEntity.ok(getSimpleShortEventDtos);
    }
    @Operation(
            summary = "Return detailed information",
            description = "Returns detailed information about an events for the given SportComplexId. (only the events that are just in progress or will begin in the future, past events are omitted ")
    @GetMapping("/detailed/{id}")
    public ResponseEntity<List<GetSimpleDetailedEventDto>> getDetailedInfoAboutAllAvailableEventsForSportComplex(@PathVariable Long id){
        List<GetSimpleDetailedEventDto> getSimpleDetailedEventDtos = eventService.getAllAvailableEventsBySportComplexId(id)
                .stream()
                .map(eventService::convertEntityToSimpleDetailedEventDto)
                .toList();

        return ResponseEntity.ok(getSimpleDetailedEventDtos);
    }

    @Operation(
            summary = "Add new event",
            description = "Body - sportComplexId and CreatorId must exists in database")
    @PostMapping()
    public ResponseEntity<Event> addEvent(@RequestBody AddEventDto addEventDto){
        Event event = eventService.addEvent(addEventDto);
        return ResponseEntity.ok(event);
    }

    @Operation(
            summary = "Join to event",
            description = "Body - eventId and userId must exists in database." +
                    " User cannot join the same event twice - throw new IllegalStateException(\"User is already joined to the event\");")
    @PostMapping("/join")
    public ResponseEntity<JoinEventDto> joinToEvent(@RequestBody JoinEventRequestDto joinEventRequestDto){
        JoinEventDto joinEventDto = eventService.joinEvent(joinEventRequestDto.UserId(), joinEventRequestDto.EventId());

        return ResponseEntity.ok(joinEventDto);
    }

//    @PatchMapping("/UserId")
//    public ResponseEntity<Event> updateEvent(@PathVariable Long UserId, @RequestBody UpdateEventDto updateEventDto){
//        Event updatedEvent = eventService.updateEvent(UserId, updateEventDto);
//        if (updatedEvent != null){
//            return ResponseEntity.ok(updatedEvent);
//        }else {
//            return ResponseEntity.notFound().build();
//        }
//    }

    @Operation(
            summary = "Returns basic information about events of interest to the user",
            description = "Returns basic information about an events for the given UserId. (only the events that are just in progress or will begin in the future, past events are omitted ")
    @GetMapping("/interested/{id}")
    public ResponseEntity<List<GetSimpleShortEventDto>> getShortInfoAboutAllInterestedEventsForUser(@PathVariable Long id){
        List<GetSimpleShortEventDto> getSimpleShortEventDtos = eventService.getAllAvailableInterestedEventsByUserId(id)
                .stream()
                .map(eventService::convertEntityToSimpleShortEventDto)
                .toList();

        return ResponseEntity.ok(getSimpleShortEventDtos);
    }

    @Operation(
            summary = "Returns detailed information about events of interest to the user",
            description = "Returns detailed information about an events for the given UserId. (only the events that are just in progress or will begin in the future, past events are omitted ")
    @GetMapping("/detailed/interested/{id}")
    public ResponseEntity<List<GetSimpleDetailedEventDto>> getDetailedInfoAboutAllInterestedEventsForUser(@PathVariable Long id){
        List<GetSimpleDetailedEventDto> getSimpleDetailedEventDtos = eventService.getAllAvailableInterestedEventsByUserId(id)
                .stream()
                .map(eventService::convertEntityToSimpleDetailedEventDto)
                .toList();

        return ResponseEntity.ok(getSimpleDetailedEventDtos);
    }
    @Operation(
            summary = "Returns basic information about events created by user",
            description = "Returns basic information about an created events for the given UserId. (only the events that are just in progress or will begin in the future, past events are omitted ")
    @GetMapping("/created/{id}")
    public ResponseEntity<List<GetSimpleShortEventDto>> getShortInfoAboutAllCreatedEventsByUser(@PathVariable Long id){
        List<GetSimpleShortEventDto> getSimpleShortEventDtos = eventService.getAllAvailableCreatedEventsByUserId(id)
                .stream()
                .map(eventService::convertEntityToSimpleShortEventDto)
                .toList();
        return ResponseEntity.ok(getSimpleShortEventDtos);
    }
    @Operation(
            summary = "Returns detailed information about events created by user",
            description = "Returns detailed information about an created events for the given UserId. (only the events that are just in progress or will begin in the future, past events are omitted ")
    @GetMapping("/detailed/created/{id}")
    public ResponseEntity<List<GetSimpleDetailedEventDto>> getDetailedInfoAboutAllCreatedEventsByUser(@PathVariable Long id){
        List<GetSimpleDetailedEventDto> getSimpleDetailedEventDtos = eventService.getAllAvailableCreatedEventsByUserId(id)
                .stream()
                .map(eventService::convertEntityToSimpleDetailedEventDto)
                .toList();

        return ResponseEntity.ok(getSimpleDetailedEventDtos);
    }





}
