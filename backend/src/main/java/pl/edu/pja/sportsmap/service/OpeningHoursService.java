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
import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public void addOpeningHours(OpeningHoursDto openingHoursDto, SportComplex sportComplex) {
        List<OpeningHours> openingHoursList = convertDtoToEntity(openingHoursDto, sportComplex);
        openingHoursRepository.saveAll(openingHoursList);
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

        return now.isAfter(LocalDateTime.from(openingHours.getOpeningTime().atDate(LocalDate.now()))) &&
                now.isBefore(LocalDateTime.from(openingHours.getClosingTime().atDate(LocalDate.now())));
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
                        oh -> new TimeRangeDto(oh.getOpeningTime(), oh.getClosingTime()),
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

    public List<OpeningHours> convertDtoToEntity(OpeningHoursDto openingHoursDto, SportComplex sportComplex) {
        return Stream.of(
                        new AbstractMap.SimpleEntry<>(DayOfWeek.MONDAY, openingHoursDto.monday()),
                        new AbstractMap.SimpleEntry<>(DayOfWeek.TUESDAY, openingHoursDto.tuesday()),
                        new AbstractMap.SimpleEntry<>(DayOfWeek.WEDNESDAY, openingHoursDto.wednesday()),
                        new AbstractMap.SimpleEntry<>(DayOfWeek.THURSDAY, openingHoursDto.thursday()),
                        new AbstractMap.SimpleEntry<>(DayOfWeek.FRIDAY, openingHoursDto.friday()),
                        new AbstractMap.SimpleEntry<>(DayOfWeek.SATURDAY, openingHoursDto.saturday()),
                        new AbstractMap.SimpleEntry<>(DayOfWeek.SUNDAY, openingHoursDto.sunday())
                )
                .filter(entry -> entry.getValue() != null)
                .map(entry -> createOpeningHours(entry.getKey(), entry.getValue(), sportComplex))
                .collect(Collectors.toList());
    }

    private OpeningHours createOpeningHours(DayOfWeek dayOfWeek, TimeRangeDto timeRangeDto, SportComplex sportComplex) {
        OpeningHours openingHours = new OpeningHours();
        openingHours.setOpeningTime(timeRangeDto.getOpenTime());
        openingHours.setClosingTime(timeRangeDto.getCloseTime());
        openingHours.setDayOfWeek(dayOfWeek);
        openingHours.setSportComplex(sportComplex);
        return openingHours;
    }
}
