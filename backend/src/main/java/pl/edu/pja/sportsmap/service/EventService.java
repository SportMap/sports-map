package pl.edu.pja.sportsmap.service;

import org.springframework.stereotype.Service;
import pl.edu.pja.sportsmap.dto.event.AddEventDto;
import pl.edu.pja.sportsmap.dto.event.EventDurationDto;
import pl.edu.pja.sportsmap.persistence.dao.EventRepository;
import pl.edu.pja.sportsmap.persistence.dao.SportComplexRepository;
import pl.edu.pja.sportsmap.persistence.dao.UserRepository;
import pl.edu.pja.sportsmap.persistence.model.Event;
import pl.edu.pja.sportsmap.persistence.model.Review;
import pl.edu.pja.sportsmap.persistence.model.SportComplex;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class EventService {
    private final EventRepository eventRepository;
    private final UserRepository userRepository;
    private final SportComplexRepository sportComplexRepository;

    public EventService(EventRepository eventRepository, UserRepository userRepository, SportComplexRepository sportComplexRepository) {
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
        this.sportComplexRepository = sportComplexRepository;
    }

    public List<Event> getAllAvailableEventsBySportComplexId(Long id){
        LocalDateTime currentTime = LocalDateTime.now();
        return eventRepository.findAllBySportComplexIdAndEndTimeAfter(id, currentTime);
    }

    public Event addEvent(AddEventDto addEventDto){
        Event event = convertAddEventDtoToEntity(addEventDto);
        return event;
    }

    public Event convertAddEventDtoToEntity(AddEventDto addEventDto){
        return Event.builder()
                .name(addEventDto.name())
                .description(addEventDto.description())
                .sportComplex(sportComplexRepository.findById(addEventDto.sportComplexId()).orElse(null))
                .startTime(addEventDto.startTime())
                .endTime(addEventDto.endTime())
                .interestedPeople(1)
                .photo(addEventDto.photo())
                .user(userRepository.findUserByNickname(addEventDto.creatorNickname()).orElse(null))
                .build();
    }



    public boolean isEventNow(SportComplex sportComplex) {
        return !eventRepository.findCurrentEventsByComplexId(sportComplex.getId()).isEmpty();
    }

    public boolean isEventTomorrow(SportComplex sportComplex) {
        return !eventRepository.findEventsStartingNextDayByComplexId(sportComplex.getId()).isEmpty();
    }

    public EventDurationDto getEventDurationByEventId(Long id){
        LocalDateTime startDate = eventRepository.findById(id).orElseThrow().getStartTime();
        LocalDateTime endDate = eventRepository.findById(id).orElseThrow().getEndTime();
        Duration duration = Duration.between(startDate,endDate);
        Integer days = (int) duration.toDays();
        Integer hours = (int) duration.toHours() % 24;
        Integer minutes = (int) duration.toMinutes() % 60;

        return new EventDurationDto(days,hours,minutes);
    }

}
