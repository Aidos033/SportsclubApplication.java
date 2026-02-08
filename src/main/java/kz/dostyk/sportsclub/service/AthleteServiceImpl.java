package kz.dostyk.sportsclub.service;

import kz.dostyk.sportsclub.entity.Athlete;
import kz.dostyk.sportsclub.repository.AthleteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AthleteServiceImpl implements AthleteService {

    private final AthleteRepository athleteRepository;

    public AthleteServiceImpl(AthleteRepository athleteRepository) {
        this.athleteRepository = athleteRepository;
    }

    @Override
    public List<Athlete> getAllAthletes() {
        return athleteRepository.findAll();
    }

    @Override
    public Athlete getAthleteById(Long id) {
        return athleteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Athlete not found"));
    }

    @Override
    public Athlete saveAthlete(Athlete athlete) {
        return athleteRepository.save(athlete);
    }

    @Override
    public void deleteAthlete(Long id) {
        athleteRepository.deleteById(id);
    }
}
