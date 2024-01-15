package pl.edu.pja.sportsmap.service;

import org.springframework.stereotype.Service;
import pl.edu.pja.sportsmap.persistence.dao.SportComplexRepository;
import pl.edu.pja.sportsmap.persistence.model.SportComplex;
import pl.edu.pja.sportsmap.persistence.model.User;

import java.util.List;
import java.util.Optional;

@Service
public class SportComplexService {
    private final SportComplexRepository sportComplexRepository;

    public SportComplexService(SportComplexRepository sportComplexRepository) {
        this.sportComplexRepository = sportComplexRepository;
    }

    public List<SportComplex> getAllSportComplexes() {
        return sportComplexRepository.findAll();
    }

    public Optional<SportComplex> getSportComplex(Long id) {
        return sportComplexRepository.findById(id);
    }

    public String getSportComplexNameById (Long sportComplexId){
        Optional<SportComplex> optionalSportComplex = getSportComplex(sportComplexId);
        return optionalSportComplex.map(SportComplex::getName).orElse(null);
    }


}
