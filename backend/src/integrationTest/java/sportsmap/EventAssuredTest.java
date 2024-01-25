package sportsmap;

import org.junit.jupiter.api.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.web.util.UriComponentsBuilder;
import pl.edu.pja.sportsmap.dto.event.GetSimpleShortEventDto;
import pl.edu.pja.sportsmap.dto.event.JoinEventRequestDto;
import pl.edu.pja.sportsmap.dto.event.UnJoinEventRequestDto;

import java.net.URI;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Sql({"file:src/integrationTest/resources/cleanup.sql", "file:src/integrationTest/resources/init.sql"})
public class EventAssuredTest extends BaseIntegrationTest {
    @Test
    void shouldGetEventsForSportComplex() {
        URI uri = UriComponentsBuilder.newInstance()
                .scheme("http")
                .port(port)
                .host("localhost")
                .path("events/1")
                .build().toUri();

        ResponseEntity<List<GetSimpleShortEventDto>> exchange = restTemplate.exchange(
                uri, HttpMethod.GET, null,
                new ParameterizedTypeReference<>() {}
        );

        List<GetSimpleShortEventDto> body = exchange.getBody();
        assertEquals(HttpStatus.OK, exchange.getStatusCode());
        assertNotNull(body);
    }

    @Test
    void shouldJoinEvent() {
        URI uri = UriComponentsBuilder.newInstance()
                .scheme("http")
                .port(port)
                .host("localhost")
                .path("events/join")
                .build().toUri();

        JoinEventRequestDto joinEventRequestDto = new JoinEventRequestDto(1L, 3L);

        ResponseEntity<JoinEventRequestDto> exchange = restTemplate.exchange(
                uri, HttpMethod.POST, new HttpEntity<>(joinEventRequestDto),
                new ParameterizedTypeReference<>() {}
        );

        JoinEventRequestDto body = exchange.getBody();
        assertEquals(HttpStatus.OK, exchange.getStatusCode());
        assertNotNull(body);
    }

    @Test
    void shouldUnjoinEvent() {
        URI uri = UriComponentsBuilder.newInstance()
                .scheme("http")
                .port(port)
                .host("localhost")
                .path("events/unjoin")
                .build().toUri();

        UnJoinEventRequestDto unJoinEventRequestDto = new UnJoinEventRequestDto(3L, 3L);

        ResponseEntity<UnJoinEventRequestDto> exchange = restTemplate.exchange(
                uri, HttpMethod.DELETE, new HttpEntity<>(unJoinEventRequestDto),
                new ParameterizedTypeReference<>() {}
        );

        UnJoinEventRequestDto body = exchange.getBody();
        assertEquals(HttpStatus.OK, exchange.getStatusCode());
        assertNotNull(body);
    }
}
