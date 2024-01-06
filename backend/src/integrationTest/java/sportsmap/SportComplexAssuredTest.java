package sportsmap;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pl.edu.pja.sportsmap.persistence.dao.SportComplexRepository;

public class SportComplexAssuredTest extends BaseIntegrationTest {
    @Autowired
    private SportComplexRepository sportComplexRepository;

    @Test
    public void shouldGetAllComplexes() {
        int test = 2;
        test += 2;
        if (true) {
            ;
        }
    }
}
