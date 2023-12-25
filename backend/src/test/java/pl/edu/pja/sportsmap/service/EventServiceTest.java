package pl.edu.pja.sportsmap.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.edu.pja.sportsmap.persistence.dao.EventRepository;
import pl.edu.pja.sportsmap.persistence.model.Event;
import pl.edu.pja.sportsmap.persistence.model.SportComplex;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EventServiceTest {
    @Mock
    private EventRepository eventRepository;
    @InjectMocks
    private EventService eventService;

    @Test
    void isEventShouldReturnTrue() {
        // given
        when(eventRepository.findCurrentEventsByComplexId(any())).thenReturn(List.of(new Event()));
        // when
        boolean eventNow = eventService.isEventNow(new SportComplex());
        // then
        assertTrue(eventNow);
    }

    @Test
    void isEventShouldReturnFalse() {
        // given
        when(eventRepository.findCurrentEventsByComplexId(any())).thenReturn(List.of());
        // when
        boolean eventNow = eventService.isEventNow(new SportComplex());
        // then
        assertFalse(eventNow);
    }

    @Test
    void isEventTomorrowShouldReturnTrue() {
        // given
        when(eventRepository.findEventsStartingNextDayByComplexId(any())).thenReturn(List.of(new Event()));
        // when
        boolean eventTomorrow = eventService.isEventTomorrow(new SportComplex());
        // then
        assertTrue(eventTomorrow);
    }

    @Test
    void isEventTomorrowShouldReturnFalse() {
        // given
        when(eventRepository.findEventsStartingNextDayByComplexId(any())).thenReturn(List.of());
        // when
        boolean eventTomorrow = eventService.isEventTomorrow(new SportComplex());
        // then
        assertFalse(eventTomorrow);
    }
}