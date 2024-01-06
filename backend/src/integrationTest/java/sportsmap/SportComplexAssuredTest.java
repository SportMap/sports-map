package sportsmap;

import org.junit.jupiter.api.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.web.util.UriComponentsBuilder;
import pl.edu.pja.sportsmap.dto.SportComplexSimpleDto;

import java.net.URI;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Sql({"file:src/integrationTest/resources/cleanup.sql", "file:src/integrationTest/resources/init.sql"})
public class SportComplexAssuredTest extends BaseIntegrationTest {

    @Test
    public void shouldGetAllComplexes() {
        URI uri = UriComponentsBuilder.newInstance()
                .scheme("http")
                .port(port)
                .host("localhost")
                .path("sport-complexes")
                .build().toUri();

        ResponseEntity<List<SportComplexSimpleDto>> exchange = restTemplate.exchange(
                uri, HttpMethod.GET, null,
                new ParameterizedTypeReference<>() {}
        );

        List<SportComplexSimpleDto> body = exchange.getBody();
        assertEquals(HttpStatus.OK, exchange.getStatusCode());
        assertNotNull(body);
    }

//    @Test
//    public void shouldCreateNewComplex() {
//        AddressDto address = new AddressDto(
//                "Sample Street", "12345", "100", "10", "Sample City"
//        );
//        TimeRangeDto timeRangeDto = new TimeRangeDto(LocalTime.of(8, 0), LocalTime.of(22, 0));
//        OpeningHoursDto openingHours = OpeningHoursDto.builder()
//                .monday(timeRangeDto)
//                .tuesday(timeRangeDto)
//                .wednesday(timeRangeDto)
//                .thursday(timeRangeDto)
//                .friday(timeRangeDto)
//                .saturday(timeRangeDto)
//                .sunday(timeRangeDto)
//                .build();
//
//        AddSportComplexDto sportComplex = AddSportComplexDto.builder()
//                .name("Sample Sport Complex")
//                .description("This is a sample sport complex.")
//                .category(SportComplexCategory.FITNESS)
//                .surface(SportComplexSurface.AKRYL)
//                .website("http://www.samplesportcomplex.com")
//                .phoneNumber("123-456-7890")
//                .address(address)
//                .latitude(40.712776)
//                .longitude(-74.005974)
//                .photo("sample_photo.jpg")
//                .isOpen247(true)
//                .openingHours(openingHours)
//                .build();
//
//
//        URI uri = UriComponentsBuilder.newInstance()
//                .scheme("http")
//                .port(port)
//                .host("localhost")
//                .path("sport-complexes")
//                .build().toUri();
//
//        ResponseEntity<Void> createSportObject = restTemplate.exchange(
//                uri, HttpMethod.POST, new HttpEntity<>(sportComplex),
//                Void.class
//        );
//
//        ResponseEntity<SportComplexDetailedDto> newSportObject = restTemplate.exchange(
//                createSportObject.getHeaders().getLocation(), HttpMethod.GET, null,
//                SportComplexDetailedDto.class
//        );
//
//        assertEquals(HttpStatus.OK, newSportObject.getStatusCode());
//        assertNotNull(newSportObject.getBody());
//        assertEquals("test1", newSportObject.getBody().name());
//    }
}

