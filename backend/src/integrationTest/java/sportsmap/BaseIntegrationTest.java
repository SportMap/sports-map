package sportsmap;

import org.junit.ClassRule;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;
import pl.edu.pja.sportsmap.SportsMapApplication;

@Testcontainers
@SpringBootTest(classes = SportsMapApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BaseIntegrationTest {

    @ClassRule
    public static PostgreSQLContainer<BaseDbTestContainerTest> postgreSQLContainer = BaseDbTestContainerTest.getInstance();

    protected RestTemplate restTemplate = new RestTemplate();

    @LocalServerPort
    protected int port;

    static {
        postgreSQLContainer.start();
    }
}
