package pl.edu.pja.sportsmap.service;

import org.springframework.stereotype.Service;
import pl.edu.pja.sportsmap.persistence.dao.OpeningHoursRepository;
import pl.edu.pja.sportsmap.persistence.model.OpeningHours;
import pl.edu.pja.sportsmap.persistence.model.SportComplex;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class OpeningHoursService {
    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    private final OpeningHoursRepository openingHoursRepository;

    public OpeningHoursService(OpeningHoursRepository openingHoursRepository) {
        this.openingHoursRepository = openingHoursRepository;
    }

    public List<OpeningHours> getOpeningHours(Long complexId) {
        return openingHoursRepository.findBySportComplexId(complexId);
    }

    public boolean isSportComplexOpenNow(SportComplex sportComplex) {
        if (sportComplex.isOpen247()) {
            return true;
        }

        LocalDateTime now = LocalDateTime.now();
        DayOfWeek dayOfWeek = now.getDayOfWeek();

        OpeningHours openingHours = openingHoursRepository
                .getOpeningHoursBySportComplexIdAndAndDayOfWeek(sportComplex.getId(), dayOfWeek);

        if (openingHours == null || openingHours.getOpeningTime() == null || openingHours.getClosingTime() == null) {
            return false;
        }

        return now.isAfter(LocalDateTime.from(openingHours.getOpeningTime().toLocalTime().atDate(LocalDate.now()))) &&
                now.isBefore(LocalDateTime.from(openingHours.getClosingTime().toLocalTime().atDate(LocalDate.now())));
    }
}
