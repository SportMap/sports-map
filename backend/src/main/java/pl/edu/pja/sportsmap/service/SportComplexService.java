package pl.edu.pja.sportsmap.service;

import org.springframework.stereotype.Service;
import pl.edu.pja.sportsmap.persistence.dao.SportComplexRepository;
import pl.edu.pja.sportsmap.persistence.model.SportComplex;

import java.util.List;

@Service
public class SportComplexService {
    private final SportComplexRepository sportComplexRepository;

    public SportComplexService(SportComplexRepository sportComplexRepository) {
        this.sportComplexRepository = sportComplexRepository;
    }

    public List<SportComplex> getAllSportComplexes() {
        return sportComplexRepository.findAll();
    }
}
