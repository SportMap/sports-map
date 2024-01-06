package pl.edu.pja.sportsmap.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.edu.pja.sportsmap.persistence.dao.OpeningHoursRepository;
import pl.edu.pja.sportsmap.persistence.model.OpeningHours;
import pl.edu.pja.sportsmap.persistence.model.SportComplex;

import java.sql.Time;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static pl.edu.pja.sportsmap.service.OpeningHoursService.formatter;

@ExtendWith(MockitoExtension.class)
class OpeningHoursServiceTest {
    @Mock
    OpeningHoursRepository openingHoursRepository;
    @InjectMocks
    OpeningHoursService openingHoursService;

    @Test
    void isSportComplexOpenShouldReturnTrueWhenHoursAreInGivenTimeFrame() {
        // given
        Time openingTime = Time.valueOf(formatter.format(LocalTime.now().minusSeconds(5)));
        Time closingTime = Time.valueOf(formatter.format(LocalTime.now().plusSeconds(5)));
        OpeningHours openingHours = new OpeningHours();
        openingHours.setOpeningTime(openingTime);
        openingHours.setClosingTime(closingTime);

        when(openingHoursRepository.getOpeningHoursBySportComplexIdAndAndDayOfWeek(any(), any())).thenReturn(openingHours);
        // when
        boolean sportComplexOpenNow = openingHoursService.isSportComplexOpenNow(new SportComplex());
        // then
        assertTrue(sportComplexOpenNow);
    }

    @Test
    void isSportComplexOpenShouldReturnFalseWhenHoursAreInGivenTimeFrame() {
        // given
        Time openingTime = Time.valueOf(formatter.format(LocalTime.now().plusSeconds(5)));
        Time closingTime = Time.valueOf(formatter.format(LocalTime.now().plusSeconds(10)));
        OpeningHours openingHours = new OpeningHours();
        openingHours.setOpeningTime(openingTime);
        openingHours.setClosingTime(closingTime);
        when(openingHoursRepository.getOpeningHoursBySportComplexIdAndAndDayOfWeek(any(), any())).thenReturn(openingHours);
        // when
        boolean sportComplexOpenNow = openingHoursService.isSportComplexOpenNow(new SportComplex());
        // then
        assertFalse(sportComplexOpenNow);
    }
}