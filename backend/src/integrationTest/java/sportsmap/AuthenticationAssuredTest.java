package sportsmap;

import org.junit.jupiter.api.Test;
import org.springframework.http.*;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.web.util.UriComponentsBuilder;
import pl.edu.pja.sportsmap.dto.LoginDto;
import pl.edu.pja.sportsmap.dto.SignUpDto;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@Sql({"file:src/integrationTest/resources/cleanup.sql", "file:src/integrationTest/resources/init.sql"})
public class AuthenticationAssuredTest extends BaseIntegrationTest {
    @Test
    void adminShouldLoginAndGetAdditionalCookie() {
        LoginDto loginDto = new LoginDto("admin", "admin");

        URI uri = UriComponentsBuilder.newInstance()
                .scheme("http")
                .port(port)
                .host("localhost")
                .path("login")
                .build().toUri();

        ResponseEntity<Void> loginResponse = restTemplate.exchange(
                uri, HttpMethod.POST, new HttpEntity<>(loginDto),
                Void.class
        );

        HttpHeaders headers = loginResponse.getHeaders();
        List<String> cookies = headers.get(HttpHeaders.SET_COOKIE);
        Map<String, String> cookiesMap = cookies.stream()
                .map(cookie -> cookie.split(";", 2)[0])
                .map(cookie -> cookie.split("=", 2))
                .collect(Collectors.toMap(cookie -> cookie[0], cookie -> cookie.length > 1 ? cookie[1] : ""));

        assertEquals(HttpStatus.OK, loginResponse.getStatusCode());
        assertEquals("true", cookiesMap.get("isAdmin"));
        assertTrue(cookiesMap.containsKey("userId"));
        assertTrue(cookiesMap.containsKey("JSESSIONID"));
    }

    @Test
    void shouldRegisterNewUser() {
        SignUpDto signUpDto = new SignUpDto("uniqueUsername", "email123@mail.com", "password123");

        URI uri = UriComponentsBuilder.newInstance()
                .scheme("http")
                .port(port)
                .host("localhost")
                .path("signup")
                .build().toUri();

        ResponseEntity<Void> loginResponse = restTemplate.exchange(
                uri, HttpMethod.POST, new HttpEntity<>(signUpDto),
                Void.class
        );

        HttpHeaders headers = loginResponse.getHeaders();
        List<String> cookies = headers.get(HttpHeaders.SET_COOKIE);
        Map<String, String> cookiesMap = cookies.stream()
                .map(cookie -> cookie.split(";", 2)[0])
                .map(cookie -> cookie.split("=", 2))
                .collect(Collectors.toMap(cookie -> cookie[0], cookie -> cookie.length > 1 ? cookie[1] : ""));

        assertEquals(HttpStatus.CREATED, loginResponse.getStatusCode());
        assertTrue(cookiesMap.containsKey("JSESSIONID"));
        assertTrue(cookiesMap.containsKey("userId"));
        assertFalse(cookiesMap.containsKey("isAdmin"));
    }
}
