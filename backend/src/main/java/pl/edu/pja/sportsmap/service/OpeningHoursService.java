package pl.edu.pja.sportsmap.service;

import org.springframework.stereotype.Service;
import pl.edu.pja.sportsmap.dto.OpeningHoursDto;
import pl.edu.pja.sportsmap.dto.TimeRangeDto;
import pl.edu.pja.sportsmap.persistence.dao.OpeningHoursRepository;
import pl.edu.pja.sportsmap.persistence.model.OpeningHours;
import pl.edu.pja.sportsmap.persistence.model.SportComplex;
import pl.edu.pja.sportsmap.persistence.model.SportComplexCategory;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OpeningHoursService {
    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    private final OpeningHoursRepository openingHoursRepository;

    public OpeningHoursService(OpeningHoursRepository openingHoursRepository) {
        this.openingHoursRepository = openingHoursRepository;
    }

    public OpeningHoursDto getOpeningHours(Long complexId) {
        List<OpeningHours> openingHoursRepositoryBySportComplexId = openingHoursRepository.findBySportComplexId(complexId);
        return convertToDto(openingHoursRepositoryBySportComplexId);
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

    public boolean isAnySportComplexOpenNow(List<SportComplex> sportComplexes, SportComplexCategory category) {
        return sportComplexes.stream()
                .filter(sportComplex -> sportComplex.getCategory() == category)
                .anyMatch(this::isSportComplexOpenNow);
    }

    public OpeningHoursDto convertToDto(List<OpeningHours> openingHoursList) {
        Map<DayOfWeek, TimeRangeDto> groupedByDay = openingHoursList.stream()
                .collect(Collectors.toMap(
                        OpeningHours::getDayOfWeek,
                        oh -> new TimeRangeDto(oh.getOpeningTime().toLocalTime(), oh.getClosingTime().toLocalTime()),
                        (existing, replacement) -> existing
                ));

        return OpeningHoursDto.builder()
                .monday(groupedByDay.get(DayOfWeek.MONDAY))
                .tuesday(groupedByDay.get(DayOfWeek.TUESDAY))
                .wednesday(groupedByDay.get(DayOfWeek.WEDNESDAY))
                .thursday(groupedByDay.get(DayOfWeek.THURSDAY))
                .friday(groupedByDay.get(DayOfWeek.FRIDAY))
                .saturday(groupedByDay.get(DayOfWeek.SATURDAY))
                .sunday(groupedByDay.get(DayOfWeek.SUNDAY))
                .build();
    }
}
